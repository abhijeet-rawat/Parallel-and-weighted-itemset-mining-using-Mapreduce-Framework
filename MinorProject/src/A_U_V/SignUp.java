package A_U_V;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*This Code Is Designed By #Abhijeet_Rawat For The Purpose Of Minor Project.
*No Part Of This Code Can Be Copied And Used Without The Prior Permission Of Author.
*The Project is Based on Hadoop MapReduce Framework.
*The Project Analyze Retail Data of Customer's Transactions Performed at The Stores. 
*/
class MyJframeSignUp extends JFrame
{
  MyJpanelSignUp mjp;  
  Container ct; 
  MyJframeSignUp(String str)
  {
    super(str);
    this.setLayout(null);
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension d;
    d=tk.getScreenSize();
    ct=this.getContentPane();
    mjp=new MyJpanelSignUp(ct,this);
    mjp.setBounds(0,0,d.width/2+100,d.height/2);
    ct.add(mjp);
    this.setBounds(d.width/4,d.height/6,d.width/2+100,d.height/2);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);  
  }
}
class MyJpanelSignUp extends JPanel implements ActionListener
{
  public JButton b1,b2;
  public JLabel jl[];
  public static JTextField jtf[];
  public static JPasswordField jpf1,jpf2;
  Container obj;
  MyJframeSignUp mjsignup;
  public boolean created=false;
  MyJpanelSignUp(Container obj1, MyJframeSignUp mjsignup)
  { 
    this.mjsignup=mjsignup;  
    obj=obj1;
    if(obj==null)
    {
        System.out.println("I'm already null");
    }
    jl=new JLabel[6];
    jtf=new JTextField[6];
    b1=new JButton("SignUp");
    b2=new JButton("Clear");
    jpf1=new JPasswordField();
    jpf2=new JPasswordField();
    for(int i=0;i<6;i++)
    {
      jl[i]=new JLabel();
      jtf[i]=new JTextField(40);
    } 
    Color c=new Color(220,20,50);
    this.setBackground(Color.white);
    this.setLayout(null);
    jl[0].setText("Enter  The  Details  Below  To  SignUp");
    jl[1].setText("Name :");
    jl[2].setText("User Name :");
    jl[3].setText("Password :");
    jl[4].setText("Confirm Password :");
    jl[5].setText("Email Id :");               
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension d;
    d=tk.getScreenSize();
    this.setVisible(true);
    jl[0].setBounds(d.width/6,d.height/12,d.width/2,d.height/50); 
    jl[1].setBounds(d.width/6,d.height/12+50,d.width/6,d.height/50);
    jl[2].setBounds(d.width/6,d.height/12+100,d.width/6,d.height/50);
    jl[3].setBounds(d.width/6,d.height/12+150,d.width/6,d.height/50);
    jl[4].setBounds(d.width/6,d.height/12+200,d.width/6,d.height/50);
    jl[5].setBounds(d.width/6,d.height/12+250,d.width/6,d.height/50);
    jtf[0].setBounds(d.width/6+150,d.height/12+50,d.width/6,d.height/50);
    jtf[1].setBounds(d.width/6+150,d.height/12+100,d.width/6,d.height/50);
    jpf1.setBounds(d.width/6+150,d.height/12+150,d.width/6,d.height/50);
    jpf2.setBounds(d.width/6+150,d.height/12+200,d.width/6,d.height/50);
    jtf[4].setBounds(d.width/6+150,d.height/12+250,d.width/6,d.height/50);
    b1.setBounds(d.width/6,d.height/12+300,d.width/12,d.height/50);
    b2.setBounds(d.width/6+250,d.height/12+300,d.width/12,d.height/50);
    add(jl[0]);
    add(jl[1]);
    add(jl[2]);
    add(jl[3]);
    add(jl[4]);
    add(jl[5]);
    add(jtf[0]);
    add(jtf[1]);
    add(jpf1);
    add(jpf2);
    add(jtf[4]); 
    b1.addActionListener(this);
    b2.addActionListener(this);
    add(b1);
    add(b2);
  }
  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getActionCommand().equals("SignUp"))
    {
      //code for file handling
      if(!(jpf1.getText().equals(jpf2.getText())))
      {
       JOptionPane.showMessageDialog(null, "Passwords Are Not Matching!!!", "ERROR!!",JOptionPane.ERROR_MESSAGE);
      }
      else
      {   
       JOptionPane.showMessageDialog(null,"Registration is done Successfully!!", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);
          try {
              users u=new users(jtf[0].getText(),jtf[1].getText(),jpf1.getText(),jtf[4].getText());
          } catch (Exception ex) {
              Logger.getLogger(MyJpanelSignUp.class.getName()).log(Level.SEVERE, null, ex);
          }
       if(created==false)
       { 
          MyJPanelSignIn mjsignin=new MyJPanelSignIn(obj,mjsignup);
          Component arr[]=obj.getComponents();
          arr[0].setVisible(false);
          mjsignup.setTitle("SignIn");
          MyJPanelSignIn.jtf.setText("");
          MyJPanelSignIn.jpf.setText("");
          obj.add(mjsignin);   
          created=true;
       }
       else
       {
         Component arr[]=obj.getComponents();
          arr[0].setVisible(false);
          MyJPanelSignIn.jtf.setText("");
          MyJPanelSignIn.jpf.setText("");
          arr[1].setVisible(true);
          mjsignup.setTitle("SignIn");
          
       }
      }
    }
    else if(e.getActionCommand().equals("Clear"))
    {
      for(int i=0;i<5;i++)
      {
        jtf[i].setText("");
      }
      jpf1.setText("");
      jpf2.setText("");
    }  
  }
}
public class SignUp 
{   
  public static void main(String args[])
  {
    MyJframeSignUp mjf=new MyJframeSignUp("Registration Form");
    
  }
}
