public class GUIObject {
    private double pos;

    /**
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

    /**
    * Returns the position of this GUIObject.
    *
    * @return the position this object.
    * */
    public double getPos() {
        return pos;
    }


    /**
     * Set the position of this GUIObject.
     *
     * @param pos the position to set this object to. */
    public void setPos(double pos) {
        this.pos = pos;
    }

    /**
     * Returns the distance from this object to other.
     *
     * @param other the other GUIObject.
     * @return      the distance from this object to other.
     */
    public double distanceTo(GUIObject other) {
        return this.pos - other.pos;
    }

    /**
     * Returns the horizontal coordinate of this object.
     *
     * @return the horizontal coordiante of this object.*/
    public double getX(){return 0;}

    /**
     * Returns the vertical coordinate of this object.
     *
     * @return the vertical coordiante of this object.*/
    public double getY(){return 0;}
}
