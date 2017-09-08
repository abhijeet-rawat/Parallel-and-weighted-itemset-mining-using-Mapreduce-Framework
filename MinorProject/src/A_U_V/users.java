/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_U_V;
import static A_U_V.MyJpanelSignUp.*;
//import static A_U_V.MyJPanelSignIn.*;
import java.sql.*;
/**
 *
 * @author goutham
 */
public class users
{
    public users(String uname,String p_word) throws Exception{
        String url="jdbc:mysql://localhost:3306/pawi";
        String user="root";
        String pass="toor";
        String query="select p_word from users where uname='"+uname+"';";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,user,pass);
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        if(rs.getString("p_word").equals(p_word))
            System.out.println("Yeah,You can log in");
        else
            System.out.println("Something's Wrong");
        st.close();
        con.close();
    }
    public users(String name,String uname,String p_word,String email) throws Exception{
        String url="jdbc:mysql://localhost:3306/pawi";
        String user="root";
        String pass="toor";
        String query="insert into users(name,uname,p_word,email) VALUES ('"+name+"','"+uname+"','"+p_word+"','"+email+"');";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,user,pass);
        Statement st= con.createStatement();
        ResultSet rs;
        st.executeUpdate(query);
        //rs.next();
        //System.out.println(rs.getString("uname")+" "+rs.getString("p_word"));
        st.close();
        con.close();
    }
    
}
