import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Board extends Graphic implements ActionListener{

    public Board(){        
        setPanel();
        startGame();
    }

    public void startGame() {
        newApple();
        running=true;
        timer= new Timer(Delay,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }

}
