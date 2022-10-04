import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {

    private Position position;

    public Hero(Position position) {
        this.position = position;
    }

    public void draw(Screen screen){
        screen.setCharacter(position.getx(), position.gety(), TextCharacter.fromCharacter('X')[0]);
    }
    public int getX(){return position.getx();}
    public int getY(){return position.gety();}

    public void setX(int x){position.setx(x);}
    public void setY(int y){position.sety(y);}

}
