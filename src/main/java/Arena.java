import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;

    private Hero hero;
    private TextGraphics graphics;

    private List<Wall> walls;

    Position position = new Position(10, 10);

    public Arena(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        hero = new Hero(position);
        this.walls = createWalls();
    }

    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++){
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height -1));
        }

        for (int r = 1; r< height - 1; r++){
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    public void draw(TextGraphics graphics){
        this.graphics = graphics;
        graphics.setBackgroundColor(TextColor.Factory.fromString("#38E538"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#D11D1D"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getx(), position.gety()), "X");

        for (Wall wall : walls){
            wall.draw(graphics);
        }
    }

    public void processKey(KeyStroke key){
        System.out.println(key);
        if(key.getKeyType() == KeyType.ArrowUp){
            moveHero(hero.moveUp());
        }
        if(key.getKeyType() == KeyType.ArrowDown){
            moveHero(hero.moveDown());
        }
        if(key.getKeyType() == KeyType.ArrowLeft){
            moveHero(hero.moveLeft());
        }
        if(key.getKeyType() == KeyType.ArrowRight){
            moveHero(hero.moveRight());
        }
    }
    private void moveHero(Position position){
        if(canHeroMove(position)) {
            hero.setPosition(position);
        }
    }
    public boolean canHeroMove(Position position){
        if(position.getx() == width - 1 || position.getx() == 0){return false;}
        if(position.gety() == height - 6 || position.gety() == 0){return false;}
        else {return true;}
    }

}
