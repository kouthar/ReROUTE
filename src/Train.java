import java.util.ArrayList;

import static java.lang.Math.abs;

public class Train extends GUIObject {
    private static int trainNumber = 0;
    private ArrayList<Passenger> manifest = new ArrayList<Passenger>();
    private ArrayList<Station> stations = new ArrayList<Station>();
    private Station nextStation;
    private Station inStation;
    private int inStationTime = 0;

    /**
     * The safe train capacity
     */
    public static final int CAPACITY = 1500;

    /**
     * The max capacity, will detriment max speed
     */
    public static final int CRUSH_CAPACITY = 1800;

    /**
     * The maximum acceleration in meters per second squared
     */
    public static final double ACCEL = 0.9;

    /**
     * The maximum deceleration in meters per second squared
     */
    public static final double DECEL = 1.4;

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

    public double getCurSpeed(){return this.curSpeed;};

    public Train(ArrayList<Station> stationsAL, Depot fromDepot) {
        id = trainNumber;
        trainNumber++;
        setCurLoad(0);
        setPos(0);
        stations = stationsAL;
        if (fromDepot.getName().equals("Sheppard West")){
            nextStation = stations.get(1);
            inStation = stations.get(0);
            stations.remove(0);
        }else{
            int index = stations.indexOf(fromDepot);
            stations = new ArrayList<>(stations.subList(index+1, stations.size()));
            index = stations.indexOf(fromDepot);
            stations = new ArrayList<>(stations.subList(index+1, stations.size()));
            nextStation = stations.get(1);
            inStation = stations.get(0);
            stations.remove(0);
        }
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
    public void go(int hourOfDay, double stoppingDistance, double distanceToTrainInFront) {
        // if train is not in station, proceed as usual
        if(inStation == null) {
            if (stoppingDistance == 150){
                if(distanceToTrainInFront >= stoppingDistance) accelerate();
                else decelerate();
            }else{
                if(distanceToNextStation() >= stoppingDistance) accelerate();
                else decelerate();
            }
        }
        // if train is in station
        else{
            //if train has stopped long enough
            if(inStationTime >= inStation.getStopTime(hourOfDay)){
                // if the train in front is not too close, proceed & leave the station
                if(distanceToTrainInFront >= stoppingDistance){
                    accelerate();
                    inStation = null;
                    inStationTime = 0;
                }
                // if the train in front is too close, do nothing
            }
            //if train has not stopped long enough, increment the timer
            else{
                inStationTime += 1;
            }
        }
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

    public double getX(){
        if (Math.abs(getPos()) <= 17700){
            return 446;
        }
        if (Math.abs(getPos()) <= 18500){
            return 422 + (getPos() - 17700)/ 33;
        }
        if (Math.abs(getPos()) <= 20900){
            return 422;
        }
        if (Math.abs(getPos()) <= 21500){
            return 404 + (getPos() - 20900)/ 33;
        }
        return 404;
    }

    public double getY() {
        if (Math.abs(getPos()) <= 17700) {
            return (getPos() / 33) + 25;
        }
        if (Math.abs(getPos()) > 17700 && Math.abs(getPos()) <= 18500) {
            return 25;
        }
        if (Math.abs(getPos()) > 20900 && Math.abs(getPos()) <= 21500) {
            return 25 + 103;
        }
        if (Math.abs(getPos()) > 18500 && Math.abs(getPos()) <= 20900) {
            return (getPos() / 33) + 25;
        }
        return (getPos() / 33) + 25;
    }
}
