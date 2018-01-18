 import java.io.IOException;  
 import java.util.*; 
import java.text.SimpleDateFormat;
import java.io.StringReader; 
 import java.text.DateFormat;
 import org.apache.hadoop.fs.Path;  
 import org.apache.hadoop.conf.*;  
 import org.apache.hadoop.io.*;  
 import org.apache.hadoop.mapred.*;  
 import org.apache.hadoop.util.*; 

//This Program will read the csv file of Chocago Crime Dataset and produce a result of Crime counts fora time range in a Particulr District  
 public class DistrictTime {  
  
   public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	   private Text  communityCrime= new Text();
	   private Text  t= new Text();
	    private final static IntWritable one = new IntWritable(1);
	public void map(LongWritable key, Text value,  OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
			String line = value.toString();  
         String s[] = line.split(",");
		 int comma=0;
		 int countForType=0;
		 int countForComm=0;
		 boolean start=false;
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
				 }
			 }
			 else
			 if(start==false)
			 {
				if(s[i].contains("\""))
				 {
					 start=true;
					 comma++;
				 }
			 }
		 }
		 
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		 String date=s[2];
		 Date dt=new Date();
		 try{
			 dt = formatter.parse(date); // parsed the date in String type to Date Type
		 }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
		 int hours=dt.getHours(); //Extract hours from date to categorize them into ddifferent ranges like (Early Morning,Late Night,Late Morning)

		 if(hours>=5&&hours<=8)
		{
			communityCrime.set(s[11+countForComm]+"-Early Morning");
		}
		if(hours>=11&&hours<=12)
		{
			communityCrime.set(s[11+countForComm]+"-Late Morning");
		}
		if(hours>=13&&hours<=15)
		{
			communityCrime.set(s[11+countForComm]+"-Early Afternoon");
		}
		if(hours>=16&&hours<=17)
		{
			communityCrime.set(s[11+countForComm]+"-Late Afternoon");
		}
		if(hours>=17&&hours<=21)
		{
			communityCrime.set(s[11+countForComm]+"-Early Evening");
		}
		if(hours>=21&&hours<=24)
		{
			communityCrime.set(s[11+countForComm]+"-Night");
		}
		if(hours>=0&&hours<=4)
		{
			communityCrime.set(s[11+countForComm]+"-Night");
		}
				 
		 output.collect(communityCrime,one);  
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
      JobConf conf = new JobConf(DistrictTime.class);  
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

