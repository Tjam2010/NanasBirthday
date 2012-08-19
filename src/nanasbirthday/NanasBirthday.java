package nanasbirthday;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class NanasBirthday extends JComponent implements KeyListener, ActionListener {

    JFrame birthday;
    String words = "Happy Birthday Nana!";
    Timer birthdayTimer = new Timer(20, this);
    Font number = new Font("Helvetica", Font.BOLD, 80);
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    String name;
    URL picURL = NanasBirthday.class.getResource("CakeLit.png");
    Image cakeLit;
    URL picURL2 = NanasBirthday.class.getResource("Cake.png");
    Image cake;
    URL bdAddress = getClass().getResource("01 Birthday.aif");
    AudioClip bdaySoundFile = Applet.newAudioClip(bdAddress);
    boolean image = false;

    public static void main(String[] args) {
        new NanasBirthday().getGoing();
    }

    private void getGoing() {
        try {
            cakeLit = ImageIO.read(picURL);
        } catch (IOException ex) {
            System.out.println("bug");
        }
        try {
            cake = ImageIO.read(picURL2);
        } catch (IOException ex) {
            System.out.println("bug");
        }
        birthday = new JFrame("Happy Birthday!");
        name = JOptionPane.showInputDialog(null, "Make a birthday wish!");
        JOptionPane.showMessageDialog(null, "Blow out the candles to make your wish come true! (Press the spacebar)");
        birthday.setVisible(true);
        bdaySoundFile.play();
        birthday.setBackground(new Color(0xC1, 0x60, 0xC3));
        birthday.setSize(width, height);
        birthday.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        birthday.add(this);
        birthday.addKeyListener(this);
        birthdayTimer.start();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.setFont(number);
        g2.drawString(words + "", width / 5, 75);
        if (image) 
        {
            g2.drawImage(cake, width / 4, 355,   this);
            g2.setColor(Color.red);
            g2.setFont(new Font("Nanum Brush Script", Font.BOLD, 80));
            g2.drawString("Woooh!!", 1100, 300);
            g2.setColor(Color.green);
            g2.setFont(new Font("Edwardian Script ITC", Font.BOLD, 80));
            g2.drawString("Happy Birthday!", 500, 200);
            g2.setColor(Color.blue);
            g2.setFont(new Font("Times New Roman", Font.BOLD, 80));
            g2.drawString("What did you wish for?", 100, 300);

        }
        else
        {
            g2.drawImage(cakeLit, width / 4, 300, this);
            g2.setColor(Color.yellow);
            g2.setFont(new Font("Edwardian Script ITC", Font.BOLD, 80));
            g2.drawString("Make a wish!", 1100, 200);
            g2.setColor(Color.orange);
            g2.setFont(new Font("Arial", Font.BOLD, 80));
            g2.drawString("Blow out the candles!", 400, 275);
            g2.setColor(Color.pink);
            g2.setFont(new Font("Verdana", Font.BOLD, 80));
            g2.drawString("Happy Birthday!", 100, 200);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent tj) 
    {
        if (tj.getKeyCode() == 32) 
        {
            image = true;
        } 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
