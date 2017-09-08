package A_U_V;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author abhijeet
 */
class MyJPanelDataServer extends JPanel implements ActionListener 
{
  public JLabel jl[];
  public JButton  jb,jb1,jb2,jb3,jb4,jb5,jb6,jb7;  
  public JTextField jtf,jtf1;
  public String hdpath=null,localpath=null,oppath=null;//hdpath comes from mining data
  MyJPanelDataServer()
  {   
   Dimension d;
   Toolkit tk=Toolkit.getDefaultToolkit();
   d=tk.getScreenSize();
   jl=new JLabel[9];
   for(int i=0;i<=8;i++)
   {
     jl[i]=new JLabel();
   }
   jb1=new JButton("PaWI:Parallel Weighted Itemset Mining by means of MapReduce");
   jb2=new JButton("** Data Server **");
   jb3=new JButton("Upload Data");
   jb4=new JButton("Download Data");
   jb5=new JButton("Perform Mining");
   jb6=new JButton("Browse");
   jb7=new JButton("Exit");
   jtf=new JTextField(15);
   jtf1=new JTextField(20);
   this.setLayout(null);
   this.setBackground(Color.white);
   jb1.setBounds(0,0,d.width/2+100,d.height/40+2);
   jb1.setBackground(Color.LIGHT_GRAY);
   jb1.setForeground(Color.black);
   jb2.setBounds(0,d.height/40,d.width/2+100,d.height/40);
   jb2.setBackground(Color.LIGHT_GRAY);
   jb2.setForeground(Color.black);
  
   jl[0]=new JLabel(new ImageIcon("uploadimg.png"));
   jl[1]=new JLabel(new ImageIcon("downloadimg.png"));
   jl[2]=new JLabel("Enter HDFS File name");
   jl[3]=new JLabel("Enter Valid File Name");
   jl[4]=new JLabel("File Uploaded To HDFS Successfully!!");
   jl[5]=new JLabel(new ImageIcon("datamining.png"));
   jl[6]=new JLabel("Enter Location To Store File");
   jl[7]=new JLabel("Browse local storage path correctly");
   jl[8]=new JLabel("File not exists in HDFS");
   jl[0].setBounds(d.width/20,d.height/20+50,d.width/8,d.height/6+10);
   jl[1].setBounds(d.width/5+d.width/8+60,d.height/20-10,d.width/8,d.height/6+100);
   jl[5].setBounds(d.width/5,d.height/20+50,d.width/8,d.height/6+10);
   jl[2].setBounds(10,d.height/20+50+d.height/6+10+10,d.width/8,d.height/40);
   jl[6].setBounds(d.width/5+d.width/8+20,d.height/20+50+d.height/6+10+10,d.width/8,d.height/40);
   jtf.setBounds(d.width/20+70,d.height/20+50+d.height/6+10+10,d.width/10,d.height/40);
   jtf1.setBounds(d.width/5+d.width/8+d.width/9+10,d.height/20+50+d.height/6+10+10,d.width/10,d.height/40);
   jb6.setBounds(d.width/5+d.width/8+d.width/8+40,d.height/20+50+d.height/6+10+10+d.height/40,d.width/20,d.height/45);
   jb5.setBounds(d.width/5,d.height/20+50+d.height/6+10+10,d.width/8,d.height/40);
   
   jb3.setBounds(d.width/20,d.height/20+50+d.height/6+10+10+50,d.width/8,d.height/40);
   jb4.setBounds(d.width/5+d.width/8+60,d.height/20+50+d.height/6+10+10+50+10,d.width/8,d.height/40);
   jb7.setBounds(d.width/5+d.width/8+60,d.height/20+50+d.height/6+10+10+50+10+d.height/40+50,d.width/15,d.height/40);
   jl[7].setBounds(d.width/5+d.width/8+60,d.height/20+50+d.height/6+10+10+50+50,d.width/8,d.height/40);
   jl[3].setBounds(d.width/20,d.height/20+50+d.height/6+10+10+50+50,d.width/8,d.height/40);
   jl[4].setBounds(d.width/20,d.height/20+50+d.height/6+10+10+50+50,d.width/7,d.height/40);
   jl[8].setBounds(d.width/5,d.height/20+50+d.height/6+10+10+50+50,d.width/8,d.height/40);
   jl[3].setForeground(Color.RED);
   jl[7].setForeground(Color.red);
   jl[8].setForeground(Color.red);
   jl[3].setVisible(false);
   jl[4].setVisible(false);
   jl[7].setVisible(false);
   jl[8].setVisible(false);
   jb3.addActionListener(this);
   jb4.addActionListener(this);
   jb5.addActionListener(this);
   jb6.addActionListener(this);
   jb7.addActionListener(this);
   add(jb3);
   add(jb4);
   add(jb5);
   add(jl[1]);
   add(jl[0]);
   add(jl[2]);
   add(jl[3]);
   add(jl[4]);
   add(jl[5]);
   add(jl[6]);
   add(jl[7]);
   add(jl[8]);
   add(jb1);
   add(jb2);
   add(jb6);
   add(jb7);
   add(jtf);
   add(jtf1);
   this.setBounds(0,0,d.width/2+100,d.height/2);
  }  
  @Override
  public void actionPerformed(ActionEvent e) 
  {
    
    if(e.getActionCommand().equals("Upload Data"))
    {
     if(!(jtf.getText().equals("")))
     {
      jl[3].setVisible(false);
      JFileChooser fc=new JFileChooser();
      fc.setCurrentDirectory(new File("/home/hadoop/Desktop"));
      fc.setDialogTitle("Choose The File To Be stored in HDFS");
      fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
      if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
      {
        String pathfile=fc.getSelectedFile().getAbsolutePath().toString();
        String hdfspath=jtf.getText();
        hdpath="/user/hadoop/"+hdfspath;
        String cmd[] = {"/home/hadoop/NetBeansProjects/MinorProject/uploaddata.sh",pathfile,hdfspath};
        Process p=null;
          try 
          {
              p = Runtime.getRuntime().exec(cmd);
          } 
          catch (IOException ex) 
          {
            ex.printStackTrace();
          }
          int exitCode;
          try 
          {
              exitCode = p.waitFor();
              if(exitCode==0)
              {
                jl[4].setForeground(Color.green);
                jl[4].setVisible(true);
              }
              else
              {
                jl[4].setForeground(Color.red);
                jl[4].setText("Error While Uploading File");
                jl[4].setVisible(true);
              }
          } 
          catch (InterruptedException ex)
          {
             ex.printStackTrace();
          }                  
      }
     }
     else
     {  
       jl[3].setVisible(true);
     }
    }
    else if(e.getActionCommand().equals("Download Data"))
    {
      String savingpath=jtf1.getText();
        System.out.println(savingpath);
      if(savingpath==null)
      {
        jl[7].setForeground(Color.red);
        jl[7].setVisible(true);
      }
      else
      {
        if(oppath!=null)
        {
          jl[7].setVisible(false);   
          String cmd[] = {"/home/hadoop/NetBeansProjects/MinorProject/downloaddata.sh",oppath,savingpath};
          Process p=null;
          try 
          {
              p = Runtime.getRuntime().exec(cmd);
          } 
          catch (IOException ex) 
          {
            ex.printStackTrace();
          }
          int exitCode;
          try 
          {
              exitCode = p.waitFor();
              System.out.println(oppath);
              System.out.println(exitCode);
              if(exitCode==0)
              {
                jl[7].setForeground(Color.green);
                jl[7].setText("File downloaded successfully!!");
                jl[7].setVisible(true);
              }
              else
              {
                jl[7].setForeground(Color.red);
                jl[7].setText("Error While downloading o/p File");
                jl[7].setVisible(true);
              }
          } 
          catch (InterruptedException ex)
          {
             ex.printStackTrace();
          }       
        }
        else
        {
         jl[7].setText(" O/P File not exists in HDFS");   
         jl[7].setVisible(true); 
        }
      }
      
    }
    else if(e.getActionCommand().equals("Browse"))
    {
      JFileChooser fc=new JFileChooser();
      fc.setCurrentDirectory(new File("/home/hadoop/Desktop"));
      fc.setDialogTitle("Choose The Directory where mined data to be stored");
      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
      {
        localpath =fc.getSelectedFile().getAbsolutePath().toString();
        if(localpath!=null)
        {
          jtf1.setText(localpath);
        }
      }
    }
    else if(e.getActionCommand().equals("Perform Mining"))
    {
     if(hdpath!=null)
        {
          jl[8].setVisible(false); 
           oppath="/"+jtf.getText()+"op";
            System.out.println(hdpath);
          String cmd[] = {"/home/hadoop/NetBeansProjects/MinorProject/performmining.sh",hdpath,oppath};
          Process p=null;
          try 
          {
              p = Runtime.getRuntime().exec(cmd);
          } 
          catch (IOException ex) 
          {
            ex.printStackTrace();
          }
          int exitCode;
          try 
          {
              exitCode = p.waitFor();
              System.out.println(oppath);
              
              System.out.println(exitCode);
              if(exitCode==0)
              {
                jl[8].setForeground(Color.green);
                jl[8].setText("Mnining done successfully!!");
                jl[8].setVisible(true);
              }
              else
              {
                jl[8].setForeground(Color.red);
                jl[8].setText("Error While Mining");
                jl[8].setVisible(true);
              }
          } 
          catch (InterruptedException ex)
          {
             ex.printStackTrace();
          }       
        }
        else
        {
         jl[8].setText("File not exists in HDFS");   
         jl[8].setVisible(true); 
        }   
    }
    else if(e.getActionCommand().equals("Exit"))
    {
      System.exit(0);
    }
  }
}
/*class InputBox extends JFrame implements ActionListener
{
  public static JTextField jtf;
  public JButton jb;
  public JLabel jl;
  public static boolean status=false;
  Container ct;
  InputBox(String str)
  {
    super(str);
    setLayout(null);
    jtf =new JTextField(20);
    jb=new JButton("OK");
    jl=new JLabel("Enter the Hdfs File Name:");
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension d=tk.getScreenSize();
    Font f=new Font("Arial",Font.PLAIN,15);
    setBounds(d.width/3,d.height/4,d.width/4,d.height/5);
    jl.setBounds(100,50,d.width/8,d.height/30);
    jtf.setBounds(290,50,d.width/15,d.height/45);
    jtf.setFont(f);
    jb.setBounds(170,50+d.height/25+20,d.width/20,d.height/25);
    jb.addActionListener(this);
    ct=this.getContentPane();
    ct.add(jtf);
    ct.add(jb);
    ct.add(jl);
    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    this.setVisible(true);
    
  }
  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(!jtf.getText().equals(null))
    {
      status=true;
     
    }
  }
}*/
public class DataServer
{

}

