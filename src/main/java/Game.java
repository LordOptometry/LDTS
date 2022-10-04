import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Screen.run(game);
    }
    public interface Screen{
        Screen screen = null;

        Position position = new Position(10,10);
        Hero hero  = new Hero(position);

        private static void draw() throws IOException{

            screen.clear();
            screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        }


        private static void processKey(KeyStroke key) {

            System.out.println(key);


            if(key.getKeyType() == KeyType.ArrowUp){
                screen.setCharacter(hero.getX(), hero.getY() + 1, TextCharacter.fromCharacter('X')[0]);
            }
            if(key.getKeyType() == KeyType.ArrowDown){
                screen.setCharacter(hero.getX(), hero.getY() - 1, TextCharacter.fromCharacter('X')[0]);
            }
            if(key.getKeyType() == KeyType.ArrowRight){
                screen.setCharacter(hero.getX() + 1, hero.getY(), TextCharacter.fromCharacter('X')[0]);
            }
            if(key.getKeyType() == KeyType.ArrowLeft){
                screen.setCharacter(hero.getX() - 1, hero.getY() , TextCharacter.fromCharacter('X')[0]);
            }
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.clear();
            }

        }

        KeyStroke readInput();

        void setCharacter(int i, int i1, TextCharacter x);

        void refresh();

        void clear();

        static void run(Game game) throws IOException {
            draw();

            KeyStroke key = screen.readInput();

            while (true) {
                if (key.getKeyType() == KeyType.EOF) {
                    break;
                }
            }

            processKey(key);
        }

    }
}
