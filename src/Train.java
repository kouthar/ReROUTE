public class Train extends GUIObject {

    public static int getTrainNumber() {
        return trainNumber;
    }

    public static void setTrainNumber(int trainNumber) {
        Train.trainNumber = trainNumber;
    }

    private static int trainNumber = 0;

    private Station nextStation;

    /**
     * The safe train capacity
     */
    private final static int CAPACITY = 1500;

    /**
     * The max capacity, will detriment max speed
     */
    private final static int CRUSH_CAPACITY = 1800;

    /**
     * The maximum acceleration in meters per second squared
     */
    private final static double MAX_ACCEL = 1;

    /**
     * The maximum deceleration in meters per second squared
     */
    private final static double MAX_DECEL = 2;

    public int getCurLoad() {
        return curLoad;
    }

    public void setCurLoad(int curLoad) {
        this.curLoad = curLoad;
    }

    /**
     * The current passenger load
     */
    private int curLoad;

    public Train(){
        trainNumber++;
        int id = trainNumber;
        setCurLoad(0);
        setPos(0);
        ArrayList<Station> stations = Route.getStations();
    }

    public double getMaxSpeed(){
        /*
      The max speed when capacity is not exceeded in meters per second
     */
        double BASE_MAX_SPEED = 24;
        return BASE_MAX_SPEED - (CRUSH_CAPACITY - CAPACITY)/30;
    }









}
