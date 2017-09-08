package MyPkg;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class NewWordCount extends Configured
{
  public NewWordCount() {}
  
  public static void main(String[] args) throws IOException, InterruptedException
  {
    Job job = new Job();
    job.setJarByClass(NewWordCount.class);
    
    FileInputFormat.setInputPaths(job, new Path[] { new Path(args[0]) });
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    job.setMapperClass(NewWordMapper.class);
    job.setReducerClass(NewWordReducer.class);
    
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(org.apache.hadoop.io.IntWritable.class);
    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);
    
    try
    {
      System.exit(job.waitForCompletion(true) ? 0 : -1);
    }
    catch (ClassNotFoundException ex)
    {
      Logger.getLogger(NewWordCount.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
