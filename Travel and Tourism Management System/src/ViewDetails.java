import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewDetails extends JFrame implements ActionListener {

    JButton back;
    String username;

    ViewDetails (String username)
    {
        this.username = username;
        setBounds(390,160,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel tfusername = new JLabel(username);
        tfusername.setBounds(200,50,150,25);
        add(tfusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30,100,150,25);
        add(lblid);

         JLabel tfid= new JLabel();
        tfid.setBounds(200,100,150,25);
        add(tfid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,150,150,25);
        add(lblnumber);

        JLabel tfnumber = new JLabel();
        tfnumber.setBounds(200,150,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,200,150,25);
        add(lblname);

        JLabel tfname= new JLabel();
        tfname.setBounds(200,200,150,25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,250,150,25);
        add(lblgender);

        JLabel tfgender= new JLabel();
        tfgender.setBounds(200,250,150,25);
        add(tfgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(490,50,150,25);
        add(lblcountry);

        JLabel tfcountry = new JLabel();
        tfcountry.setBounds(660,50,150,25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(490,100,150,25);
        add(lbladdress);

        JLabel tfadress= new JLabel();
        tfadress.setBounds(660,100,150,25);
        add(tfadress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(490,150,150,25);
        add(lblphone);

        JLabel tfphone = new JLabel();
        tfphone.setBounds(660,150,150,25);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(490,200,150,25);
        add(lblemail);

        JLabel tfemail= new JLabel();
        tfemail.setBounds(660,200,150,25);
        add(tfemail);

        back = new JButton("Back");
        back.setBounds(350,300,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,320,600,200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(580,320,600,200);
        add(image2);

        try {
            String query = "select * from customer where username = '"+username+"'";
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery(query);
            while (rs.next())
            {
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfadress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfname.setText(rs.getString("name"));
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
        new ViewDetails("");
    }
}
