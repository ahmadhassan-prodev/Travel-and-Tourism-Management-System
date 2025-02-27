import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payments extends JFrame implements ActionListener{

    JButton pay, back;
    Payments(){
        setBounds(500,200,500,400);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel j1 = new JLabel("Add a Card");
        j1.setBounds(140,0,300,40);
        j1.setForeground(Color.BLACK);
        j1.setFont(new Font("Thoma", Font.BOLD,30));
        add(j1);

        JLabel j2 = new JLabel("Card Number");
        j2.setBounds(65,80,200,25);
        j2.setForeground(Color.BLACK);
        j2.setFont(new Font("Thoma", Font.BOLD,18));
        add(j2);

        JTextField card = new JTextField("47011111111111");
        card.setBounds(65,115,350,25);
        add(card);

        JLabel j3 = new JLabel("Expiration date");
        j3.setBounds(65,160,200,25);
        j3.setForeground(Color.BLACK);
        j3.setFont(new Font("Thoma", Font.BOLD,16));
        add(j3);

        JTextField date = new JTextField("MM/YY");
        date.setBounds(65,195,150,25);
        add(date);

        JLabel j4 = new JLabel(" CVV");
        j4.setBounds(235,160,200,25);
        j4.setForeground(Color.BLACK);
        j4.setFont(new Font("Thoma", Font.BOLD,16));
        add(j4);

        JTextField cvv = new JTextField();
        cvv.setBounds(235,195,180,25);
        add(cvv);

        pay = new JButton("Pay");
        pay.setBounds(90,280,110,30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(250,280,110,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == pay)
        {
            JOptionPane.showMessageDialog(null, "Payment has been Successful");
            setVisible(false);
        }
        else
            setVisible(false);
    }
    public static void main(String[] args) {
        new Payments();
    }


}
