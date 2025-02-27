
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread thread;
    Splash()
    {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/splash.jpg")); // used to input image from system
        Image i2 = i1.getImage().getScaledInstance(1100,550, Image.SCALE_DEFAULT); // used to scale image dimensions
//      Scaled image cannot directly placed on the jlabel so we first create a image object and placed scaled image in it
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // make label for image
        add(image); // add image on jframe

       setVisible(true);
       thread = new Thread(this);
       thread.start();
    }
    public void run(){
        try {
            Thread.sleep(6000);
            setVisible(false);
            new Login();
        } catch (Exception e){}
    }

    public static void main(String[] args)
    {
        Splash frame = new Splash();

        for(int i=1; i<=550; i+=6)
        {
            frame.setSize((i*2), i);
            frame.setLocation((690-(i)), (370-(i/2)));
            try
            {
                Thread.sleep(10);
            } catch (Exception e) {}

        }
    }
}
