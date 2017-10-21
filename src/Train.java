public class Train extends Coordinate{

    /** The safe train capacity */
    private final int capacity;

    /** The max capacity, will detriment max speed */
    private final int crushCapacity;

    /** The max speed when capacity is not exceeded */
    private int baseMaxSpeed;

    /** The maximum acceleration */
    private final int maxAccel;

    /** The maximum deceleration */
    private final int maxDecel;

}
