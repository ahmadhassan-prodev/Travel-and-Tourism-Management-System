import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, deletePersonalDetails, checkPackages,
            bookPackages,viewPackages,viewHotels,bookHotels,viewBookedHotels,destinations,payments,about, exit;
    String username, name;
    Dashboard(String username, String name)
    {
        this.username = username;
        this.name = name;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel P1 = new JPanel();
        P1.setLayout(null);
        P1.setBounds(0,0,1500,65);
        P1.setBackground(new Color(0,0,102));
        add(P1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5,0,70,70);
        P1.add(image);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("THOMA", Font.BOLD, 30));
        P1.add(heading);

        JPanel P2 = new JPanel();
        P2.setLayout(null);
        P2.setBounds(0,65,280,1000);
        P2.setBackground(new Color(0,0,102));
        add(P2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,280,49);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("THOMA", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0,0,0,40));
        addPersonalDetails.addActionListener(this);
        P2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,49,280,49);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("THOMA", Font.PLAIN, 20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,10));
        updatePersonalDetails.addActionListener(this);
        P2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,98,280,49);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("THOMA", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,30));
        viewPersonalDetails.addActionListener(this);
        P2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,147,280,49);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("THOMA", Font.PLAIN, 20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,20));
        deletePersonalDetails.addActionListener(this);
        P2.add(deletePersonalDetails);

        checkPackages = new JButton("Check Package");
        checkPackages.setBounds(0,196,280,49);
        checkPackages.setBackground(new Color(0,0,102));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("THOMA", Font.PLAIN, 20));
        checkPackages.setMargin(new Insets(0,0,0,90));
        checkPackages.addActionListener(this);
        P2.add(checkPackages);

        bookPackages = new JButton("Book Package");
        bookPackages.setBounds(0,245,280,49);
        bookPackages.setBackground(new Color(0,0,102));
        bookPackages.setForeground(Color.WHITE);
        bookPackages.setFont(new Font("THOMA", Font.PLAIN, 20));
        bookPackages.setMargin(new Insets(0,0,0,100));
        bookPackages.addActionListener(this);
        P2.add(bookPackages);

        viewPackages = new JButton("View Package");
        viewPackages.setBounds(0,294,280,49);
        viewPackages.setBackground(new Color(0,0,102));
        viewPackages.setForeground(Color.WHITE);
        viewPackages.setFont(new Font("THOMA", Font.PLAIN, 20));
        viewPackages.setMargin(new Insets(0,0,0,100));
        viewPackages.addActionListener(this);
        P2.add(viewPackages);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0,343,280,49);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("THOMA", Font.PLAIN, 20));
        viewHotels.setMargin(new Insets(0,0,0,120));
        viewHotels.addActionListener(this);
        P2.add(viewHotels);

        bookHotels = new JButton("Book Hotel");
        bookHotels.setBounds(0,392,280,49);
        bookHotels.setBackground(new Color(0,0,102));
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setFont(new Font("THOMA", Font.PLAIN, 20));
        bookHotels.setMargin(new Insets(0,0,0,130));
        bookHotels.addActionListener(this);
        P2.add(bookHotels);

        viewBookedHotels = new JButton("View Booked Hotel");
        viewBookedHotels.setBounds(0,441,280,49);
        viewBookedHotels.setBackground(new Color(0,0,102));
        viewBookedHotels.setForeground(Color.WHITE);
        viewBookedHotels.setFont(new Font("THOMA", Font.PLAIN, 20));
        viewBookedHotels.setMargin(new Insets(0,0,0,60));
        viewBookedHotels.addActionListener(this);
        P2.add(viewBookedHotels);

        destinations = new JButton("Destinations");
        destinations.setBounds(0,490,280,49);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("THOMA", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0,0,0,110));
        destinations.addActionListener(this);
        P2.add(destinations);

        payments = new JButton("Payments");
        payments.setBounds(0,539,280,49);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("THOMA", Font.PLAIN, 20));
        payments.setMargin(new Insets(0,0,0,130));
        payments.addActionListener(this);
        P2.add(payments);

        about = new JButton("About");
        about.setBounds(0,588,280,49);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("THOMA", Font.PLAIN, 20));
        about.setMargin(new Insets(0,0,0,160));
        about.addActionListener(this);
        P2.add(about);

        exit = new JButton("Exit");
        exit.setBounds(1270,19,80,25);
        exit.setBackground(new Color(192,192,192));
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("THOMA", Font.PLAIN, 20));
        exit.addActionListener(this);
        P1.add(exit);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1500,900, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(0,0,1500,900);
        add(image2);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setFont(new Font("Raleway", Font.PLAIN, 48));
        text.setBounds(380,70,1200,70);
        text.setForeground(Color.WHITE);
        image2.add(text);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == addPersonalDetails)
            new AddCustomer(username, name);
        else if(ae.getSource() == viewPersonalDetails)
            new ViewDetails(username);
        else if(ae.getSource() == updatePersonalDetails)
            new UpdateCustomer(username, name);
        else if(ae.getSource() == deletePersonalDetails)
            new DeleteDetails(username);
        else if(ae.getSource() == checkPackages)
            new CheckPackage();
        else if(ae.getSource() == bookPackages)
            new BookPackage(username);
        else if(ae.getSource() == viewPackages)
            new ViewPackage(username);
        else if(ae.getSource() == bookHotels)
            new BookHotel(username);
        else if(ae.getSource() == viewBookedHotels)
            new ViewBookedHotel(username);
        else if(ae.getSource() == viewHotels)
            new CheckHotels();
        else if(ae.getSource() == destinations)
            new Destinations();
        else if(ae.getSource() == payments)
            new Payments();
        else if(ae.getSource() == about)
            new About();
        else
            System.exit(0);
    }
    
    public static void main(String[] args) {
        new Dashboard("","");
    }
}
