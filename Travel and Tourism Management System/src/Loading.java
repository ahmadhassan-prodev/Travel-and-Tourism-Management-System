import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    Thread t;
    JProgressBar bar;
    String name, username;
    public void run()
    {
        try{
            for(int i=1; i<=101; i++)
            {
                int max = bar.getMaximum();
                int value = bar.getValue();

                if(value<max)
                {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username,name);
                }
                Thread.sleep(50);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading( String name, String username)
    {
        this.name = name;
        this.username = username;
        setBounds(380,200,650,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(60,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(210,130,200,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 17));
        add(loading);


        JLabel lblusername = new JLabel("Welcome " + name);
        lblusername.setBounds(20,310,400,40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 17));
        add(lblusername);

        t = new Thread(this);
        t.start();

        setVisible(true);
    }


    public static void main(String[] args) {
        new Loading("","");
    }
}
