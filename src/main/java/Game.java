import com.googlecode.lanterna.TextCharacter;
import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Screen.run(game);
    }
    public interface Screen{
        void setCursorPosition(Object o);
        void startScreen();
        void doResizeIfNecessary();

        private static void draw() throws IOException{
            Screen screen = null;
            screen.clear();
            screen.setCharacter(10, 10, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        }

        void setCharacter(int i, int i1, TextCharacter x);

        void refresh();

        void clear();

        static void run(Game game) throws IOException {draw();}

    }
}
