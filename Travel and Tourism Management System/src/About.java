import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {

    JButton back;
    About(){
        setBounds(470,170,500,530);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel j1 = new JLabel("ABOUT");
        j1.setBounds(180,10,300,40);
        j1.setForeground(Color.RED);
        j1.setFont(new Font("Thoma", Font.BOLD,22));
        add(j1);

        String s = "Welcome to the Travel and Tourism Management System (TTMS), your ultimate partner in" +
                " creating unforgettable travel experiences. Our platform is designed to revolutionize the " +
                "way people explore the world by providing seamless, efficient, and personalized solutions " +
                "for all travel and tourism needs." + "\n\n" + "We provide a comprehensive platform that caters " +
                "to both travelers and travel agencies. From discovering dream destinations to booking accommodations" +
                ", transport, and guided tours, TTMS offers a one-stop solution. Our features include:" + "\n\n" +
                "  * Customizable Travel Packages" + "\n" + "  * Real-Time Booking" + "\n" + "  * Secure Payment Gateway" + "\n" +
                "  * 24/7 Customer Support" + "\n\n" + "Why Choose Us \n\n" + "  * User-Friendly Interface: Easy navigation" +
                " for stress-free planning.\n" + "  * Diverse Options: A wide range of destinations, packages, and services.\n" +
                "  * Technology-Driven: Powered by advanced algorithms and AI to offer personalized recommendations.\n" +
                "  * Commitment to Quality: We partner with trusted providers to ensure top-notch services." + "\n\n \t\t Thank You\n ";

        TextArea text = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        text.setEditable(false);
        text.setFont(new Font("Thoma", Font.PLAIN, 14));
        text.setBounds(18,70,450,330);
        add(text);

        back = new JButton("Back");
        back.setBounds(180,433,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}
