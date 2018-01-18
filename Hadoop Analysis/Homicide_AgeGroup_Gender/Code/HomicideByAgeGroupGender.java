import java.io.IOException;  
import java.util.*;  
import java.io.StringReader; 
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.conf.*;  
import org.apache.hadoop.io.*;  
import org.apache.hadoop.mapred.*;  
import org.apache.hadoop.util.*;  
 
//This program takes Homicide Dataset combined with crime dataset and gives count of homicide by age group and gender 
 public class HomicideByAgeGroupGender {  
  
   public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	   private Text  districtCrime= new Text();
	   private final static IntWritable one = new IntWritable(1);
	   
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
			String line = value.toString();  
         String s[] = line.split(",");
		 int comma=0;
		 int countForAge=0;
		 int countForGender=0;
		 boolean start=false;

		 for(int i=0;i<=7;i++)
		 {
			 if(start==true)
			 {
				 comma++;
				 if(s[i].contains("\""))
				 {
					 countForAge=comma;
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
		 int age=Integer.valueOf(s[7+countForAge]);
//Categorizes age group base on specific range
		 if(age>=0&&age<1)
		 {
			 districtCrime.set("New Born-"+s[8+countForGender]); 
		 }
		 if(age>=1&&age<=10)
		 {
			 districtCrime.set("Kid-"+s[8+countForGender]); 
		 }
		 if(age>=11&&age<=18)
		 {
			 districtCrime.set("Teen-"+s[8+countForGender]); 
		 }
		 if(age>=19&&age<60)
		 {
			 districtCrime.set("Adult-"+s[8+countForGender]); 
		 }
		 if(age>=60&&age<100)
		 {
			 districtCrime.set("Old-"+s[8+countForGender]); 
		 }
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
      JobConf conf = new JobConf(HomicideByAgeGroupGender.class);  
      conf.setJobName("HomicideByAgeGroupGender");  
  
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

