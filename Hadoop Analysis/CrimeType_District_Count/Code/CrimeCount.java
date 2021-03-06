 import java.io.IOException;  
 import java.util.*;  
import java.io.StringReader; 
 import org.apache.hadoop.fs.Path;  
 import org.apache.hadoop.conf.*;  
 import org.apache.hadoop.io.*;  
 import org.apache.hadoop.mapred.*;  
 import org.apache.hadoop.util.*;  
  
//This Program will read the csv file of Chocago Crime Dataset and produce a result of Crime counts for a Particular Crime Type in a Particulr District

 public class CrimeCount {  
  
//Mapper class to Map the CrimeType-Distrct as key and associates it with a value '1' 
   public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	   private Text  districtCrime= new Text();
	   private final static IntWritable one = new IntWritable(1);
	   
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
			String line = value.toString();   
	
	String s[] = line.split(","); //reads the input file seperated by comma
		 int comma=0;
		 int countForType=0;
		 int countForDistrict=0;
		 boolean start=false;
		//this for loop keeps a count of commas occcuring in a single field so as to increase the index according for reading a particular field
		 for(int i=0;i<=5;i++)
		 {
			 if(start==true)
			 {
				 comma++;
				 if(s[i].contains("\""))
				 {
					 countForType=comma;
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
		 for(int i=0;i<=11;i++)
		 {
			 if(start==true)
			 {
				 comma++;
				 if(s[i].contains("\""))
				 {
					 countForDistrict=comma-1;
					 comma=0;
					 start=false;
					 System.out.println("Ended"+countForDistrict);
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
		 districtCrime.set(s[5+countForType]+"-"+s[11+countForDistrict]); //set the CrimeType-District as key
          output.collect(districtCrime, one);  
		}
   }
   
//Reducer ccount the occurences for the key from the output generated by Mapper
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
      JobConf conf = new JobConf(CrimeCount.class);  
      conf.setJobName("crimeCount");  
  
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

