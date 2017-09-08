package A_U_V;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


class MyGraphPlotting
{
  MyGraphPlotting(File f) throws FileNotFoundException, IOException
  {
    BufferedReader br=new BufferedReader(new FileReader(f)); 
    String str="";
    Map awmap= new TreeMap<Double,String>();
    Map tmap=new TreeMap<Integer,String>();
    Map tmap1=new HashMap<String,Integer>();
    Map rankings =new HashMap<Integer,Integer>();
  //  FileWriter fw1=new FileWriter("/home/abhijeet/Desktop/set1");
  //  FileWriter fw2=new FileWriter("/home/abhijeet/Desktop/set2");
    while((str=br.readLine())!=null)
    {
     String fields[]=str.split("\t");
     awmap.put(Double.parseDouble(fields[0]),fields[2]);
     tmap.put(Integer.parseInt(fields[1]),fields[2]);     
    }
    Set myset=tmap.entrySet();
    Iterator itr=myset.iterator();
    int count=1;
    while(itr.hasNext())
    {  
      Map.Entry me=(Map.Entry)(itr.next());
      tmap1.put(me.getValue(),count);
       // System.out.println(me.getValue()+"--->"+count);
     // fw1.write(me.getValue()+"--->"+count+"\n");
      count++;
    }
    Set rankset=awmap.entrySet();
    Iterator itr1=rankset.iterator();
    count=1;
    while(itr1.hasNext())
    {
      Map.Entry me1=(Map.Entry)(itr1.next()); 
      //fw2.write(count+"---->"+me1.getValue()+"\n");
      rankings.put(count,(Integer)tmap1.get(me1.getValue()));
      
      count++;
    }
   Iterator itr2=rankings.entrySet().iterator();
   FileWriter fw=new FileWriter("/home/hadoop/Desktop/set3");
   while(itr2.hasNext())
   {
    Map.Entry me3=(Map.Entry)(itr2.next());   
    if(me3.getValue()!=null)
      fw.write(me3.getKey()+"\t"+me3.getValue()+"\n");
   }
   fw.flush();
  }
}
public class GraphPlotting 
{
  public static void main(String args[]) throws FileNotFoundException, IOException
  {
    File f=new File("/home/hadoop/Desktop/newcodeop/part-r-00000");   
    MyGraphPlotting mgp=new MyGraphPlotting(f);
  }
   
}
