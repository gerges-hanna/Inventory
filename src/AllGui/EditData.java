package AllGui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Product.*;
import java.util.Collections;
public class EditData {
    
    
    public JPanel run(){
        
        FatherGUI f=new FatherGUI();
        inventory.Login log1=new inventory.Login();
        int fx=375,fy=175;
        final String m="\u27F3";
        //Panel
        
        JPanel panelEditData = new JPanel();
        
        //Buttons
        
        JButton Back = new JButton("Back");
        f.ButtonBackHome(Back);
        
        
        JButton Update = new JButton("Save Changes");
        Update.setBounds(fx+180, fy+250, 120, 35);
        
        
        JButton Clear = new JButton(m);
        Clear.setBounds(fx+305,fy+250, 80, 35);
        
        JCheckBox box1=new JCheckBox("");
        box1.setBounds(fx+435,fy+108,25,14);
        
        JCheckBox box2=new JCheckBox("");
        box2.setBounds(fx+435,fy+208,25,14);
 
        //Labels
        
       
        JLabel lbNewName = new JLabel("Name:");
        lbNewName.setBounds(fx, fy-1, 300, 30);
        lbNewName.setFont(new Font("Tahoma", 0, 17));
        //...............................................
        JLabel lbNewPhone = new JLabel("Contact Number:");
        lbNewPhone.setBounds(fx, fy+49, 300,30);   
        lbNewPhone.setFont(new Font("Tahoma", 0, 17));
        //...............................................
        JLabel lbNewPw = new JLabel("New Password:");
        lbNewPw.setBounds(fx,fy+99 ,300,30);
        lbNewPw.setFont(new Font("Tahoma", 0, 17));
        //...............................................
        JLabel lbConfirmNewPw = new JLabel("Confirm New Password:");
        lbConfirmNewPw.setBounds(fx, fy+149, 300, 30);
        lbConfirmNewPw.setFont(new Font("Tahoma", 0, 17));
        //...............................................
        JLabel CrntPw =new JLabel("Current Password:");
        CrntPw.setBounds(fx, fy+199, 300, 30);
        CrntPw.setFont(new Font("Tahoma", 0, 17));
        //...............................................
  
        
        
        
        
        //TextFields
        
        
        JTextField tfNewName = new JTextField();
        tfNewName.setBounds(fx+180, fy, 280,30 );
        //...............................................
        JTextField tfNewPhone = new JTextField();
        tfNewPhone.setBounds(fx+180, fy+50,280,30);
        //...............................................
        
        //PasswordField

        JPasswordField pfNewPw = new JPasswordField();
        pfNewPw.setBounds(fx+180, fy+100, 280, 30);
        //...............................................
        JPasswordField pfConfirmNewPw = new JPasswordField();
        pfConfirmNewPw.setBounds(fx+180, fy+150, 280, 30);
        //...............................................
        JPasswordField pfOldPw = new JPasswordField();
        pfOldPw.setBounds(fx+180, fy+200, 280, 30);
        //...............................................
        
        //set_tf 
        try{
        if(!FatherClass.getIDlog().equals(null))
        {
        log1.ReadData();
            int i;
            for(i=0;i<log1.LoginList.size();i++)
            {
                  if(log1.LoginList.get(i).getOrder()==Integer.parseInt(FatherClass.getIDlog()))
                  {
                    tfNewName.setText(log1.LoginList.get(i).getName());
                    
                    tfNewPhone.setText(Integer.toString(log1.LoginList.get(i).getContactNumber()));  
                    
                    break;
                  }
            }
        }
        }
        catch(NullPointerException e)
        {
            
        }
        //**********
        //Actions
      
        
         Update.addActionListener(new ActionListener() {
          
             
            public void actionPerformed(ActionEvent e) {
                 
                
    try   //tfNewName..tfNewPhone..pfOldPw..pfNewPw..pfConfirmNewPw
    {
 
        int check1=0,mainChecker=0;
         if(!tfNewName.getText().equals("")&&!tfNewPhone.getText().equals("")&&!pfOldPw.getText().equals("")&&!pfConfirmNewPw.getText().equals("")&&!pfNewPw.getText().equals(""))
              {
              check1++;
    
  
           //***************************************************************************************************************************
     //Name checking conditions**********************
            if(tfNewName.getText().equals("")||( tfNewName.getText().length()>=3 && tfNewName.getText().length()<=20))
            {
   
             int check=0;
            for(int i=0;i<tfNewName.getText().length();i++)
            {
                    if( tfNewName.getText().charAt(i)!='@' && 
                        tfNewName.getText().charAt(i)!=';' && 
                        tfNewName.getText().charAt(i)!='-' && 
                        tfNewName.getText().charAt(i)!='+' && 
                        tfNewName.getText().charAt(i)!='=' &&
                        tfNewName.getText().charAt(i)!='~' &&
                        tfNewName.getText().charAt(i)!='$')
                       {
                       check++;
                       if(tfNewName.getText().length()==check)
                       {
                      log1.setName(tfNewName.getText());  
                      mainChecker++;
                       }
                       }  
                    else {
                    JOptionPane.showMessageDialog(null, "Name cant include any (@ ; - + = ~ $)");
                    break;
                    }
            }
         
           }
         else{JOptionPane.showMessageDialog(null, "Enter a name between 3-20 characters");}
               //Name checking conditions**********************
               //***************************************************************************************************************************
 //Phone Number checking condition*************************
             if(tfNewPhone.getText().length()>=3&&tfNewPhone.getText().length()<=15)
             {
             int r = 0;
            for(int i = 0; i < tfNewPhone.getText().length(); i++)
            {
                if(Character.isDigit(tfNewPhone.getText().charAt(i)))
                {
                    r++;
                }
            }
            if(r == tfNewPhone.getText().length())
            {
                
                log1.setContactNumber(Integer.parseInt(tfNewPhone.getText()));
                mainChecker++;
                
            }
              else {JOptionPane.showMessageDialog(null, "Enter a valid contact number");}
             }
             else 
             {   
                 JOptionPane.showMessageDialog(null, "Enter a number between 3-15 characters");
             }
              //**************************************************************************************************************************
               //***************************************************************************************************************************
                //Password checking conditions**********************
            if(pfNewPw.getText().equals("")||( pfNewPw.getText().length()>=4 && pfNewPw.getText().length()<=8&&pfNewPw.getText().equals(pfConfirmNewPw.getText())))
            {
             int check=0;
            for(int i=0;i<pfNewPw.getText().length();i++)
            {
                    if( pfNewPw.getText().charAt(i)!='@' && 
                        pfNewPw.getText().charAt(i)!=';' && 
                        pfNewPw.getText().charAt(i)!='-' && 
                        pfNewPw.getText().charAt(i)!='+' && 
                        pfNewPw.getText().charAt(i)!='=' &&
                        pfNewPw.getText().charAt(i)!='~' &&
                        pfNewPw.getText().charAt(i)!='$')
                       {
                       check++;
                       if(pfNewPw.getText().length()==check)
                       {
                      log1.setPassword(pfNewPw.getText());
                      mainChecker++;
                       }
                       }  
                    else {
                    JOptionPane.showMessageDialog(null, "Password cant include any (@ ; - + = ~ $)");
                    break;
                    }
            }
         
           }
         else{JOptionPane.showMessageDialog(null, "Enter password between 4-8 characters\nPassword must match with Confirm Password");}
               //Password checking conditions**********************
         //*******************************************************************************************************
              
         
              //***************************************************************************************************************************
  
              }
         else if(check1==0)
         {
             JOptionPane.showMessageDialog(null, "You must fill out all the required fields")
                 ;}
         //************************************************************************
       if(check1!=0&&mainChecker==3)
      {
          mainChecker=0;
                 log1.ReadData();
                  int i;
                 String OldUser,OldCase;
                  Files f1=new Files();
            for(i=0;i<log1.LoginList.size();i++)
            {
                if(log1.LoginList.get(i).getOrder()==Integer.parseInt(FatherClass.getIDlog()))
                {
                OldUser=log1.LoginList.get(i).getUserName();
                OldCase=log1.LoginList.get(i).getCase();
                
                if(pfOldPw.getText().equals(log1.LoginList.get(i).getPassword()))
    /*&&!log1.getName().equals("")&&!log1.getPassword().equals("")&&log1.getContactNumber()!=0) used before to check edit setting is functionally right*/
                {
                
                   String Query = FatherClass.getIDlog() +";"+ 
                                  OldUser +";"+
                                  log1.getPassword() +";"+
                                  OldCase +";"+
                                  log1.getName() +";"+
                                  log1.getContactNumber() ;
                    f1.update(FatherClass.getIDlog(), "Login.txt", Query);
                    JOptionPane.showMessageDialog(null, "Data has been changed successfully"); 
                    log1.setLaste();
                    /*
                    log1.setName(null);
                    log1.setPassword(null);
                    log1.setContactNumber(0);
                    */
                    break;
              }
           // }
              else
                {
                    JOptionPane.showMessageDialog(null, "Current Password didnt match"); 
                }
            }
      }
      }  
         
             
              
    }
    catch(      NullPointerException | NumberFormatException m){
   }
             
                 
          }//end btn action
        });
        
       
         
        
        //*****************************************************************************************
        
          box1.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e){
                
                if(box1.isSelected())
                { 
                    pfNewPw.setEchoChar((char)0);
                    pfConfirmNewPw.setEchoChar((char)0);
                }
                else 
                {
                pfNewPw.setEchoChar('*');
                pfConfirmNewPw.setEchoChar('*');
                }
                
                }
                });
        
          
          box2.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e){
                
                if(box2.isSelected())
                { 
                    pfOldPw.setEchoChar((char)0);
                }
                else 
                {
                pfOldPw.setEchoChar('*');
                }
                
                }
                });
        //*****************************************************************************************
        
        Clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               tfNewName.setText("");
               tfNewPhone.setText("");
               pfNewPw.setText("");
               pfConfirmNewPw.setText("");
               pfOldPw.setText("");
               
            }
        });
        

        
        //ADD
        
       
        panelEditData.add(lbNewName);
        panelEditData.add(CrntPw);
        panelEditData.add(lbNewPhone);
        panelEditData.add(box1);
        panelEditData.add(box2);
        panelEditData.add(lbNewPw);
        panelEditData.add(Back);
        panelEditData.add(Update);
        panelEditData.add(tfNewName);
        panelEditData.add(tfNewPhone);
        panelEditData.add(pfOldPw);
        panelEditData.add(pfNewPw);
        panelEditData.add(lbConfirmNewPw);
        panelEditData.add(pfConfirmNewPw);
        panelEditData.add(Clear);
        
        
        
        
        
        
        panelEditData.setSize(1200, 700);
        panelEditData.setBackground(Color.LIGHT_GRAY);
        panelEditData.setLayout(null);
        
        return panelEditData;
        
    }
    
}
