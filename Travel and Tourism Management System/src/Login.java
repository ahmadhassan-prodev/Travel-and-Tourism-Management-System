
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton sinup, login, password;
    JTextField tfusername, tfpassword;
    String name, username;


    Login()
    {
        setSize(900, 410);
        setLocation(225,180);
        setLayout(null); // it is necessary if we want to make custom layout

        JPanel P1 = new JPanel();
        P1.setLayout(null);
        P1.setBounds(0,0, 380,410);
        P1.setBackground(new Color(192,192,192));
//        P1.setBackground(new Color(133, 193,233));
        add(P1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(220,220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(85,90,220,220);
        P1.add(image);

        JPanel P2 = new JPanel();
        P2.setLayout(null);
        P2.setBounds(380,0, 520,410);
        P2.setBackground(new Color(65,105,225));
        add(P2);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(70,30,150, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        lblusername.setForeground(Color.white);
        P2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(70, 60, 300,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(70, 105, 150,25);
        lblpassword.setFont(new Font("SAN SERIF", Font.BOLD,20));
        lblpassword.setForeground(Color.white);
        P2.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(70, 135, 300, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(70,190,130,30);
        login.setFont(new Font("SAN SEFRI", Font.PLAIN, 18));
        login.setForeground(Color.BLACK);
        login.setBackground(new Color(192,192,192));
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        P2.add(login);

        sinup = new JButton("Signup");
        sinup.setBounds(240,190,130,30);
        sinup.setFont(new Font("SAN SEFRI", Font.PLAIN, 18));
        sinup.setForeground(Color.BLACK);
        sinup.setBackground(new Color(192,192,192));
        sinup.setBorder(BorderFactory.createEmptyBorder());
        sinup.addActionListener(this);
        P2.add(sinup);

        password = new JButton("Forget Password");
        password.setBounds(120,250,200,30);
        password.setFont(new Font("SAN SEFRI", Font.PLAIN, 18));
        password.setForeground(Color.BLACK);
        password.setBackground(new Color(192,192,192));
        password.setBorder(BorderFactory.createEmptyBorder());
        password.addActionListener(this);
        P2.add(password);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == sinup)
        {
            setVisible(false);
            new Signup();
        }
        else if(ae.getSource() == login)
        {
            String pusername = tfusername.getText();
            String password = tfpassword.getText();

            try {
                String query = "select * from account where username = '" + pusername + "' AND password = '" + password + "'";
                Conn n = new Conn();
                ResultSet rs = n.s.executeQuery(query);
                if (rs.next())
                {
                    tfusername.setText(rs.getString("name"));
                    name = tfusername.getText();
                    tfpassword.setText(rs.getString("username"));
                    username = tfpassword.getText();
                    setVisible(false);
                    new Loading(name,username);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(ae.getSource() == password)
        {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
