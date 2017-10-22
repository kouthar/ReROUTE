import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Passenger {
    /**
     * Name of the Passenger
     */
    private String name;

    /**
     * ID of the Passenger
     */
    private int id;

    /**
     * Position of the train
     */
    private double trainPos;

    /**
     * Train object
     */
    private Train train;

    /**
     * Station objects for stations boarded and alighted
     */

    /**
     * GUI Object
     */
    private GUIObject GUIObject;

    private Station stationBoarded, stationAlighted;

    /**
     * Counter of number of people instances
     */
    private static int numPeople = 0;


    /**
     * Constructor for Passenger initialisation
     *
     * @param stationBoarded
     * @param stationAlighted
     */
    public Passenger(Station stationBoarded, Station stationAlighted, Train train) {
        id = numPeople;
        id = numPeople + 1;
        this.stationBoarded = stationBoarded;
        this.stationAlighted = stationAlighted;
        this.train = train;

    }

    /**
     * Sets the station the passenger boards
     *
     * @param station
     */
    public void setStationBoarded(Station station) {
        this.stationBoarded = station;
    }

    /**
     * Gets station the passenger boarded
     *
     * @return station
     */
    public Station getStationBoarded() {
        return stationBoarded;
    }

    /**
     * Sets the station of which the passengers gets off
     *
     * @param station
     */
    public void setTrainAlighted(Station station) {
        this.stationAlighted = station;
    }

    /**
     * Sets the station of which the passengers gets off
     *
     * @return station
     */
    public Station getStationAlighted() {
        return stationAlighted;
    }

    /**
     * Sets the train the passenger is on
     *
     * @param train
     */
    public void setTrain(Train train) {
        this.train = train;
    }

    /**
     * Gets the train the passenger is on
     *
     * @return train
     */
    public Train getTrain() {
        return train;
    }

    /**
     * Creates array list with the names from a list of names from a .txt file and
     * returns a random name from that list
     *
     * @return name
     */
    public static String randomiseName() {
        ArrayList<String> names = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("res/Names.txt"));
            String name;
            while ((name = in.readLine()) != null) {
                names.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int low = 0;
        int high = names.size();
        int result = random.nextInt(high - low) + low;

        return names.get(result);


    }

    /**
     * Sets ID of the passenger - based on how many passengers use the train system
     *
     * @param id
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the passenger
     *
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Uses GUIObject to set positions of train station boarded and alighted and
     * returns the total distance travelled
     *
     * @param stationAlighted
     * @param stationBoarded
     * @param gui
     * @return distanceTraveled
     */
    public double distanceTraveled(Station stationAlighted, Station stationBoarded, GUIObject gui) {
        return stationBoarded.distanceTo(stationAlighted);
    }

}

