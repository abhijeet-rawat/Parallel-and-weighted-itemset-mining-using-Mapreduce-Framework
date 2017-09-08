package MyPkg;

import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class NewWordReducer extends Reducer<Text, IntWritable, Text, Text>
{
  public NewWordReducer() {}
  
  public void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, Text>.Context context) throws java.io.IOException, InterruptedException
  {
    long count = 0L;
    long countnum = 0L;
    while (values.iterator().hasNext())
    {
      IntWritable i = (IntWritable)values.iterator().next();
      count += i.get();
      countnum += 1L;
    }
    String str = "";
    Double awsup = Double.valueOf(count * 1.0D / countnum);
    Long tsup = Long.valueOf(countnum);
    str = str + awsup;
    str = str + "\t";
    str = str + tsup;
    String s = key.toString().replace("[", "").replace("]", "").replace(" ", "");
    String[] s1 = s.split(",");
    if ((s1.length > 1) && (awsup.doubleValue() > 2.5D))
    {
      context.write(new Text(str), key);
    }
  }
}
