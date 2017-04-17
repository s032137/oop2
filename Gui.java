<<<<<<< HEAD

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class Gui {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    
    public Gui() {
        prepareGUI();
    }
    
    private void prepareGUI(){
      mainFrame = new JFrame("OOP Assignment");
      mainFrame.setSize(400,400);

      //headerLabel = new JLabel("");
      //statusLabel = new JLabel("");        
      //statusLabel.setSize(350,100);
      
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      //mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      //mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
    }
    
     public void contentObjects() {
         JLabel sidLabel = new JLabel("Staff ID: ");
         final JTextField sidText = new JTextField(10);
         JLabel nameLabel = new JLabel("Name: ");
         final JTextField nameText = new JTextField(10);
         JLabel ageLabel = new JLabel("Age: ");
         final JTextField ageText = new JTextField(10);
         JLabel genderLabel = new JLabel("Gender: ");
         final JTextField genderText = new JTextField(10);
         JLabel mobileLabel = new JLabel("Mobile number: ");
         final JTextField mobileText = new JTextField(10);
         JLabel postLabel = new JLabel("Post: ");
         final JTextField postText = new JTextField(10);
         JLabel addressLabel = new JLabel("Address: ");
         final JTextField addressText = new JTextField(10);
         JLabel salaryLabel = new JLabel("Salary: ");
         final JTextField salaryText = new JTextField(10);
         JLabel mpfLabel = new JLabel("MPF: ");
         final JTextField mpfText = new JTextField(10);
         JLabel bonusLabel = new JLabel("Bonus: ");
         final JTextField bonusText = new JTextField(10);
         JLabel haLabel = new JLabel("Housing Allowance: ");
         final JTextField haText = new JTextField(10);
         JLabel taLabel = new JLabel("Travelling Allowrance: ");
         final JTextField taText = new JTextField(10);
         
         JButton addMan = new JButton("Add manager");
         JButton addGen = new JButton("Add general staff");
         JButton showRecord = new JButton("Show record");

         
         controlPanel.setLayout(new GridBagLayout());
         mainFrame.getContentPane().add(controlPanel);
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;
        
        
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
}
=======
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.swing.border.*;


public class Gui extends JFrame{

>>>>>>> origin/master
