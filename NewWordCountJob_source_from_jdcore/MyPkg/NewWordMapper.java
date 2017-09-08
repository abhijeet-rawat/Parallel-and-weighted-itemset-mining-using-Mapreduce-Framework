package MyPkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NewWordMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
  public static final int MAX = 100000000;
  
  public NewWordMapper() {}
  
  public void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
  {
    String s = value.toString();
    Set<String> itemsets = getItemsets(s.split(" "));
    for (String str1 : itemsets)
    {
      String[] str2 = str1.replace("[", "").replace("]", "").split(",");
      List<String> lst = new ArrayList();
      int minval = 100000000;
      for (String str3 : str2)
      {
        String[] t = str3.replace("(", "").replace(")", "").replace(" ", "").split("\t");
        lst.add(t[0]);
        if (minval > Integer.parseInt(t[1]))
        {
          minval = Integer.parseInt(t[1]);
        }
      }
      try
      {
        context.write(new Text(lst.toString()), new IntWritable(minval));
      }
      catch (java.io.IOException|InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static Set<String> getItemsets(String[] items) {
    Set<String> itemsets = new TreeSet();
    int len = items.length;
    int[] masks = new int[len];
    for (int i = 0; i < len; i++)
    {
      masks[i] = (1 << i);
    }
    
    for (int i = 0; i < 1 << len; i++)
    {
      Set<String> newset = new TreeSet();
      for (int j = 0; j < len; j++)
      {
        if ((masks[j] & i) != 0)
        {
          newset.add(items[j]);
        }
        if ((j == len - 1) && (newset.size() > 0) && (newset.size() <= len))
        {
          itemsets.add(newset.toString());
        }
      }
    }
    return itemsets;
  }
}
