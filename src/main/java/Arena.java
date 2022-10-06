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
import java.util.Random;

public class Arena {
    private int width;
    private int height;

    private Hero hero;
    private TextGraphics graphics;

    private List<Wall> walls;

    private List<Element.Coin> coins;

    private List<Monster> monsters;


    Position position = new Position(10, 10);

    public Arena(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        hero = new Hero(position);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
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
    private List<Element.Coin> createCoins() {
        Random random = new Random();
        ArrayList<Element.Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Element.Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();

        Position position2 = new Position (random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
        Position position3 = new Position (random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
        Position position4 = new Position (random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);

        monsters.add(new Monster(position2));
        monsters.add(new Monster(position3));
        monsters.add(new Monster(position4));
        return monsters;
    }
    public void draw(TextGraphics graphics){
        this.graphics = graphics;
        graphics.setBackgroundColor(TextColor.Factory.fromString("#2FA911"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#D11D1D"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getx(), position.gety()), "X");

        for (Wall wall : walls){
            wall.draw(graphics);
        }
        for(Element.Coin coin : coins){
            coin.draw(graphics);
        }

        for (Monster monster : monsters){
            monster.draw(graphics);
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

    public void moveMonster(){
        for (Monster monster : monsters){
            Position p = monster.move();
            if(canMonsterMove(p)){
                monster.setPosition(p);
            }
        }
    }
    public boolean canMonsterMove(Position position){
        for (Wall wall : walls) {
            if (wall.getPosition().getx() == position.getx() && wall.getPosition().gety() == position.gety()) {
                return false;
            }
        }
        return true;
    }
    public boolean canHeroMove(Position position){
       for(Wall wall : walls){
           if(wall.getPosition().getx() == position.getx() && wall.getPosition().gety() == position.gety()){
               return false;
           }
       }
       return true;
    }


    public boolean retrieveCoins(){
        if(coins.isEmpty()){
            System.out.println("You WON!");
            return true;
        }
        for(Element.Coin coin : coins){
            if(coin.getX() == position.getx() && coin.getY() == position.gety()){
                coins.remove(coin);
                break;
            }
        }
        return false;
    }
    public boolean verifyMonsterCollisions(){
        for(Monster monster : monsters){
            if(monster.getPosition().getx() == position.getx() && monster.getPosition().gety() == position.gety()){
                System.out.println("WASTED");
                return true;
            }
        }
        return false;
    }
}

