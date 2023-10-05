import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UndeadGameUI extends JFrame { //test
    private ArrayList<Undead> undeadList = new ArrayList<>();

    public UndeadGameUI() {
        setTitle("Undead Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen
// Create a panel to hold the title and buttons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create a custom title label
        ImageIcon titleImage = new ImageIcon("C:\\Users\\janse\\OneDrive\\Desktop\\aa.png"); // Replace with the actual path to your image
        JLabel titleLabel = new JLabel(titleImage);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.RED); // Customize the title color

        // Add the title label to the top of the frame
        mainPanel.add(titleLabel, BorderLayout.NORTH);


        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));

        JButton createUndeadButton = new JButton("Create Undead");
        JButton commandUndeadButton = new JButton("Command Undead");
        JButton displayUndeadButton = new JButton("Display Undead");
        JButton quitButton = new JButton("Quit");

        createUndeadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display an input dialog to get the undead type (1-5) from the user
                String typeInput = JOptionPane.showInputDialog("Enter undead type (1-5):\n1. Zombie\n2. Vampire\n3. Skeleton\n4. Ghost\n5. Lich");

                // Check if the user clicked "Cancel" or closed the dialog
                if (typeInput == null) {
                    return; // No input provided
                }

                // Parse the input as an integer
                int choice;
                try {
                    choice = Integer.parseInt(typeInput);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number (1-5).");
                    return;
                }

                // Check if the input is within the valid range (1-5)
                if (choice < 1 || choice > 5) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number (1-5).");
                    return;
                }

                // Get the undead name from the user
                String name = JOptionPane.showInputDialog("Enter a name for the undead:");

                // Handle empty name
                if (name == null || name.trim().isEmpty()) {

                }

                // Create the undead based on the user's choice
                Undead undead = null;

                switch (choice) {
                    case 1:
                        undead = new Zombie(name);
                        break;
                    case 2:
                        undead = new Vampire(name);
                        break;
                    case 3:
                        undead = new Skeleton(name);
                        break;
                    case 4:
                        undead = new Ghost(name);
                        break;
                    case 5:
                        undead = new Lich(name);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Undead creation failed.");
                }

                // Add the created undead to your ArrayList
                if (undead != null) {
                    undeadList.add(undead);
                    JOptionPane.showMessageDialog(null, undead.getName() + " created!");
                }
            }
        });

        commandUndeadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement commandUndead logic here
            }
        });

        displayUndeadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement displayUndead logic here
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(createUndeadButton);
        buttonPanel.add(commandUndeadButton);
        buttonPanel.add(displayUndeadButton);
        buttonPanel.add(quitButton);

        // Add the button panel to the frame
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);

        setVisible(true);
    }
}
