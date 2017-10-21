public class GUIObject {
    private double pos;

    /*
    * Creates a GUIObject object at position 0.*/
    public GUIObject() {
        pos = 0;
    }

    /**
     * Create a GUIObject object at position pos
     *
     * @param pos the position to create the object at
     */
    public GUIObject(double pos) {
        this.pos = pos;
    }

    public double getPos() {
        return pos;
    }

    public void setPos(double pos) {
        this.pos = pos;
    }

    /**
     * Return the distance from this object to other.
     *
     * @param other the other GUIObject.
     * @return      the distance from this object to other.
     */
    public double distanceTo(GUIObject other) {
        return this.pos - other.pos;
    }

    public double getX(){return 0;}
    public double getY(){return 0;}
}
