import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {

    JButton back;
    String username;

    ViewPackage (String username)
    {
        this.username = username;
        setBounds(380,200,900,450);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60,0,300,30);
        add(text);


        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername = new JLabel(username);
        labelusername.setBounds(200,50,150,25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30,90,150,25);
        add(lblpackage);

        JLabel labelpackage= new JLabel();
        labelpackage.setBounds(200,90,150,25);
        add(labelpackage);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30,130,150,25);
        add(lblpersons);

        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(200,130,150,25);
        add(labelpersons);

        JLabel lblname = new JLabel("Id");
        lblname.setBounds(30,170,150,25);
        add(lblname);

        JLabel labelid = new JLabel();
        labelid.setBounds(200,170,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,210,150,25);
        add(lblnumber);

        JLabel labelnumber= new JLabel();
        labelnumber.setBounds(200,210,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,250,150,25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(200,250,150,25);
        add(labelphone);

        JLabel lbladdress = new JLabel("Price");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);

        JLabel labelprice= new JLabel();
        labelprice.setBounds(200,290,150,25);
        add(labelprice);


        back = new JButton("Back");
        back.setBounds(130,360,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420,15,500,400);
        add(image);


        try {
            String query = "select * from bookpackage where username = '"+username+"'";
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery(query);
            while (rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));

            }

        } catch (Exception e) {
            e.printStackTrace();;
        }


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewPackage("");
    }
}