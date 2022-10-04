import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private final TerminalScreen screen;
    private Hero hero;
    public Game(int  width, int height) throws IOException {
        hero = new Hero(10, 10);

        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don’t need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
        TerminalSize terminalSize = new TerminalSize(width, height);
    }
    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }
    public void run() throws IOException {
        while (true){
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
            }
            if(key.getKeyType() == KeyType.EOF){
                break;
            }
        }
    }

    private void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        if(key.getKeyType() == KeyType.ArrowUp){
            hero.setY(-1);
            screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        }
        if(key.getKeyType() == KeyType.ArrowDown){
            hero.setY(1);
            screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        }
        if(key.getKeyType() == KeyType.ArrowLeft){
            hero.setX(-1);
            screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        }
        if(key.getKeyType() == KeyType.ArrowRight){
            hero.setX(1);
            screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        }
    }
}