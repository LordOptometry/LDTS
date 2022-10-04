import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    static TerminalScreen screen;
    public Game() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminal = terminalFactory.createTerminal();
    }


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

    private static void draw() throws IOException{

        screen.clear();
        screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }




    static Position position = new Position(10,10);
    static Hero hero  = new Hero(position);




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

    KeyStroke readInput() {
        return null;
    }





}
