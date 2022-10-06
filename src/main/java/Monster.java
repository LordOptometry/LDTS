import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Monster extends Element{
    private Position position;
    private TextGraphics graphics;

    private List<Monster> monsters;



    @Override
    void draw() {

    }
    public Monster(Position position){
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public Position move(){
        int rand = (int) ((Math.random() * 4) + 1);
        if(rand == 1){
            return new Position(position.getx(), position.gety() -1);
        }
        if(rand == 2){
            return new Position(position.getx(), position.gety() +1);
        }
        if(rand == 3){
            return new Position(position.getx() - 1, position.gety());
        }
        else{
            return new Position(position.getx() +1, position.gety());
        }
    }
    public void setPosition(Position position) {this.position.setpos(position);}

    public void draw(TextGraphics graphics) {
        this.graphics = graphics;
        graphics.setForegroundColor(TextColor.Factory.fromString("#680FBC"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(new TerminalPosition(position.getx(), position.gety()), "@");
    }
}
