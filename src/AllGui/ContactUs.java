
package AllGui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import javax.mail.*;    
import javax.mail.internet.*;

//
public class ContactUs implements RunMethod
{
    private final FatherGUI fatherGUI = new FatherGUI();
    public static void send(String from,String password,String to,String sub,String msg)
    {   
        Properties props = System.getProperties();
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
  
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage generateMailMessage = new MimeMessage(session);
        try
        {
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(from));
            generateMailMessage.setSubject("Feed back");
            generateMailMessage.setContent(msg, "text/html");
            
            Transport tr = session.getTransport("smtp");
            tr.connect("smtp.gmail.com", from, password);
            tr.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            tr.close();
            
        }
        catch(Exception ee)
        {
            JOptionPane.showMessageDialog(null, ee);
        }
             
    }
    
    @Override
    public JPanel Run()
    {
        int x=325;
        
        
        //set icon
        JLabel label=new JLabel();
        label.setBounds(0, 2, 1200, 700);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AllGui/pharma.jpg"))); // NOI18N
        //.......................................
        
        // Main panel
        JPanel mainPanel = new JPanel();
        //mainPanel.setBackground(Color.yellow);
        mainPanel.setLayout(null);
        mainPanel.setSize(1200, 700);
        
        //Text Fields
        JTextField emailTF = new JTextField();
        JPasswordField passwordTF = new JPasswordField();
        emailTF.setBounds(x-2, 160, 290, 50);
        passwordTF.setBounds(x+310, 160, 290, 50);
        
        //Labels
        JLabel emailLBL = new JLabel("Email ");
        JLabel pwLBL = new JLabel("Password ");
        JLabel goodExpLBL = new JLabel("Message");
        emailLBL.setBounds(x+3, 130, 250, 30);
        pwLBL.setBounds(x+315, 130, 250, 30);
        goodExpLBL.setBounds(x+5, 245, 250, 30);
        
        //Text Area
        JTextArea textA = new JTextArea();
        textA.setBounds(x, 280, 600, 300);
        textA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel.add(textA);
        
        //Scroll Panes
        JScrollPane sp = new JScrollPane(textA);
        sp.setBounds(x, 280, 600, 300);
        mainPanel.add(sp);
        
        //Buttons
        JButton sendBtn = new JButton("Send");
        JButton resetBtn = new JButton("Reset");
        JButton backBtn = new JButton("Back");
        fatherGUI.ButtonBackHome(backBtn);
        sendBtn.setBounds(x+215, 585, 100, 25);
        resetBtn.setBounds(x+315, 585, 80, 25);
        sendBtn.setFont(new Font("Arial", 1, 16));
        resetBtn.setFont(new Font("Arial", 0, 14));
        resetBtn.addActionListener( (ActionEvent e) ->
        {
            emailTF.setText("");
            passwordTF.setText("");
            textA.setText("");
        });
        sendBtn.addActionListener( (ActionEvent e) ->
        {
            if(!emailTF.getText().equals("") && !passwordTF.getText().equals("") && !textA.getText().equals(""))
            {
                send(emailTF.getText(), passwordTF.getText(), "hope1pharmacy@gmail.com", "Feedback", textA.getText());
            }
            else
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
        });
        
        //Changing the font and the font size
        fatherGUI.AllTextFieldFontSize((JTextField)passwordTF);
        fatherGUI.AllTextFieldFontSize(emailTF);
        fatherGUI.AllLblFontSize(emailLBL);
        fatherGUI.AllLblFontSize(pwLBL);
        fatherGUI.AllLblFontSize(goodExpLBL);
        
        // Adding section
        mainPanel.add(emailTF);
        mainPanel.add(passwordTF);
        mainPanel.add(emailLBL);
        mainPanel.add(pwLBL);
        mainPanel.add(goodExpLBL);
        mainPanel.add(sendBtn);
        mainPanel.add(resetBtn);
        mainPanel.add(backBtn);
        mainPanel.add(label);
        
        return mainPanel;
    }
}
//