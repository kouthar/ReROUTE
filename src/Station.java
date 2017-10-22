import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Station extends GUIObject {
    private String name;
    private String id;
    private int[] inflowRange = new int[2];
    private int[] outflowRange = new int[2];
    private Station nextStation, previousStation;
    public Station getNextStation(){
        return nextStation;
    }
    public Station getPreviousStation(){
        return previousStation;
    }
    public String getName(){
        return name;
    }

    public Station(){
    }

    public Station(String stationName, Station previousStation) {
        String filename = "/res/stations/" + stationName + ".txt";
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            name = in.readLine();
            id = in.readLine();
            setPos(Double.parseDouble(in.readLine()));
            String[] inflow = in.readLine().split(", ");
            inflowRange[0] = Integer.parseInt(inflow[0]);
            inflowRange[1] = Integer.parseInt(inflow[1]);
            String[] outflow = in.readLine().split(", ");
            outflowRange[0] = Integer.parseInt(outflow[0]);
            outflowRange[1] = Integer.parseInt(outflow[1]);
            String next = in.readLine();
            if(next.equals("null"))
                nextStation = null;
            else
                nextStation = new Station(next, this);
            this.previousStation = previousStation;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getStopTime(){
        return 30;
    }
}
