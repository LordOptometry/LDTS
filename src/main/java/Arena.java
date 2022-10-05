import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;

    private Hero hero;
    private Screen screen;

    Position position = new Position(10, 10);

    public Arena(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        hero = new Hero(position);
    }

    public void draw(Screen screen){
        this.screen = screen;
        screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
    }

    public void processKey(KeyStroke key){
        System.out.println(key);
        if(key.getKeyType() == KeyType.ArrowUp){
            moveHero(hero.moveUp());
            screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        }
        if(key.getKeyType() == KeyType.ArrowDown){
            moveHero(hero.moveDown());
            screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        }
        if(key.getKeyType() == KeyType.ArrowLeft){
            moveHero(hero.moveLeft());
            screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        }
        if(key.getKeyType() == KeyType.ArrowRight){
            moveHero(hero.moveRight());
            screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        }
    }
    private void moveHero(Position position){
        if(canHeroMove(position)) {
            hero.setPosition(position);
        }
    }
    public boolean canHeroMove(Position position){
        if(position.getx() > width || position.getx() < 0){return false;}
        if(position.gety() > height || position.gety() < 0){return false;}
        else {return true;}
    }

}
