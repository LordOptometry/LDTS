public abstract class Element{
    private Position position;

    public Element(){
        this.position = position;
    }
    public Position getPosition(){
        return position;
    }
    abstract void draw();
}
