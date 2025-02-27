import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel lblusername, labelusername, lblname, tfname;
    TextField tfnumber, tfcountry, tfaddress, tfphone, tfemail;
    JRadioButton rmale, rfemale;
    JComboBox comboid;
    JButton add, back;
    String username, name;

    AddCustomer(String username, String name)
    {
        this.username = username;
        this.name = name;

        setBounds(390,160,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername = new JLabel(username);
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        comboid = new JComboBox(new String[] {"Passport", "National ID card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

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

        rmale = new JRadioButton("Male");
        rmale.setBounds(220,210,70 ,25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300,210,70 ,25);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

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

        add = new JButton("Add");
        add.setBounds(70,430,100,25);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

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





        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String gender = null;
            if(rmale.isSelected())
                gender = "Male";
            else if(rfemale.isSelected())
                gender = "Female";
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                Conn n = new Conn();
                n.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Succesfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == back)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("","");
    }
}
