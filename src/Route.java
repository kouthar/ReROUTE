import java.util.ArrayList;

public class Route{
    private Station[] stations;

    /**
     * Oldest Train (first instantiated) is last item
     */
    private ArrayList<Train> fleet = new ArrayList<Train>();

    public Route(String firstStation){
        stations = setupStations(firstStation);
    }

    /**
     * Returns a list of stations that are in the route.
     *
     * @param firstStation the name of the first station on the route.
     * @return a list of stations that are in the route
     */
    private Station[] setupStations (String firstStation) {
        Station cur = new Station(firstStation, null);
        ArrayList<Station> stationsAL = new ArrayList<Station>();
        if(cur.getNextStation() != null){
            stationsAL.add(cur);
            cur = cur.getNextStation();
        }
        stationsAL.add(cur);
        Station[] stations = new Station[stationsAL.size()];
        for(int i = 0; i < stationsAL.size(); i++){
            stations[i] = stationsAL.get(i);
        }

        return stations;
    }

    public double getStoppingDistance(Train train) {
        //calculates train's stopping distance based on the train in front and the station in front
        //call train.distanceToNextStation & distanceToTrainInFront(train)
        if (train.distanceToNextStation() < distanceToTrainInFront(train)){
            return train.getCurSpeed() * train.getCurSpeed() / (2 * Train.DECEL);
        }else{
            return 150;
        }
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

    private ArrayList<Station> getStationArrayList(){
        //returns an ArrayList of all the stations on this route
        ArrayList<Station> stationsAL = new ArrayList<>();
        for(int i = 0; i < stations.length; i++){
            stationsAL.add(stations[i]);
        }

        return stationsAL;
    }

    public void runTrains(int hourOfDay, boolean startNew, Depot fromDepot){
        //Setup over one iteration
        if(startNew){
            fleet.add(0, new Train(getStationArrayList(), fromDepot));
        }
        for(int i = 0; i < fleet.size(); i++){
            fleet.get(i).go(hourOfDay, getStoppingDistance(fleet.get(i)), distanceToTrainInFront(fleet.get(i)));
        }
    }
}
