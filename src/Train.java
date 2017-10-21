public class Train extends GUIObject {

    private int id;

    /**
     * The safe train capacity
     */
    private final static int CAPACITY = 1500;

    /**
     * The max capacity, will detriment max speed
     */
    private final static int CRUSH_CAPACITY = 1800;

    /**
     * The max speed when capacity is not exceeded
     */
    private int baseMaxSpeed;

    /**
     * The maximum acceleration
     */
    private final int maxAccel;

    /**
     * The maximum deceleration
     */
    private final int maxDecel;

}
