
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BaseballGame extends JFrame {
    public BaseballGame(){
        setTitle("p3Younouss_T");
        setSize(500, 500);
        contentPane = getContentPane();        
        textFieldNorth = new JTextField();
        textFieldNorth.setEditable(false);
        textFieldNorth.setFont(new Font("Courier New", Font.BOLD, 18));
        contentPane.add(textFieldNorth, "North");
        textFieldNorth.setText("Play Ball!"); 
        drawPanel = new DrawPanel();
        contentPane.add(drawPanel, "Center");
        JPanel panel = new JPanel(); 
        panel.setLayout(new GridLayout(3, 4)); 
        contentPane.add(panel, "South");    
        button11 = new JButton("0");
        button12 = new JButton("1");        
        button13 = new JButton("2");
        button14 = new JButton("3");        
        button21 = new JButton("4");
        button22 = new JButton("5");
        button23 = new JButton("6");
        button24 = new JButton("7");        
        button31 = new JButton("8");
        button32 = new JButton("9");
        button33 = new JButton("New Key");  
        button34 = new JButton("Clear");
        button11.setEnabled(false);
        button12.setEnabled(false);
        button13.setEnabled(false);
        button14.setEnabled(false);
        button21.setEnabled(false);
        button22.setEnabled(false);     
        button23.setEnabled(false);
        button24.setEnabled(false);
        button31.setEnabled(false);
        button32.setEnabled(false);
        button34.setEnabled(false);
        ButtonObserver observer = new ButtonObserver();
        button11.addActionListener(observer);
        button12.addActionListener(observer);
        button13.addActionListener(observer);
        button14.addActionListener(observer);
        button21.addActionListener(observer);
        button22.addActionListener(observer);
        button23.addActionListener(observer);
        button24.addActionListener(observer);  
        button31.addActionListener(observer);
        button32.addActionListener(observer);
        button33.addActionListener(observer);   
        button34.addActionListener(observer);
        panel.add(button11);
        panel.add(button12);
        panel.add(button13);
        panel.add(button14);
        panel.add(button21);
        panel.add(button22);
        panel.add(button23);
        panel.add(button24);
        panel.add(button31);
        panel.add(button32);
        panel.add(button33);       
        panel.add(button34);
    }
 class ButtonObserver implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {  
        Object source = e.getSource();   
        if(source == button33){
            guess = "";
            button11.setEnabled(true);
            button12.setEnabled(true);
            button13.setEnabled(true);
            button14.setEnabled(true);
            button21.setEnabled(true);
            button22.setEnabled(true);     
            button23.setEnabled(true);
            button24.setEnabled(true);
            button31.setEnabled(true);
            button32.setEnabled(true);  
            button34.setEnabled(false);
            first = (int) (Math.random() * 10);
            do{
                second = (int) (Math.random() * 10);
            }
            while(second == first);
            do{
                third = (int) (Math.random() * 10);
            }
            while((third == second) || (third == first)); 
            firstChar = Integer.toString(first).charAt(0);
            secondChar = Integer.toString(second).charAt(0);
            thirdChar = Integer.toString(third).charAt(0);
            textField = "key = "+firstChar+secondChar+thirdChar;
            textFieldNorth.setText(textField);
            strike1 = false;
            strike2 = false;
            strike3 = false;
            ball1 = false;
            ball2 = false;
            ball3 = false;
            drawPanel.repaint();
        }
            if(source == button11){
                guess = guess+"0";
                textFieldNorth.setText(textField+" "+"|"+guess);
                checkGuess();
            }
            if(source == button12){
                guess = guess+"1";
                textFieldNorth.setText(textField+" "+"|"+guess);  
                checkGuess();           
            }       
            if(source == button13){
                guess = guess+"2";
                textFieldNorth.setText(textField+" "+"|"+guess);  
                checkGuess();           
            }         
            if(source == button14){
                guess = guess+"3";
                textFieldNorth.setText(textField+" "+"|"+guess);  
                checkGuess();          
            }   
            if(source == button21){
                guess = guess+"4";
                textFieldNorth.setText(textField+" "+"|"+guess);  
                checkGuess();           
            }
            if(source == button22){
                guess =guess+"5";
                checkGuess();           
            }
            if(source == button23){
                guess = guess+"6";
                textFieldNorth.setText(textField+" "+"|"+guess);     
                checkGuess();          
            }
            if(source == button24){
                guess =guess+"7";
                textFieldNorth.setText(textField+" "+"|"+guess); 
                checkGuess();           
            }
            if(source == button31){
                guess = guess+"8";
                textFieldNorth.setText(textField+" "+"|"+guess);    
                checkGuess();           
            }
            if(source == button32){
                guess =guess+"9";
                textFieldNorth.setText(textField+" "+"|"+guess);   
                checkGuess();           
            }
            if(source == button34){
                guess = "";
                textField = "key = "+firstChar+secondChar+thirdChar;
                textFieldNorth.setText(textField);
                button11.setEnabled(true);
                button12.setEnabled(true);
                button13.setEnabled(true);
                button14.setEnabled(true);
                button21.setEnabled(true);
                button22.setEnabled(true);     
                button23.setEnabled(true);
                button24.setEnabled(true);
                button31.setEnabled(true);
                button32.setEnabled(true);  
                button34.setEnabled(false);
                strike1 = false;
                strike2 = false;
                strike3 = false;
                ball1 = false;
                ball2 = false;
                ball3 = false;
                drawPanel.repaint();
            }
    } 
 }
    void checkGuess(){
        if(guess.length() == 3){
            numberOfStrikes();
            numberOfBalls();
            textFieldNorth.setText(textField+" "+"|"+guess+" "+"|"+"B = "+numberOfBalls+" S = "+numberOfStrikes); 
            drawPanel.repaint();
            guess = "";
            numberOfStrikes = 0;
            numberOfBalls = 0;
            disable();         
            button34.setEnabled(true); 
        }
    }
    void numberOfStrikes(){
        if(firstChar == guess.charAt(0)){
            numberOfStrikes++;
        }
        if(secondChar == guess.charAt(1)){
            numberOfStrikes++;
        }
        if(thirdChar == guess .charAt(2)){
            numberOfStrikes++;
        }
        if(numberOfStrikes == 1){
            strike1 = true;
        }
        if(numberOfStrikes == 2){
            strike2 = true;
        }
        if(numberOfStrikes == 3){
            strike3 = true;
        }
    }
    void numberOfBalls(){
        if(firstChar == guess.charAt(1) || firstChar == guess.charAt(2)){
            numberOfBalls++;
        }
        if(secondChar == guess.charAt(0) || secondChar == guess.charAt(2)){
            numberOfBalls++;
        }        
        if(thirdChar == guess.charAt(0) || thirdChar == guess.charAt(1)){
            numberOfBalls++;
        }
        if(numberOfBalls == 1){
            ball1 = true;
        }
        if(numberOfBalls == 2){
            ball2 = true;
        }
        if(numberOfBalls == 3){
            ball3 = true;
        }
    }
    public void disable(){
        button11.setEnabled(false);
        button12.setEnabled(false);
        button13.setEnabled(false);
        button14.setEnabled(false);
        button21.setEnabled(false);
        button22.setEnabled(false);     
        button23.setEnabled(false);
        button24.setEnabled(false);
        button31.setEnabled(false);
        button32.setEnabled(false);  
    }  
    class DrawPanel  extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g2 = (Graphics2D) g;
            ellipse1 = new Ellipse2D.Double(100, 100, 50, 50);
            ellipse2 = new Ellipse2D.Double(150, 100, 50, 50);    
            ellipse3 = new Ellipse2D.Double(200, 100, 50, 50);
            ellipse4 = new Ellipse2D.Double(100, 200, 50, 50);
            ellipse5 = new Ellipse2D.Double(150, 200, 50, 50);    
            ellipse6 = new Ellipse2D.Double(200, 200, 50, 50);
            g2.setColor(Color.blue);
            if(ball1 == true){               
                g2.fill(ellipse1); 
            }
            else if(ball2 == true){
                g2.fill(ellipse1);  
                g2.fill(ellipse2);
            }            
            else if(ball3 == true){
                g2.fill(ellipse1);  
                g2.fill(ellipse2);
                g2.fill(ellipse3);
            }                       
           g2.setColor(Color.red);            
           if(strike1 == true){
                g2.fill(ellipse4);
            }
            else if(strike2 == true){
                g2.fill(ellipse4);  
                g2.fill(ellipse5);
            }            
            else if(strike3 == true){
                g2.fill(ellipse4);  
                g2.fill(ellipse5);
                g2.fill(ellipse6); 
            }  
        }   
    }     
 private final JTextField textFieldNorth;   
 private final JButton  button11, button12, button13, button14, button21, button22, button23, button24,  button31, button32, button33, button34;
 private int first, second, third; 
 private char  firstChar, secondChar, thirdChar;
 private String textField, guess = "";
 private int numberOfStrikes = 0, numberOfBalls = 0;
 DrawPanel drawPanel;
 Container contentPane;
 Graphics2D g2;
 Ellipse2D.Double ellipse1,ellipse2,ellipse3,ellipse4,ellipse5,ellipse6;
 boolean ball1 = false, ball2 = false, ball3 = false, strike1 = false, strike2 = false, strike3 =false;
}
