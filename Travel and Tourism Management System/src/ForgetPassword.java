import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    ForgetPassword(){

        setBounds(225,180,900,410);
//        getContentPane().setBackground(Color.gray);

        JPanel P1 = new JPanel();
        P1.setLayout(null);
        P1.setBounds(20, 10, 550, 340);
        P1.setBackground(new Color(65,105,225));
        add(P1);

        JPanel P2 = new JPanel();
        P2.setLayout(null);
        P2.setBounds(550, 0, 350, 410);
        P2.setBackground(Color.white);
        add(P2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(625, 50, 200, 250);
        P2.add(image);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 40, 150, 25);
        lblusername.setFont(new Font("SAN AFROS", Font.BOLD, 18));
        lblusername.setForeground(Color.white);
        P1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(250, 50, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfusername);

        search = new JButton("Search");
        search.setBounds(430, 40, 100, 25);
        search.setFont(new Font("SAN SEFRI", Font.PLAIN, 18));
        search.setForeground(Color.BLACK);
        search.setBackground(new Color(192, 192, 192));
        search.setBorder(BorderFactory.createEmptyBorder());
        search.addActionListener(this);
        P1.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 85, 150, 25);
        lblname.setFont(new Font("SAN AFROS", Font.BOLD, 18));
        lblname.setForeground(Color.white);
        P1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(250, 95, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfname);

        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setBounds(40, 130, 150, 25);
        lblquestion.setFont(new Font("SAN AFROS", Font.BOLD, 18));
        lblquestion.setForeground(Color.white);
        P1.add(lblquestion);

        tfquestion = new JTextField();
        tfquestion.setBounds(250, 140, 180, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfquestion);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(40, 175, 150, 25);
        lblanswer.setFont(new Font("SAN AFROS", Font.BOLD, 18));
        lblanswer.setForeground(Color.white);
        P1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(250, 185, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(430, 175, 100, 25);
        retrieve.setFont(new Font("SAN SEFRI", Font.PLAIN, 18));
        retrieve.setForeground(Color.BLACK);
        retrieve.setBackground(new Color(192, 192, 192));
        retrieve.setBorder(BorderFactory.createEmptyBorder());
        retrieve.addActionListener(this);
        P1.add(retrieve);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 220, 150, 25);
        lblpassword.setFont(new Font("SAN AFROS", Font.BOLD, 18));
        lblpassword.setForeground(Color.white);
        P1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(250, 230, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        P2.add(tfpassword);

        back = new JButton("Back");
        back.setBounds(210, 285, 100, 25);
        back.setFont(new Font("SAN SEFRI", Font.PLAIN, 18));
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(192, 192, 192));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        P1.add(back);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == search)
        {
         try {
             String query = "select * from account where username = '" + tfusername.getText() + "'";
             Conn n = new Conn();
             ResultSet rs = n.s.executeQuery(query);
//             to separate columns and get desired column value
             if(rs.next())
             {
                     tfname.setText(rs.getString("name"));
                     tfquestion.setText(rs.getString("question"));
             } else
             {
                 JOptionPane.showMessageDialog(null, "Invalid Username");
             }
         } catch (Exception e){
             e.printStackTrace();
        }

        } else if (ae.getSource() == retrieve)
        {
            try {
                String query = "select * from account where username = '" + tfusername.getText() + "' AND answer = '"+tfanswer.getText()+"'";
                Conn n = new Conn();
                ResultSet rs = n.s.executeQuery(query);
//             to separate columns and get desired column value
                if(rs.next())
                {
                    tfpassword.setText(rs.getString("password"));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Answer");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == back)
        {
            setVisible(false);
            new Login();
        }
    }


    public static void main(String[] args) {
        new ForgetPassword();
    }
}
