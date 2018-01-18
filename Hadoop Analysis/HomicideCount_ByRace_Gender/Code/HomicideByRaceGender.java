import java.io.IOException;  
import java.util.*;  
import java.io.StringReader; 
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.conf.*;  
import org.apache.hadoop.io.*;  
import org.apache.hadoop.mapred.*;  
import org.apache.hadoop.util.*;  
  
 public class HomicideByRaceGender {  
  
   public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	   private Text  districtCrime= new Text();
	   private final static IntWritable one = new IntWritable(1);
	   
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
			String line = value.toString();  
         String s[] = line.split(",");
		 int comma=0;
		 int countForRace=0;
		 int countForGender=0;
		 boolean start=false;
		 for(int i=0;i<=9;i++)
		 {
			 if(start==true)
			 {
				 comma++;
				 if(s[i].contains("\""))
				 {
					 countForRace=comma;
					 comma=0;
					 start=false;
				 }
			 }
			 else
			 if(s[i].contains("\""))
			 {
				if(s[i]=="\"")
				 {
					 start=true;
					 comma++;
				 }
			 }
		 }
		 for(int i=0;i<=8;i++)
		 {
			 if(start==true)
			 {
				 comma++;
				 if(s[i].contains("\""))
				 {
					 countForGender=comma-1;
					 comma=0;
					 start=false;
					 System.out.println("Ended"+countForGender);
				 }
			 }
			 else
			 if(start==false)
			 {
				if(s[i].contains("\""))
				 {
					 System.out.println("found start");
					 start=true;
					 comma++;
				 }
			 }
		 }
		 districtCrime.set(s[9+countForRace]+"-"+s[8+countForGender]); 
		 
          output.collect(districtCrime, one);  
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
      JobConf conf = new JobConf(HomicideByRaceGender.class);  
      conf.setJobName("HomicideByRaceGender");  
  
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

