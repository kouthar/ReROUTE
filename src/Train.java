import java.util.ArrayList;

import static java.lang.Math.abs;

public class Train extends GUIObject {
    private static int trainNumber = 0;
    private ArrayList<Passenger> manifest = new ArrayList<Passenger>();
    private ArrayList<Station> stations = new ArrayList<Station>();
    private Station nextStation;
    private boolean inStation;

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
    private final static double ACCEL = 0.9;

    /**
     * The maximum deceleration in meters per second squared
     */
    private final static double DECEL = 1.4;

    /**
     * The current passenger load
     */
    private int curLoad;

    /**
     * The current speed
     */
    private double curSpeed;

    private int id;

    public int getCurLoad() {
        return curLoad;
    }

    public void setCurLoad(int curLoad) {
        this.curLoad = curLoad;
    }

    public void setCurSpeed(int curSpeed) {
        this.curSpeed = curSpeed;
    }

    public Train() {
        id = trainNumber;
        trainNumber++;
        setCurLoad(0);
        setPos(0);
        stations = Route.getStationsArrayList();
        nextStation = stations.get(1);
        stations.remove(0);
        inStation = true;
    }

    /**
     * @return double representing the max speed dependent on passengers
     */
    public double getMaxSpeed() {
        /*
      The max speed when capacity is not exceeded in meters per second
     */
        double BASE_MAX_SPEED = 24.3;
        return BASE_MAX_SPEED - (CRUSH_CAPACITY - CAPACITY) / 30;
    }


    /**
     * @return double representing the distance to the next station in meters
     */
    public double distanceToNextStation() {
        return super.distanceTo(stations.get(0));
    }

    /**
     * @param s the station we want the distance to
     * @return double representing the distance to station s
     */
    public double distanceToStation(Station s) {
        return super.distanceTo(s);
    }

    /**
     * @return double representing the distance to the terminus station in meters
     */
    public double distanceToTerminus() {
        return super.distanceTo(stations.get(stations.size() - 1));
    }

    /**
     * Returns the time it takes to get to the next station.
     * Precondition: there is no train between this train and the next station
     *
     * @return int representing the number of seconds until arrival at the next station
     */
    public int timeToNextStation() {
        return (int) (distanceToNextStation() / curSpeed);
    }

    /**
     * Accelerate this train until the max speed has been reached.
     */
    public void accelerate() {
        if (curSpeed < this.getMaxSpeed()) {
            if (curSpeed + ACCEL <= this.getMaxSpeed()) {
                goWithAcceleration(ACCEL);
            } else {
                setPos(getPos() + curSpeed);
                curSpeed = this.getMaxSpeed();
            }
        } else {
            goWithAcceleration(0);
        }
    }

    /**
     * Decelerate until the train reaches a halt. If train in station when halted, arrive at next station.
     */
    public void decelerate() {
        if (curSpeed > 0 || curSpeed - ACCEL >= 0) {
            goWithAcceleration(-ACCEL);
        } else {
            if (abs(distanceToNextStation()) < 1.4) {
                arriveAtStation();
            }
        }
    }

    /*
     * Updates the train's position and speed with the given acceleration,
     * given 1 second of time.
     */
    private void goWithAcceleration(double acceleration) {
        setPos(getPos() + curSpeed + 0.5 * ACCEL);
        curSpeed += ACCEL;
    }

    /**
     * Accelerates or decelerates the train depending on the stopping distance.
     *
     * @param stoppingDistance the distance between the train and the closest train or station.
     */
    public void go(double stoppingDistance) {
        //DECIDES WHETHER TO ACCELERATE OR DECELERATE BASED ON STOPPING DISTANCE
        //if speed == 0, check if in station and call arriveAtStation, otherwise do nothing
        //If accelerate, use formula for distance with acceleration
        //if not accelerate, use regular formula
        //redraw train with updated position
        //if decelerate, use formula for distance with acceleration
    }

    /**
     * Handles train arrival at a station
     */
    private void arriveAtStation() {
        //HANDLES TRAINS ARRIVAL AND CHANGING THE STATIONS ARRAYLIST ETC
        assert(abs(distanceTo(nextStation)) < 1.4);
    }

    public boolean equals(Train other) {
        return this.getPos() == other.getPos() && id == other.id;
    }
}
