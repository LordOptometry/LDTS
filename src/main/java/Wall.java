import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Wall extends Element{
    private List<Wall> walls;
    private Position position;
    private TextGraphics graphics;

    public Wall(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    void draw() {

    }

    public void draw(TextGraphics graphics) {
        this.graphics = graphics;
        graphics.setForegroundColor(TextColor.Factory.fromString("#2155B7"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(new TerminalPosition(position.getx(), position.gety()), ".");
    }
}
