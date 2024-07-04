import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public abstract class Graphic extends Position {
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        if(running){
            //draw the grid line on the screen
            for(int i=0; i<ScreenHeight/UnitSize; i++){
                g.drawLine(i*UnitSize, 0, i*UnitSize, ScreenHeight);
                g.drawLine(0, i*UnitSize, ScreeenWidth, i*UnitSize);
            }
            //draw the food on the screen on a random place
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UnitSize, UnitSize);
            //draw the head and the body of the snake
            for(int i =0;i<bodyParts;i++){
                if(i==0){
                    g.setColor(Color.green);             //for the head
                }else {
                    g.setColor(new Color(45,180,0)); //for the body

                }
                g.fillRect(pos_x.get(i), pos_y.get(i), UnitSize, UnitSize);
                //score
                g.setColor(Color.red);
                g.setFont(new Font("Ink Free",Font.BOLD,40));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("Score: "+applesEaten,(ScreeenWidth - metrics.stringWidth("Score: "+applesEaten))/2,g.getFont().getSize());
            }
        }else {
            gameOver(g);
        }

    }

    public void gameOver(Graphics g){
        //score
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+applesEaten, (ScreeenWidth - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        //Game over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over",(ScreeenWidth - metrics.stringWidth("Game Over"))/2,ScreenHeight/2);
    }
}
