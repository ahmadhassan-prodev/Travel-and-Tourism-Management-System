import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage() {
        setBounds(380, 160, 890, 565);
        String[] package1 = {" GOLD PACKAGE", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour", "Daily Buffet", "Soft Drinks Free", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK PACKAGE", "SUMMER SPECIAL", "Rs 12000/-", "package1.jpg"};
        String[] package2 = {" SILVER PACKAGE", "5 Days and 6 Nights", "Toll Free", " Entrance Free Tickets", "Meet and Greet at Airport", "Welcome Drinks on Arrival", "Night Safari", "Cruise with Dinner", "BOOK NOW", "WINTER SPECIAL", "Rs 24000/-", "package2.jpg"};
        String[] package3 = {" BRONZE PACKAGE", "4 Days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Hard Drinks Free", "Para gliding", "Daily Buffet", "BBQ Dinner", " BOOK NOW", "WINTER SPECIAL", "Rs 30000/-", "package3.jpg"};
        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);
        add(tab);

        setVisible(true);
    }

    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        JLabel L1 = new JLabel(pack[0]);
        L1.setBounds(50, 15, 300, 30);
        L1.setForeground(Color.YELLOW);
        L1.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(L1);

        JLabel L2 = new JLabel(pack[1]);
        L2.setBounds(30, 70, 300, 30);
        L2.setForeground(Color.RED);
        L2.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(L2);

        JLabel L3 = new JLabel(pack[2]);
        L3.setBounds(30, 115, 300, 30);
        L3.setForeground(Color.BLUE);
        L3.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(L3);

        JLabel L4 = new JLabel(pack[3]);
        L4.setBounds(30, 160, 300, 30);
        L4.setForeground(Color.RED);
        L4.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(L4);

        JLabel L5 = new JLabel(pack[4]);
        L5.setBounds(30, 205, 300, 30);
        L5.setForeground(Color.BLUE);
        L5.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(L5);

        JLabel L6 = new JLabel(pack[5]);
        L6.setBounds(30, 250, 300, 30);
        L6.setForeground(Color.RED);
        L6.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(L6);

        JLabel L7 = new JLabel(pack[6]);
        L7.setBounds(30, 295, 300, 30);
        L7.setForeground(Color.BLUE);
        L7.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(L7);

        JLabel L8 = new JLabel(pack[7]);
        L8.setBounds(30, 340, 300, 30);
        L8.setForeground(Color.RED);
        L8.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(L8);


        JLabel L9 = new JLabel(pack[8]);
        L9.setBounds(60, 400, 300, 30);
        L9.setForeground(Color.BLACK);
        L9.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(L9);

        JLabel L10 = new JLabel(pack[9]);
        L10.setBounds(80, 450, 300, 30);
        L10.setForeground(Color.MAGENTA);
        L10.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(L10);

        JLabel L11 = new JLabel(pack[10]);
        L11.setBounds(500, 450, 300, 30);
        L11.setForeground(Color.BLACK);
        L11.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(L11);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/"+pack[11]));
        Image i2= i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel L12= new JLabel(i3);
        L12.setBounds(350,20,500,300);
        p1.add(L12);


        return p1;
    }


        public static void main(String[] args) {
        new CheckPackage();
    }
}
