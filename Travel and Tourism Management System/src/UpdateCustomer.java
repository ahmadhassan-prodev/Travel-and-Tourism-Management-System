import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel lblusername, labelusername, lblname, tfname;
    TextField tfnumber, tfcountry, tfaddress, tfphone, tfemail, tfid, tfgender;
    JButton update, back;
    String username, name;

    UpdateCustomer(String username, String name)
    {
        this.username = username;
        this.name = name;
        setBounds(390,160,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("THOMA", Font.PLAIN, 20));
        add(text);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername = new JLabel(username);
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        tfid = new TextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);

        tfnumber = new TextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);

        tfname = new JLabel(name);
        tfname.setBounds(220,170,150,25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);

        tfgender = new TextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);

        tfcountry = new TextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);

        tfaddress = new TextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,330,150,25);
        add(lblphone);

        tfphone = new TextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30,370,150,25);
        add(lblemail);

        tfemail = new TextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);

        update = new JButton("Update");
        update.setBounds(70,430,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(220,430,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,400,520);
        add(image);
        try {
            String query = "select * from customer where username = '"+username+"'";
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery(query);
            while(rs.next())
            {
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfcountry.setText(rs.getString("country"));
                tfgender.setText(rs.getString("gender"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String id = tfid.getText();
            String number = tfnumber.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            try {
                String query = "update customer set id = '"+id+"', number = '"+number+"', gender = '"+gender+"',country = '"+country+"',address = '"+address+"', phone = '"+phone+"', email = '"+email+"' where username = '"+username+"'";
                Conn n = new Conn();
                n.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("","");
    }
}
