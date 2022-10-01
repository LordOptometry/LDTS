import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;

import javax.swing.*;
import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Screen.run(game);
    }

    static Hero hero = new Hero(10, 10);

    public interface Screen{
        Screen screen = null;
        void setCursorPosition(Object o);
        void startScreen();
        void doResizeIfNecessary();

        private static void draw() throws IOException{

            screen.clear();
            screen.setCharacter(hero.getheight(), hero.getwidth(), TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        }


        private static void processKey(KeyStroke key) {

            System.out.println(key);

            if(key.getKeyType() == KeyType.ArrowUp){
                screen.setCharacter(x, y + 1, TextCharacter.fromCharacter('X')[0]);
            }
            if(key.getKeyType() == KeyType.ArrowDown){
                screen.setCharacter(x, y - 1, TextCharacter.fromCharacter('X')[0]);
            }
            if(key.getKeyType() == KeyType.ArrowRight){
                screen.setCharacter(x + 1, y, TextCharacter.fromCharacter('X')[0]);
            }
            if(key.getKeyType() == KeyType.ArrowLeft){
                screen.setCharacter(x - 1, y , TextCharacter.fromCharacter('X')[0]);
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
