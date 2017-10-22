import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Passenger {

    private String name;
    private int id;
    private Train train;
    private Station stationBoarded, stationAlighted;
    private static int numPeople = 0;

    // how to access the text file since it isn't necessarily on my computer


    public Passenger(Station stationBoarded, Station stationAlighted) {
        id = numPeople;
        id = numPeople + 1;
        this.stationBoarded = stationBoarded;
        this.stationAlighted = stationAlighted;

    }


    public void setStationBoarded(Station station) {
        this.stationBoarded = station;
    }

    public Station getStationBoarded() {
        return stationBoarded;
    }

    public void setTrainAlighted(Station station) {
        this.stationAlighted = station;
    }

    public Station getStationAlighted() {
        return stationAlighted;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Train getTrain() {
        return train;
    }

    //distance travelled

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

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public static void main(String[] args) {
        System.out.println(randomiseName());
    }

    public double distanceToTravel() {
        return stationBoarded.distanceTo(stationAlighted);
    }


}
