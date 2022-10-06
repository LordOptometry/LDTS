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
            Position position2 = new Position (c, 0);
            walls.add(new Wall(position2));
            Position position3 = new Position(c, height-1);
            walls.add(new Wall(position3));
        }

        for (int r = 1; r< height - 1; r++){
            Position position2 = new Position (0, r);
            walls.add(new Wall(position2));
            Position position3 = new Position(width - 1, r);
            walls.add(new Wall(position3));
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
       for(Wall wall : walls){
           if(wall.getPosition().equals(position)){
               return false;
           }
       }
       return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return position.getx() == p.getx() && position.gety() == p.gety();
    }

}

