public class Train extends GUIObject {

    public static int getTrainNumber() {
        return trainNumber;
    }

    public static void setTrainNumber(int trainNumber) {
        Train.trainNumber = trainNumber;
    }

    private static int trainNumber = 0;

    private ArrayList<Person> manifest = new ArrayList<Person>();
    private ArrayList<Station> stations = new ArrayList<Station>();
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
    private final static double MAX_ACCEL = 0.9;

    /**
     * The maximum deceleration in meters per second squared
     */
    private final static double MAX_DECEL = 1.4;

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

    private int curSpeed;

    public Train(){
        trainNumber++;
        int id = trainNumber;
        setCurLoad(0);
        setPos(0);
        stations = Route.getStations();
    }

    /**
     *
     * @return double representing the max speed dependent on passengers
     */
    public double getMaxSpeed(){
        /*
      The max speed when capacity is not exceeded in meters per second
     */
        double BASE_MAX_SPEED = 24.3;
        return BASE_MAX_SPEED - (CRUSH_CAPACITY - CAPACITY)/30;
    }

    public void arriveAtNextStation(){

    }

    public double distanceToNextStation(){
        return super.distanceTo(stations.get(0));
    }

    public double distanceToStation(station s){
        return super.distanceTo(s);
    }

    public double distanceToTerminus(){
        return super.distanceTo(stations.get(stations.size() - 1));
    }

    public int timeToNextStation(){
        distanceToNextStation() /
    }
}
