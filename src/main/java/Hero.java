import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {

    private Position position;

    public Hero(Position position){
        this.position = position;
    }

    public void draw(Screen screen){
        screen.setCharacter(getX(), getY(), TextCharacter.fromCharacter('X')[0]);
    }
    public int getX(){return position.getx();}
    public int getY(){return position.gety();}

    public void setX(int x){position.setx(x);}
    public void setY(int y){position.sety(y);}
    public Position moveUp() {
        return new Position(position.getx(), position.gety() - 1);
    }
    public Position moveDown() {
        return new Position(position.getx(), position.gety() + 1);
    }
    public Position moveLeft() {
        return new Position(position.getx() - 1 , position.gety());
    }
    public Position moveRight() {
        return new Position(position.getx() + 1, position.gety());
    }

    public void setPosition(Position position) {this.position.setpos(position);}
}
