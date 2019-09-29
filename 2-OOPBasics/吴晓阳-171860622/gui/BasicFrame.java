package gui;

import javax.swing.*;
import java.awt.*;

public class BasicFrame extends JFrame {
    public BasicFrame(){
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    public void loadFrame(){
        setVisible(true);
        //new RefreshThread().start();
    }

    /*
     * @param g
     */
    Image backImg = null;

    @Override
    public void update(Graphics g){
        if(backImg == null){
            backImg = createImage(getWidth(), getHeight());
        }
        Graphics backg = backImg.getGraphics();
        Color c = backg.getColor();
        backg.setColor(Color.BLACK);
        backg.fillRect(0, 0, getWidth(), getHeight());
        backg.setColor(c);
        paint(backg);
        g.drawImage(backImg, 0, 0, null);
    }

    /*
     * @param args
     */
    class RefreshThread extends Thread{
        @Override
        public void run() {
            while(true){
                SwingUtilities.invokeLater(()->BasicFrame.this.repaint());
                try{
                    sleep(30);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
