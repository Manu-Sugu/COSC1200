/*
 * Name: Manu Sugunakumar
 * Date: April 21, 2023
 * App Name: Bilingual App
 * Description: App allows user to choose between english and french then starts the student registration app in the selected language.
 */

// For the GUI 
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

// For working with files
import java.io.*;
import java.util.Scanner;

public class BilingualApp 
{
    // Components
    static JFrame window;
    static JPanel panel;
    static JLabel welcomeLabel;
    static JLabel nameLabel;
    static JTextField nameTextField;
    static JLabel programLabel;
    static JTextField programTextField;
    static JLabel studentNumberLabel;
    static JSpinner studentNumberSpinner;
    static JButton loadButton;
    static JButton registerButton;
    static GridBagConstraints gridbag; // Layout manager

    // Array to store language
    static String[] language = new String[12];

    /**
     * Opens a Language selection popup then uses the load language function to load english or french
     */
    public static void languageSelection()
    {
        // Constants
        final int ENGLISH = 0, FRENCH = 1;

        // String array that keeps the options available
        String[] options = {"English", "French"};

        // Show option dialogue with 2 buttons
        int selectedOption = JOptionPane.showOptionDialog(null, "Please Choose Your Language: | S'll vous plaît choisissez votre langue:", "Language Selection | Sélection de la langue",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon("English.png"), options, null);

        switch(selectedOption)
        {
            default: // Default to english
            case ENGLISH:
                loadLanguage("English.lang");
                break;
            case FRENCH:
                loadLanguage("French.lang");
                break;
        }
    }

    /**
     * Loads a language file based on the user selection
     */
    public static void loadLanguage(String fileName)
    {
        // Variables
        File file = new File(fileName);
        Scanner fileScanner;

        // Start reading the file
        try 
        {
            // opens the file scanner
            fileScanner = new Scanner(file, "UTF-8");

            // For loop to loop through each line to store into the array
            for(int count = 0; count < 12; count++)
            {
                language[count] = fileScanner.nextLine();
            }

            // Finished reading the file
            fileScanner.close();
        } 
        catch (Exception e) 
        {
            // Error in case could not open the file
            JOptionPane.showMessageDialog(window,"Could not open " + file.getName(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Runs when the register button is clicked
     */
    public static void registerClick()
    {
        // Variables
        String filename;
        File file;
        FileWriter fileWriter;

        // Extract name and program name from GUI
        String name = nameTextField.getText();
        String programName = programTextField.getText();
        int studentNumber = (int) studentNumberSpinner.getValue();

        // Error if all fields are blank
        if(name.equals("") || programName.equals(""))
            JOptionPane.showMessageDialog(window, language[7], language[6], JOptionPane.ERROR_MESSAGE);
        else
        {
            // Format the file name
            //  0  1
            // Manu Sugunakumar → Manu.data
            filename = studentNumber + ".data";

            // Create a new file
            file = new File(filename);

            try 
            {
                // Prepare to write in the file
                fileWriter = new FileWriter(file);

                // Start writing in the file
                fileWriter.write(name + "\n" + programName + "\n" + studentNumber);

                // Finished writing, so close the file
                fileWriter.close();

                // Tell the user that the student was saved in the file.data 
                JOptionPane.showMessageDialog(window, language[10] + filename, language[9], JOptionPane.INFORMATION_MESSAGE);
            } 
            // Error in case we can't write in the file
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(window, "Cannot write in the file: " + filename, "Error!", JOptionPane.ERROR_MESSAGE);
            }

            // Clear the GUI
            nameTextField.setText("");   // Clear the name
            programTextField.setText(""); // Clear the program name 
            studentNumberSpinner.setValue(0); // Set the student number to 0
        }
    }

    /**
     * Button that runs when load click
     */
    public static void loadClick()
    {
        // Variables
        JFileChooser fileChooser;
        File file;
        Scanner fileScanner;
        String studentName = "";
        String studentProgram = "";
        int studentNumber = 0;

        // Creating a file chooser dialogue
        fileChooser = new JFileChooser(".");  // . means current directory

        // File filter that only shows files ".save"
        fileChooser.setFileFilter(new FileNameExtensionFilter("Student data", "data"));

        // window is the parent component
        // User chose file and clicked [Open]
        if(fileChooser.showOpenDialog(window) == JFileChooser.APPROVE_OPTION)
        {
            // Open the selected file
            file = fileChooser.getSelectedFile();

            // Start reading the file
            try 
            {
                fileScanner = new Scanner(file);
                
                // Read data from the file
                studentName = fileScanner.nextLine();
                studentProgram = fileScanner.nextLine();
                studentNumber = fileScanner.nextInt();

                // Finished reading the file
                fileScanner.close();
            } 
            catch (FileNotFoundException e) 
            {
                // Error in case could not open the file
                JOptionPane.showMessageDialog(window,"Could not open " + file.getName(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Update the GUI
            nameTextField.setText(studentName);
            programTextField.setText(studentProgram);
            studentNumberSpinner.setValue(studentNumber);
        }
    }

    public static void main(String[] args) 
    {
        // Optional - Make it look like the native OS
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch (Exception e) {}

        // Variables
        Font inputFont = new Font("Comic Sans MS", Font.PLAIN, 18);

        // Makes popup to prompt user for a language seelction
        languageSelection();

        // Setup the window for app
        window = new JFrame(language[0]);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Will close the app when you click the X
        window.setIconImage(new ImageIcon(language[11]).getImage()); // Any PNG file
        window.setResizable(false); // Can't resize

        // Panel - Container for all the components
        panel = new JPanel(new GridBagLayout());
        gridbag = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Welcome label
        welcomeLabel = new JLabel(language[1]);
        welcomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

        // Name label
        nameLabel = new JLabel(language[2]);
        nameLabel.setFont(inputFont);

        // Name TextField
        nameTextField = new JTextField();
        nameTextField.setColumns(30);
        nameTextField.setFont(inputFont);

        // Program label
        programLabel = new JLabel(language[3]);
        programLabel.setFont(inputFont);

        // Program TextField
        programTextField = new JTextField();
        programTextField.setColumns(30);
        programTextField.setFont(inputFont);

        // Student number label
        studentNumberLabel = new JLabel(language[4]);
        studentNumberLabel.setFont(inputFont);

        // Student number spinner
        studentNumberSpinner = new JSpinner(new SpinnerNumberModel(0,0,null,1));
        studentNumberSpinner.setFont(inputFont);
        // Checks wether it is french or english to set the width of the spinner beacause the button is longer in french then in english
        if(language[5].equals("Load"))
            studentNumberSpinner.setPreferredSize(new Dimension(353, studentNumberSpinner.getPreferredSize().height));
        
        else
            studentNumberSpinner.setPreferredSize(new Dimension(325, studentNumberSpinner.getPreferredSize().height));
        

        // Load Button
        loadButton = new JButton(language[5]);
        loadButton.setFont(inputFont);
        loadButton.addActionListener(event -> loadClick()); // Calls a method when clicked

        // Register Button
        registerButton = new JButton(language[6]);
        registerButton.setFont(inputFont);
        registerButton.addActionListener(event -> registerClick()); // Calls a method when clicked

        // Place the components
        window.add(panel);

        // Place the welcome label
        gridbag.gridy = 0;
        panel.add(welcomeLabel, gridbag);
        
        // Place the name label
        gridbag.anchor = GridBagConstraints.WEST;  // Left
        gridbag.gridy = 1;
        panel.add(nameLabel, gridbag);

        // Place the name textfield
        gridbag.gridy = 2;
        panel.add(nameTextField, gridbag);

        // Place the program label
        gridbag.gridy = 3;
        panel.add(programLabel, gridbag);

        // Place the program textfield
        gridbag.gridy = 4;
        panel.add(programTextField, gridbag);

        // Place the student number label
        gridbag.gridy = 5;
        panel.add(studentNumberLabel, gridbag);

        // Place the student number spinner
        gridbag.gridy = 6;
        gridbag.gridx = 0;
        panel.add(studentNumberSpinner, gridbag);

        // Place the load button
        gridbag.anchor = GridBagConstraints.EAST;  // right
        panel.add(loadButton, gridbag);

        // Place the button
        gridbag.gridy = 7;
        gridbag.fill = GridBagConstraints.HORIZONTAL;  // Use all available horizontal space
        panel.add(registerButton,gridbag);

        // display the window
        window.pack(); // Resize to fit all the components
        window.setVisible(true);
    }    
}