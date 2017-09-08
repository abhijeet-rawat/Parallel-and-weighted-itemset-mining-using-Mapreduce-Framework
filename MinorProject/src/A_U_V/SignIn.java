package A_U_V;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author abhijeet
 */

class MyJPanelSignIn extends JPanel implements ActionListener
{
  JLabel jl[];  
  JButton jb1,jb2;
  public static JTextField jtf;
  public static JPasswordField jpf;
  Container ct;
  MyJframeSignUp mjsignup;
  MyJPanelSignIn(Container ct,MyJframeSignUp mjsignup)
  {
   this.ct=ct;
   this.mjsignup=mjsignup;
   this.setLayout(null);
   jl=new JLabel[2];
   jl[0]=new JLabel("UserName :");
   jl[1]=new JLabel("Password :");
   jb1=new JButton("SignIn");
   jb2=new JButton("SignUp");
   jtf=new JTextField(15);
   jpf=new JPasswordField(15);
   Toolkit tk=Toolkit.getDefaultToolkit();
   Dimension d=tk.getScreenSize();
   jl[0].setBounds(d.width/8,d.height/12,d.width/2,d.height/50); 
   jl[1].setBounds(d.width/8,d.height/12+50,d.width/6,d.height/50);
   jtf.setBounds(d.width/8+150,d.height/12,d.width/6,d.height/50);
   jpf.setBounds(d.width/8+150,d.height/12+50,d.width/6,d.height/50);
   jb1.setBounds(d.width/8,d.height/12+100,d.width/12,d.height/50);
   jb2.setBounds(d.width/8+250,d.height/12+100,d.width/12,d.height/50);
   this.setBackground(Color.white);
   add(jl[0]);
   add(jl[1]);
   add(jtf);
   add(jpf);
   jb1.addActionListener(this);
   jb2.addActionListener(this);
   add(jb1);
   add(jb2);
   this.setBounds(0,0,d.width/2+100,d.height/2);
  }
  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getActionCommand().equals("SignUp"))
    {
       //MyJpanelSignUp mjpsignup=new MyJpanelSignUp(ct,mjsignup);
       Component arr[]=ct.getComponents();
       //System.out.println(arr[0]);
       arr[1].setVisible(false);
       arr[0].setVisible(true);
       mjsignup.setTitle("RegistrationForm");
       MyJpanelSignUp.jpf1.setText("");
       MyJpanelSignUp.jpf2.setText("");
       for(JTextField jt:MyJpanelSignUp.jtf)
       {
          jt.setText("");
       }
       //ct.add(mjpsignup);  
    }
    else
    {
        try {
            //System.out.println(jtf.getText()+" "+jpf.getText());
            users u=new users(jtf.getText(),jpf.getText());
        } catch (Exception ex) {
            Logger.getLogger(MyJPanelSignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
      Component arr[]=ct.getComponents();
      MyJPanelDataServer mjds=new MyJPanelDataServer();
      ct.add(mjds);
      arr[0].setVisible(false);
      arr[1].setVisible(false);
      
    }
  }
}

