import java.util.ArrayList;

public interface Update {
    final int ScreenHeight = 300;
    final int ScreeenWidth = 300;
    final int UnitSize = 25;
    final int GameUnits = (ScreeenWidth*ScreenHeight)/UnitSize;
    final int Delay = 100;
    final ArrayList<Integer> pos_x = new ArrayList<>();
    final ArrayList<Integer> pos_y = new ArrayList<>();

    public void newApple();
    public void move();
    public void checkApple();
    public void checkCollision();
}
