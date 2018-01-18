package analysis;

import java.io.IOException;  
import java.util.*;  
import java.io.StringReader; 
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.conf.*;  
import org.apache.hadoop.io.*;  
import org.apache.hadoop.mapred.*;  
import org.apache.hadoop.util.*; 

/*
 * DistrictCount MapReduce Job is to find the Crime Count in each of the 25 districts. During the process of checking for 
 * district in the dataset,we encountered some extra comma delimited fields.We did the data parsing and fetched the relevant district 
 * and their crime count.
 */
public class DistrictCount 
{

	public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> 
	{
		   private Text  communityCrime= new Text();
		   private final static IntWritable one = new IntWritable(1);
		   
		public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException 
		{
				String line = value.toString();  
	         String s[] = line.split(",");
			 int comma=0;
			 int countForType=0;
			 int countForComm=0;
			 boolean start=false;
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
						 countForComm=comma-1;
						 comma=0;
						 start=false;
						// System.out.println("Ended"+countForComm);
					 }
				 }
				 else
				 if(start==false)
				 {
					if(s[i].contains("\""))
					 {
						// System.out.println("found start");
						 start=true;
						 comma++;
					 }
				 }
			 }
			 
			 String str=s[11+countForComm];
			 
			 if(str.matches("^[0-9]*$") )
			 {
				 try {
					 if(Integer.parseInt(str)<=33 && str.length()>0)
						 {				 
						 String formatted = String.format("%03d", Integer.parseInt(str));
						 communityCrime.set(formatted); 
				         output.collect(communityCrime, one);  
						}
				 
				 } catch (Exception e) {
					
				}

			 }
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
	      JobConf conf = new JobConf(DistrictCount.class);  
	      conf.setJobName("DistrictCount");  
	  
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
