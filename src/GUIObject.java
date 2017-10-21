public class GUIObject {
    private double pos;

    public GUIObject() {
        pos = 0;
    }

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
     * Return the distance from this object to other
     */
    public double distanceTo(GUIObject other) {
        return this.pos - other.pos;
    }
}
