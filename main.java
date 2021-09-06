package Project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class QuizApp {
		  
	public static class OnlineTest extends JFrame implements ActionListener  
	{ 
		    JLabel l = new JLabel();    
		    
		    JRadioButton jb[]=new JRadioButton[5];  
		    JButton b1,b2;  
		    ButtonGroup bg = new ButtonGroup();   
		    int count=0,current=0,x=1,y=1,now=0;  
		    int m[]=new int[10];
		    
		    OnlineTest(String s)  
		    {  
		        super(s);  
		        add(l);  
		        for(int i=0;i<5;i++)  
		        {  
		            jb[i]=new JRadioButton();     
		            add(jb[i]);  
		            bg.add(jb[i]);  
		        }  
		        b1=new JButton("Next");  
		        b2=new JButton("Bookmark");  
		        b1.addActionListener(this);  
		        b2.addActionListener(this);  
		        add(b1);
		        add(b2);  
		        set();  
		        l.setBounds(30,40,450,20);  
		        jb[0].setBounds(50,80,100,20);  
		        jb[1].setBounds(50,110,100,20);  
		        jb[2].setBounds(50,140,100,20);  
		        jb[3].setBounds(50,170,100,20);  
		        b1.setBounds(100,240,100,30);  
		        b2.setBounds(250,240,100,30); 
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		        setLayout(null);  
		        setLocation(250,100);  
		        setVisible(true);  
		        setSize(700,650); 
		    }  
		    public void actionPerformed(ActionEvent e)  
		    {  
		        if(e.getSource() == b1)  
		        {  
		            if(check())  
		                count++;  
		            current++;  
		            set();    
		            if(current==9)  
		            {  
		                b1.setEnabled(false);  
		                b2.setText("Result");  
		            }  
		        }  
		        if(e.getActionCommand().equals("Bookmark"))  
		        {  
		            JButton bk = new JButton("Bookmark " + x);  
		            bk.setBounds(480, 20+30*x, 100,30);  
		            add(bk);  
		            bk.addActionListener(this);  
		            m[x]=current;  
		            x++;  
		            current++;  
		            set();    
		            if(current==9)  
		                b2.setText("Result");  
		            setVisible(false);  
		            setVisible(true);  
		        }  
		        for(int i=0,y=1; i<x; i++,y++)  
		        {  
			        if(e.getActionCommand().equals("Bookmark "+y))  
			        {  
			            if(check())  
			                count++;  
			            now = current;  
			            current=m[y];  
			            set();  
			            ((JButton)e.getSource()).setEnabled(false);  
			            current = now;  
			        }  
		        }    
		        if(e.getActionCommand().equals("Result"))  
		        {  
		            if(check())  
		                count++;  
		            current++;  
		            JOptionPane.showMessageDialog(this,"Correct Answers= "+count);  
		            System.exit(0);  
		        }  
		    }  
		    void set()  
		    {  
		        jb[4].setSelected(true);  
		        if(current==0)  
		        {  
		            l.setText("Q1: Every statement in Java language should end with?");  
		            jb[0].setText(".");
		            jb[1].setText(";");
		            jb[2].setText("/");
		            jb[3].setText("?");   
		        }  
		        if(current==1)  
		        {  
		            l.setText("Q2: Which company owns Java at present?");  
		            jb[0].setText("IBM");
		            jb[1].setText("Microsoft");
		            jb[2].setText("Apple");
		            jb[3].setText("Oracle");  
		        }  
		        if(current==2)  
		        {  
		            l.setText("Q3: What is the original name of Java Programming language?");  
		            jb[0].setText("OAK");
		            jb[1].setText("TEAK");
		            jb[2].setText("PINE");
		            jb[3].setText("J++");  
		        }  
		        if(current==3)  
		        {  
		            l.setText("Q4: What are the features of an Object Oriented Programming?");  
		            jb[0].setText("Inheritance");
		            jb[1].setText("Encapsulation");
		            jb[2].setText("Polymorphism");
		            jb[3].setText("All the above");  
		        }  
		        if(current==4)  
		        {  
		            l.setText("Q5: Which of the following is not a Java features?");  
		            jb[0].setText("Dynamic");
		            jb[1].setText("Architecture Neutral");
		            jb[2].setText("Use of pointers");
		            jb[3].setText("Object-oriented");  
		        }  
		        if(current==5)  
		        {  
		            l.setText("Q6: A SWITCH case statement in Java is a ___ control statement?");  
		            jb[0].setText("Iteration");
		            jb[1].setText("Loop");
		            jb[2].setText("Selection");
		            jb[3].setText("Jump");  
		        }  
		        if(current==6)  
		        {  
		            l.setText("Q7: In Java language, an array index starts with?");  
		            jb[0].setText("1");
		            jb[1].setText("0");
		            jb[2].setText("-1");  
		            jb[3].setText("100");  
		        }  
		        if(current==7)  
		        {  
		            l.setText("Q8: What does JVM stands for?");  
		            jb[0].setText("Java Virtual Machine");
		            jb[1].setText("Java Class");
		            jb[2].setText("Java Virtual Mechanism");  
		            jb[3].setText("Java Variable Machine");         
		        }  
		        if(current==8)  
		        {  
		            l.setText("Q9: Which arithmetic operator gives the Remainder of Division?");  
		            jb[0].setText("*");
		            jb[1].setText("/");
		            jb[2].setText("^");
		            jb[3].setText("%");  
		        }  
		        if(current==9)  
		        {  
		            l.setText("Q10: Which among the following is not a valid Data Type in Java?");  
		            jb[0].setText("long");
		            jb[1].setText("bool");
		            jb[2].setText("double");  
		            jb[3].setText("float");  
		        }  
		        
		        for(int i=0,j=0;i<=90;i+=30,j++)  
		            jb[j].setBounds(50,80+i,200,20);  
		    }  
		    boolean check()  
		    {  
		        if(current==0)  
		            return(jb[1].isSelected());  
		        if(current==1)  
		            return(jb[3].isSelected());  
		        if(current==2)  
		            return(jb[0].isSelected());  
		        if(current==3)  
		            return(jb[3].isSelected());  
		        if(current==4)  
		            return(jb[2].isSelected());  
		        if(current==5)  
		            return(jb[2].isSelected());  
		        if(current==6)  
		            return(jb[1].isSelected());  
		        if(current==7)  
		            return(jb[0].isSelected());  
		        if(current==8)  
		            return(jb[3].isSelected());  
		        if(current==9)  
		            return(jb[1].isSelected());  
		        return false;  
		    }  
		    public static void main(String args[])  
		    {  
		        new OnlineTest("Quiz Of Java");  
		    } 
	}
}
