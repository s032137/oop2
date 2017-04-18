
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;




public class Gui {
    private JFrame mainFrame;
    //private JLabel headerLabel;
    //private JLabel statusLabel;
    private JPanel controlPanel;
    
    public Gui() {
        prepareGUI();
    }
    
    private void prepareGUI(){
      mainFrame = new JFrame("OOP Assignment");
      mainFrame.setSize(400,400);
      mainFrame.setResizable(false);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(controlPanel);
    }
    
    
     public void contentObjects() throws IOException {
         
         //Initialize GUI objects
         JLabel sidLabel = new JLabel("Staff ID: ");
         final JTextField sidText = new JTextField(1);
         JLabel nameLabel = new JLabel("Name: ");
         final JTextField nameText = new JTextField(3);
         JLabel ageLabel = new JLabel("Age: ");
         final JTextField ageText = new JTextField(3);
         JLabel genderLabel = new JLabel("Gender: ");
         final JTextField genderText = new JTextField(3);
         JLabel mobileLabel = new JLabel("Mobile number: ");
         final JTextField mobileText = new JTextField(3);
         JLabel postLabel = new JLabel("Post: ");
         final JTextField postText = new JTextField(3);
         JLabel addressLabel = new JLabel("Address: ");
         final JTextField addressText = new JTextField(3);
         JLabel salaryLabel = new JLabel("Salary: ");
         final JTextField salaryText = new JTextField(3);
         JLabel mpfLabel = new JLabel("MPF: ");
         final JTextField mpfText = new JTextField(3);
         JLabel bonusLabel = new JLabel("Bonus: ");
         final JTextField bonusText = new JTextField(3);
         JLabel haLabel = new JLabel("Housing Allowance: ");
         final JTextField haText = new JTextField(3);
         JLabel taLabel = new JLabel("Travelling Allowrance: ");
         final JTextField taText = new JTextField(3);
         
         JButton addMan = new JButton("Add manager");
         JButton addGen = new JButton("Add general staff");
         JButton showRecord = new JButton("Show record");
         
         //Initialize an employee object array
         ArrayList<Employee> emp = new ArrayList<Employee>();
         
         
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
        String filename = dateFormat.format(currentDate) + ".dat";
        
         
        //Button action for adding manager information
            addMan.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        char s = sidText.getText().charAt(0);
                        if (Character.toString(s).toUpperCase().contentEquals("M")) {
                           emp.add (new Manager(sidText.getText(), nameText.getText(), 
                                   Integer.parseInt(ageText.getText()), genderText.getText(), 
                                   mobileText.getText(), postText.getText(), addressText.getText(), 
                                   Integer.parseInt(salaryText.getText()), Integer.parseInt(mpfText.getText()),
                                   Integer.parseInt(haText.getText()), Integer.parseInt(taText.getText())));
                           
                           writeDat(filename, emp.get(emp.size()-1).toString());
                           JOptionPane.showMessageDialog(mainFrame, emp.get(emp.size()-1));
                        } else {
                           JOptionPane.showMessageDialog(mainFrame, "You are not entering manager information.");
                        }
                    } catch (StringIndexOutOfBoundsException ex) {
                        JOptionPane.showMessageDialog(mainFrame, "Staff ID is empty. ", "Staff ID error", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(mainFrame, "You have not finished the form. ", "Empty input", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(mainFrame, ex);
                        taText.requestFocus();
                    } 
                }
            });
            
            //Button action for adding general staff information
            addGen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        char s = sidText.getText().charAt(0);
                        if (Character.toString(s).toUpperCase().contentEquals("G")) {
                           emp.add(new GeneralStaff(sidText.getText(), nameText.getText(), 
                                   Integer.parseInt(ageText.getText()), genderText.getText(), 
                                   mobileText.getText(), postText.getText(), addressText.getText(), 
                                   Integer.parseInt(salaryText.getText()), Integer.parseInt(mpfText.getText()),
                                   Integer.parseInt(bonusText.getText())));
                           writeDat(filename, emp.get(emp.size()-1).toString());
                           JOptionPane.showMessageDialog(mainFrame, emp.get(emp.size()-1));
                        } else {
                           JOptionPane.showMessageDialog(mainFrame, "You are not entering general staff information.");
                        }
                    } catch (StringIndexOutOfBoundsException ex) {
                        JOptionPane.showMessageDialog(mainFrame, "Staff ID is empty. ", "Staff ID error", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(mainFrame, "You have not finished the form. ", "Empty input", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(mainFrame, ex);
                    }
                }
            });
         
            
         //Button action for showing current employees' information
         showRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame, empRecord(emp));
            }
         });
         
         
         
         //Statements for importing .dat files
          final JFileChooser fileDialog = new JFileChooser();
          FileNameExtensionFilter filter = new FileNameExtensionFilter(".dat files", "dat");
          fileDialog.setFileFilter(filter);
          
          JButton showFileDialogButton = new JButton("Open File");
          showFileDialogButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int returnVal = fileDialog.showOpenDialog(mainFrame);
            
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileDialog.getSelectedFile();
                     JOptionPane.showMessageDialog(mainFrame, readDat(emp, file, filename));
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }      
         }
      });
          
        //Statements for setting the location of the GUI objects
        controlPanel.setLayout(new GridBagLayout());
        mainFrame.getContentPane().add(controlPanel);
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;

        //Display GUI objects
        controlPanel.add(showFileDialogButton);
        controlPanel.add(sidLabel, left);
        controlPanel.add(sidText, right);
        controlPanel.add(nameLabel, left);
        controlPanel.add(nameText, right);
        controlPanel.add(ageLabel, left);
        controlPanel.add(ageText, right);
        controlPanel.add(genderLabel, left);
        controlPanel.add(genderText, right);
        controlPanel.add(mobileLabel, left);
        controlPanel.add(mobileText, right);
        controlPanel.add(postLabel, left);
        controlPanel.add(postText, right);
        controlPanel.add(addressLabel, left);
        controlPanel.add(addressText, right);
        controlPanel.add(salaryLabel, left);
        controlPanel.add(salaryText, right);
        controlPanel.add(mpfLabel, left);
        controlPanel.add(mpfText, right);
        controlPanel.add(bonusLabel, left);
        controlPanel.add(bonusText, right);
        controlPanel.add(haLabel, left);
        controlPanel.add(haText, right);
        controlPanel.add(taLabel, left);
        controlPanel.add(taText, right);
        controlPanel.add(addMan);
        controlPanel.add(addGen);
        controlPanel.add(showRecord);
        
         
        mainFrame.setVisible(true);
         
     }
     
     //Method for getting information from a dat file
     public String readDat(ArrayList<Employee> emp, File file, String filename) throws FileNotFoundException, IOException {
         BufferedReader reader = new BufferedReader(new FileReader(file));
         String line = reader.readLine();
         while (line != null) {
            String [] parts = line.split(";");
            char c  = parts[0].toUpperCase().charAt(0);
            switch (c) {
                case 'M':
                    emp.add(new Manager(parts[0], parts[1], 
                                   Integer.parseInt(parts[2]), parts[3], 
                                   parts[4], parts[5], parts[6], 
                                   Integer.parseInt(parts[7]), Integer.parseInt(parts[8]),
                                   Integer.parseInt(parts[9]), Integer.parseInt(parts[10])));
                    writeDat(filename, emp.get(emp.size()-1).toString());
                    break;
                    
                case 'G':
                    emp.add(new GeneralStaff(parts[0], parts[1], 
                                   Integer.parseInt(parts[2]), parts[3], 
                                   parts[4], parts[5], parts[6], 
                                   Integer.parseInt(parts[7]), Integer.parseInt(parts[8]),
                                   Integer.parseInt(parts[9])));
                    writeDat(filename, emp.get(emp.size()-1).toString());
                    break;
                default:
                    return "Error!";
            }
            line = reader.readLine();
         }
         return "File has been read.";
     }
     
     //Method for adding information into a dat file
     public void writeDat(String filename, String empINFO) throws IOException {
         BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
         writer.append(empINFO);
         writer.newLine();
         writer.close();
     }
    
    //A method for showing the details of all the employee objects
    public String empRecord(ArrayList<Employee> emp) {
        if (emp.size() == 0) {
            return "No record.";
        } else {
            String record = "The sample records of the employees are shown below: \n";
            for (int i=0; i < emp.size(); i++) {
                record += "Sample record " + (i+1) + ": " +emp.get(i) + '\n';
            }
            return record;
        }
    }
}