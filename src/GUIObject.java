public abstract class GUIObject {
    private double pos;

    /**
     * Creates a GUIObject object at position 0.
     */
    public GUIObject() {
        pos = 0;
    }

    /**
     * Create a GUIObject object at position pos
     *
     * @param pos the position to create the object at
     */
    public GUIObject(double pos) {
        setPos(pos);
    }

    /**
     * Returns the position of this GUIObject.
     *
     * @return the position this object.
     */
    public double getPos() {
        return pos;
    }


    /**
     * Sets the position of this GUIObject.
     * Throws IllegalArgumentException if pos not between -30200 and 30200
     *
     * @param pos the position to set this object to.
     */
    public void setPos(double pos) {
        if (-30200 <= pos && pos <= 30200) {
            this.pos = pos;
        } else {
            throw new IllegalArgumentException("Position must be between -30200 and 30200");
        }
    }

    /**
     * Returns the distance from this object to other.
     *
     * @param other the other GUIObject.
     * @return the distance from this object to other.
     */
    public double distanceTo(GUIObject other) {
        return this.pos - other.pos;
    }

    /**
     * Returns the horizontal coordinate of this object.
     *
     * @return the horizontal coordiante of this object.
     */
    public abstract double getX() ;

    /**
     * Returns the vertical coordinate of this object.
     *
     * @return the vertical coordiante of this object.
     */
    public abstract double getY() ;


    /**
     * Returns whether this object is equal to other. Two GUIObjects are equal when they have the same position.
     *
     * @return whether this object is equal to other.
     */
    public boolean equals(GUIObject other) {
        return this.pos == other.pos;
    }

}
