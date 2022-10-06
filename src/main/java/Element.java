import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public abstract class Element{
    private Position position;

    public Element(){
        this.position = position;
    }
    public Position getPosition(){
        return position;
    }
    abstract void draw();

    public static class Coin{
        private List<Coin> coins;
        private int x;
        private int y;
        private TextGraphics graphics;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void draw(TextGraphics graphics) {
            this.graphics = graphics;
            graphics.setForegroundColor(TextColor.Factory.fromString("#FAD502"));
            graphics.enableModifiers(SGR.BORDERED);
            graphics.putString(new TerminalPosition(getX(), getY()), "o");
        }

        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
    }
}
