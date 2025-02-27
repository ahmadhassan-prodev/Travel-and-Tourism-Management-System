import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;
    String username;

    ViewBookedHotel (String username)
    {
        this.username = username;
        setBounds(330,155,1000,570);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60,0,400,30);
        add(text);


        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername = new JLabel(username);
        labelusername.setBounds(200,50,150,25);
        add(labelusername);

        JLabel lblhotel = new JLabel("Hotel Name");
        lblhotel.setBounds(30,90,150,25);
        add(lblhotel);

        JLabel labelhotel= new JLabel();
        labelhotel.setBounds(200,90,150,25);
        add(labelhotel);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30,130,150,25);
        add(lblpersons);

        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(200,130,150,25);
        add(labelpersons);

        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);

        JLabel labeldays = new JLabel();
        labeldays.setBounds(200,170,150,25);
        add(labeldays);

        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(30,210,150,25);
        add(lblac);

        JLabel labelac = new JLabel();
        labelac.setBounds(200,210,150,25);
        add(labelac);

        JLabel lblfood = new JLabel("Food Included?");
        lblfood.setBounds(30,250,150,25);
        add(lblfood);

        JLabel labelfood = new JLabel();
        labelfood.setBounds(200,250,150,25);
        add(labelfood);

        JLabel lblname = new JLabel("Id");
        lblname.setBounds(30,290,150,25);
        add(lblname);

        JLabel labelid = new JLabel();
        labelid.setBounds(200,290,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,330,150,25);
        add(lblnumber);

        JLabel labelnumber= new JLabel();
        labelnumber.setBounds(200,330,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(200,370,150,25);
        add(labelphone);

        JLabel lbladdress = new JLabel("Total Cost");
        lbladdress.setBounds(30,410,150,25);
        add(lbladdress);

        JLabel labelcost= new JLabel();
        labelcost.setBounds(200,410,150,25);
        add(labelcost);

        back = new JButton("Back");
        back.setBounds(130,460,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);



        try {
            String query = "select * from bookhotel where username = '"+username+"'";
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery(query);
            while (rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelhotel.setText(rs.getString("hotelname"));
                labelcost.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));
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
        new ViewBookedHotel("");
    }
}
