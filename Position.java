public class Position extends Component implements Update{

    public void newApple(){
        appleX = random.nextInt((int) (ScreeenWidth/UnitSize))*UnitSize;
        appleY = random.nextInt((int) (ScreenHeight/UnitSize))*UnitSize;
    }

    public void move(){
        for(int i = bodyParts;i>0;i--){
            pos_x.set(i, pos_x.get(i-1));
            pos_y.set(i, pos_y.get(i-1));

        }
        switch (direction){
            case 'U':
                pos_y.set(0, pos_y.get(0) - UnitSize);
                break;
            case 'D':
                pos_y.set(0, pos_y.get(0) + UnitSize);
                break;
            case 'L':
                pos_x.set(0, pos_x.get(0) - UnitSize);
                break;
            case 'R':
                pos_x.set(0, pos_x.get(0) + UnitSize);
                break;
        }
    }

    public void checkApple(){
        if((pos_x.get(0) == appleX) && (pos_x.get(0) == appleY)){
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollision(){
        //checks if head collide the body
        for(int i = bodyParts;i>0;i--){
            if((pos_x.get(0)== pos_x.get(i)) && (pos_y.get(0)== pos_y.get(i))){
                running = false;
            }
        }
        //check if head touches left border
        if(pos_x.get(0) < 0){
            running = false;
        }
        //checks if head touches right border
        if(pos_x.get(0) > ScreeenWidth){
            running = false;
        }
        //checks if head touched top border
        if(pos_y.get(0) < 0){
            running = false;
        }
        //checks if head touched bottom border
        if(pos_y.get(0) > ScreenHeight){
            running = false;
        }
        if(!running){
            timer.stop();
        }
    }
}
