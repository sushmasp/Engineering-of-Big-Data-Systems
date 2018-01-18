import java.io.IOException;  
import java.util.*;  
import java.io.StringReader; 
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.conf.*;  
import org.apache.hadoop.io.*;  
import org.apache.hadoop.mapred.*;  
import org.apache.hadoop.util.*;  
  
 public class HomicideByDistrict {  
  //This program takes Homicide Dataset combined with crime dataset to coun the Homicides by District
   public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	   private Text  DistrictCrime= new Text();
	   private final static IntWritable one = new IntWritable(1);
	   
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
			String line = value.toString();  
         String s[] = line.split(",");
		 
		 DistrictCrime.set(s[1]); 
          output.collect(DistrictCrime, one);  
		}
   }
    public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {  
      public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {  
        int sum = 0;  
        while (values.hasNext()) {  
          sum += values.next().get();  
        }  
        output.collect(key, new IntWritable(sum));  
      }  
    }  
  
    public static void main(String[] args) throws Exception {  
      JobConf conf = new JobConf(HomicideByDistrict.class);  
      conf.setJobName("HomicideByDistrict");  
  
      conf.setOutputKeyClass(Text.class);  
      conf.setOutputValueClass(IntWritable.class);  
  
      conf.setMapperClass(Map.class);  
      conf.setCombinerClass(Reduce.class);  
      conf.setReducerClass(Reduce.class);  
  
      conf.setInputFormat(TextInputFormat.class);  
      conf.setOutputFormat(TextOutputFormat.class);  
  
      FileInputFormat.setInputPaths(conf, new Path(args[0]));  
      FileOutputFormat.setOutputPath(conf, new Path(args[1]));  
  
      JobClient.runJob(conf);  
    }  
 }  

