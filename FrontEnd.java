import javax.swing.*;
import java.awt.*;

public class FrontEnd extends JFrame{
    private int score = 0;
    private JFrame frame = new JFrame("Simon Game");

    private JLabel mainLabel = new JLabel("SIMON GAME", SwingConstants.CENTER);

    private JLabel goLabel = new JLabel();
    private JLabel label1 = new JLabel("SCORE:", SwingConstants.RIGHT);
    private JLabel label2 = new JLabel("    " + String.valueOf(score), SwingConstants.LEFT);

    private JLabel label3 = new JLabel("Follow the", SwingConstants.RIGHT);

    private JLabel label4 = new JLabel(" sequence!", SwingConstants.LEFT);
    private JButton red = new JButton();
    private JButton blue = new JButton();
    private JButton green = new JButton();
    private JButton yellow = new JButton();

    private Color myRed = new Color(220, 20, 60);
    private Color myBlue = new Color(70, 70, 255);
    private Color myGreen = new Color(80, 200, 120);
    private Color myYellow = new Color(251, 236, 93);

    FrontEnd(BackEnd backEnd) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(new GridLayout(4, 4));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        red.setBackground(myRed);
        blue.setBackground(myBlue);
        green.setBackground(myGreen);
        yellow.setBackground(myYellow);

        goLabel.setFont(new Font("", Font.PLAIN, 35));
        mainLabel.setFont(new Font("", Font.BOLD, 50));
        label1.setFont(new Font("", Font.PLAIN, 30));
        label2.setFont(new Font("", Font.PLAIN, 30));
        label3.setFont(new Font("", Font.PLAIN, 30));
        label4.setFont(new Font("", Font.PLAIN, 30));
        setScore(score);

        frame.add(mainLabel);
        frame.add(label1);
        frame.add(label2);
        frame.add(goLabel);
        frame.add(new JLabel());
        frame.add(red);
        frame.add(blue);
        frame.add(new JLabel());
        frame.add(new JLabel());
        frame.add(yellow);
        frame.add(green);
        frame.add(new JLabel());
        frame.add(new JLabel());
        frame.add(label3);
        frame.add(label4);
        frame.add(new JLabel());


        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        frame.setVisible(true);

    }

    public void setTextGoLabel(String op){
        goLabel.setText(op);
    }

    public void setScore(int sc){
        label2.setText(" " + String.valueOf(sc));
    }
    JButton getRed(){
       return this.red;
    }

    public void shineRed() throws InterruptedException {
        red.setBackground(Color.black);
        synchronized (this){
            wait(200);
        }
        red.setBackground(myRed);
        synchronized (this){
            wait(200);
        }
    }

     JButton getBlue(){
         return this.blue;
     }

     public void shineBlue() throws InterruptedException {
         blue.setBackground(Color.black);
         synchronized (this){
             wait(200);
         }
         blue.setBackground(myBlue);
         synchronized (this){
             wait(200);
         }
     }

     JButton getGreen(){
         return this.green;
     }

     public void shineGreen() throws InterruptedException {
         green.setBackground(Color.black);
         synchronized (this){
             wait(200);
         }
         green.setBackground(myGreen);
         synchronized (this){
             wait(200);
         }
     }

     JButton getYellow(){
         return this.yellow;
     }

     public void shineYellow() throws InterruptedException {
         yellow.setBackground(Color.black);
         synchronized (this){
             wait(200);
         }
         yellow.setBackground(myYellow);
         synchronized (this){
             wait(200);
         }
     }

     void showError(String mess) {
         JOptionPane.showMessageDialog(this, mess);
     }

 }


