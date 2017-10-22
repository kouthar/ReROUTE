import java.util.ArrayList;

public class Route{
    private final String FIRSTSTATION;

    /**
     * Oldest Train (first instantiated) is last item
     */
    private ArrayList<Train> fleet = new ArrayList<Train>();

    /**
     * Returns a list of stations that are in the route.
     *
     * @param firstStation the name of the first station on the route.
     * @return a list of stations that are in the route
     */
    private Station[] setupStations (String firstStation) {
        Station first = new Station(FIRSTSTATION);
        
    }

    public ArrayList<Station> getStationArrayList(){
        //returns an ArrayList of all the stations on this route
    }

    public double getStoppingDistance(Train train) {
        //calculates train's stopping distance based on the train in front and the station in front
        //call train.distanceToNextStation & distanceToTrainInFront(train)
        if (train.distanceToNextStation() < distanceToTrainInFront(train)){

        }
        return 0;
    }

    public double distanceToTrainInFront(Train train){
        //Find the train
        int i = 0;
        int catcher = 0;
        while(i < fleet.size()){
            if(train.equals(fleet.get(i))){
                catcher = i;
            }
            i++;
        }
        return fleet.get(catcher + 1).distanceTo(train);
    }


}
