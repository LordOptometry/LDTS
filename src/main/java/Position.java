public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }
    public void setx(int x){this.x += x;}

    public void sety(int y){this.y += y;}

    public void setpos(Position position) {
        this.x = position.getx();
        this.y = position.gety();
    }
}
