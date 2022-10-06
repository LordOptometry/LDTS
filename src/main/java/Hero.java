public class Hero extends Element{

    private Position position;

    public Hero(Position position){
        super();
        this.position = position;
    }

    @Override
    void draw() {

    }

    public int getX(){return position.getx();}
    public int getY(){return position.gety();}
    public Position moveUp() {return new Position(position.getx(), position.gety() - 1);}
    public Position moveDown() {
        return new Position(position.getx(), position.gety() + 1);
    }
    public Position moveLeft() {
        return new Position(position.getx() - 1 , position.gety());
    }
    public Position moveRight() {
        return new Position(position.getx() + 1, position.gety());
    }

    public void setPosition(Position position) {this.position.setpos(position);}
}
