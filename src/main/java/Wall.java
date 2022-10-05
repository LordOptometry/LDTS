import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Wall {
    private List<Wall> walls;
    private int c;
    private int i;
    private TextGraphics graphics;

    public Wall(int c, int i) {
        this.c = c;
        this.i = i;
    }

    public int getC() {
        return c;
    }

    public int getI() {
        return i;
    }

    public void draw(TextGraphics graphics) {
        this.graphics = graphics;
        graphics.setForegroundColor(TextColor.Factory.fromString("#2155B7"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(new TerminalPosition(c, i), ".");
    }
}
