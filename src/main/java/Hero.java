public class Hero {

    private Position position;

    public Hero(Position position) {
        this.position = position;
    }

    public int getX(){return position.getx();}
    public int getY(){return position.gety();}

    public void setX(int x){position.setx(x);}
    public void setY(int y){position.setx(y);}

}
