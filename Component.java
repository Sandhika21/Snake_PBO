import java.awt.Color;
import java.awt.Dimension;

public class Component extends Adapter{
    public void setPanel(){
        setPreferredSize(new Dimension());
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
    }
}
