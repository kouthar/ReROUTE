public class Train extends GUIObject {

    private static int trainNumber = 0;
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
     * The max speed when capacity is not exceeded in meters per second
     */
    private final int BASE_MAX_SPEED = 24;

    /**
     * The maximum acceleration in meters per second squared
     */
    private final static int MAX_ACCEL = 1;

    /**
     * The maximum deceleration in meters per second squared
     */
    private final static int MAX_DECEL = 2;

}
