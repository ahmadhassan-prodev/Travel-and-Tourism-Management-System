
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    JTextField tfusername, tfname, tfpassword, tfanswer;
    Choice security;
    int s = 0, c=0;
    Signup() {
        setSize(900, 410);
        setLocation(225, 180);
        setLayout(null); // it is necessary if wec want to make custom layout

        JPanel P1 = new JPanel();
        P1.setLayout(null);
        P1.setBounds(0, 0, 340, 410);
        P1.setBackground(new Color(192, 192, 192));
        add(P1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(65, 90, 220, 220);
        P1.add(image);

        JPanel P2 = new JPanel();
        P2.setLayout(null);
        P2.setBounds(340, 0, 560, 410);
        P2.setBackground(new Color(65, 105, 225));
        add(P2);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 30, 120, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 18));
        lblusername.setForeground(Color.white);
        P2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(210, 30, 200, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfusername);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 75, 120, 25);
        lblname.setFont(new Font("SAN SERIF", Font.BOLD, 18));
        lblname.setForeground(Color.white);
        P2.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(210, 75, 200, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfname);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 120, 120, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.BOLD, 18));
        lblpassword.setForeground(Color.white);
        P2.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(210, 120, 200, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfpassword);

        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setBounds(60, 165, 120, 25);
        lblsecurity.setFont(new Font("SAN SERIF", Font.BOLD, 18));
        lblsecurity.setForeground(Color.white);
        P2.add(lblsecurity);

        security = new Choice();
        security.setBounds(210, 165, 200, 25);
        security.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        security.add("Favourite Drama Serires");
        security.add("Your High School");
        security.add("Your City of Birth");
        security.add("Your Mother Name");
        P2.add(security);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(60, 210, 120, 25);
        lblanswer.setFont(new Font("SAN SERIF", Font.BOLD, 18));
        lblanswer.setForeground(Color.white);
        P2.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(210, 210, 200, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfanswer);

        create = new JButton("Create");
        create.setBounds(80, 290, 110, 30);
        create.setFont(new Font("SAN SEFRI", Font.PLAIN, 18));
        create.setForeground(Color.BLACK);
        create.setBackground(new Color(192, 192, 192));
        create.setBorder(BorderFactory.createEmptyBorder());
        create.addActionListener(this);
        P2.add(create);

        back = new JButton("Back");
        back.setBounds(270, 290, 110, 30);
        back.setFont(new Font("SAN SEFRI", Font.PLAIN, 18));
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(192, 192, 192));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        P2.add(back);

        setVisible(true);
    }
//        override the actionlistener function
        public void actionPerformed(ActionEvent ae)
        {
        if(ae.getSource() == create) {
            String username = tfusername.getText();
            for(int i=0; i<username.length();i++)
            {
                if (username.charAt(i)==' ') {
                    c++;
                }
            }
            if(username.length()==c) {
                JOptionPane.showMessageDialog(null, "Invalid Username");
            }else {
                c=0;
            for (int i = 0; i < username.length(); i++) {
                if (username.charAt(i) == ' ') {
                    s = 1;
                }
            }
            if (s == 1) {
                JOptionPane.showMessageDialog(null, "Invalid username");
                s=0;
            } else {
            String name = tfname.getText();
            for(int i=0; i<name.length();i++)
            {
                if (name.charAt(i)==' ') {
                    c++;
                }
            }
            if(name.length()==c) {
                JOptionPane.showMessageDialog(null, "Invalid name");
            }else{
                c = 0;
            String password = tfpassword.getText();
            for(int i=0; i<password.length();i++)
            {
                if (password.charAt(i)==' ') {
                    c++;
                }
            }
            if(password.length()==c) {
                JOptionPane.showMessageDialog(null, "Invalid Password");
            }else {
                c = 0;
                for (int i = 0; i < password.length(); i++) {
                    if (password.charAt(i) == ' ')
                        s = 1;
                }
                if (s == 1) {
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                } else {
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            for(int i=0; i<answer.length();i++)
            {
                if (answer.charAt(i)==' ') {
                    c++;
                }
            }
            if(answer.length()==c) {
                JOptionPane.showMessageDialog(null, "Invalid Answer");
            }else {
//                send query to database
            String str = "insert into account values('" + username + "', '" + name + "', '" + password + "', '" + question + "', '" + answer + "')";
            String query = "select * from account where username = '" + username + "'";
            try {
//                        make connection with database
                Conn n = new Conn();

//                    execute mysql queries
                ResultSet rs = n.s.executeQuery(query);
                if (rs.next())
                    JOptionPane.showMessageDialog(null, "Username already exist");
                else {
                        n.s.executeUpdate(str);
//                    show a pop up message
                        JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                        setVisible(false);
                        new Login();
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
            }
            }
            }
            }
            }
            } else if (ae.getSource() == back) {
                setVisible(false);
                new Login();
            }

        }


    public static void main(String[] args) {
        new Signup();
    }
}
