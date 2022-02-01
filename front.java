/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mariem
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class front extends JFrame {
    
    public front(){
        JPanel p1= new JPanel();
        p1.setLayout (new GridLayout(4,3));
        JTextField textfield= new JTextField("0");
        double res=0;
        //add buttons to the palnel
        for (int i=9; i>=1;i--){
           JButton a= new JButton(""+i);
           a.setForeground(Color.BLUE);
           aListenerClass listener1 = new aListenerClass(textfield,i);
           a.addActionListener(listener1);
           p1.add(a);
           
        }
        JButton a1= new JButton ("0");
        a1.setForeground(Color.BLUE);
        a1.addActionListener(new aListenerClass(textfield,0));
        p1.add(a1);
        
        JButton a2= new JButton ("+/-");
        a2.setForeground(Color.BLUE);
        a2.addActionListener(new b1ListenerClass(textfield,res));
        p1.add(a2);
        
        JButton a3= new JButton ("ClearAll");
        a3.setForeground(Color.PINK);
        a3.addActionListener(new a3ListenerClass(textfield));
        p1.add(a3);
        
        
        JPanel p3= new JPanel();
        p3.setLayout (new GridLayout(4,1));
        JButton b1= new JButton ("+");
        b1.setForeground(Color.RED);
        b1ListenerClass listener2 =new b1ListenerClass(textfield,res);
        b1.addActionListener(listener2);
        p3.add(b1);
        JButton b2= new JButton("-");
        b2.setForeground(Color.RED);
        b2.addActionListener(listener2);
        p3.add(b2);
        JButton b3=new JButton("*");
        b3.setForeground(Color.RED);
        b3.addActionListener(listener2);
        p3.add(b3);
        JButton b4= new JButton("/");
        b4.setForeground(Color.red);
        b4.addActionListener(listener2);
        p3.add(b4);
        
        
        //create panel p2 to hold a text field
        JPanel p2 = new JPanel (new BorderLayout());
        
        p2.add (textfield,BorderLayout.NORTH );
        p2.add (p1,BorderLayout.CENTER);
        p2.add(p3,BorderLayout.EAST);
        //add contents,to the frame
        add(p2,BorderLayout.CENTER);
        JButton a5= new JButton("ENTER");
        a5.setForeground(Color.GREEN);
    
        a5.addActionListener(listener2);
       
        p2.add(a5,BorderLayout.SOUTH);
        
        
    }
    
    
    
    
    
    
    
    
    public static void main(String[]args){
        front frame =new front() ;
        frame.setTitle("Calculator");
        frame.setSize(400,250);//set the frame size
        frame.setLocationRelativeTo(null); //set the frame size
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);//display the frame 
    }
    
        };
        
    
    

class aListenerClass implements ActionListener{
    JTextField textfield ;
    int i;
    public aListenerClass(JTextField textfield,int i){
    this.textfield = textfield;
    this.i=i;}
    @Override
    public void actionPerformed (ActionEvent e){
        if (textfield.getText().equals("0")){
            textfield.setText("");}
            
        textfield.setText(textfield.getText().concat(String.valueOf(i)));
        }
        
    }




class a3ListenerClass implements ActionListener{
    JTextField textfield;
    public a3ListenerClass(JTextField textfield){
    this.textfield = textfield;}
    @Override
    public void actionPerformed (ActionEvent e){
        textfield.setText("");
        
        
    }
}






class b1ListenerClass implements ActionListener{
    JTextField textfield;
    char operator;
    double num1=0, num2=0, res;
    public b1ListenerClass(JTextField textfield,double res){
    this.textfield = textfield;
    this.res = res;}
    @Override
    public void actionPerformed (ActionEvent e){
        String button = ((JButton) e.getSource()).getText(); 
       
        //double num1=0, num2=0, res=0;
        
        if ("+".equals(button)){
            operator = '+';
           
            num1=Double.parseDouble(textfield.getText());
           
            textfield.setText("");
         }
        else if ("-".equals(button)){
            operator = '-';
           
            num1=Double.parseDouble(textfield.getText());
           
            textfield.setText("");
        }
        
        
        else if ("*".equals(button)){
            operator = '*';
           
            num1=Double.parseDouble(textfield.getText());
           
            textfield.setText("");
         }
        else if ("/".equals(button)){
            operator = '/';
           
            num1=Double.parseDouble(textfield.getText());
           
            textfield.setText("");
         }
        
        
        
        
        
        
        
        if ("ENTER".equals(button)){
            num2=Double.parseDouble(textfield.getText());
             
            switch(operator){
                case '+' :
               
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                 case '/':
                    res = num1 / num2;
                    break;    
                    
                    }
            textfield.setText(""+res);
            num1 = res;
   
        }
        if ("+/-".equals(button)){
            double t = Double.parseDouble(textfield.getText());
            t *=-1;
            textfield.setText(String.valueOf(t));
            
        }
                
            
        
}}

