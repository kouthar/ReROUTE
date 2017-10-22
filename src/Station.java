import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
    Random rand = new Random();
    public static final int MAX_STOP_TIME = 60;

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

    private int getInflow(int hourOfDay){
        int midInflow = (int)((inflowRange[1] - inflowRange[0])/2);
        // if morning rush (7-9), non-downtown stations will be busier
        if (hourOfDay <= 9 && hourOfDay >= 7){
            return ThreadLocalRandom.current().nextInt(midInflow, inflowRange[1] + 1);
        }else{
            return ThreadLocalRandom.current().nextInt(inflowRange[0], midInflow + 1);
        }
    }

    private int getOutflow(int hourOfDay){
        int midInflow = (int)((outflowRange[1] - outflowRange[0])/2);
        // if morning rush (7-9), non-downtown stations will be busier
        if (hourOfDay <= 9 && hourOfDay >= 7){
            return ThreadLocalRandom.current().nextInt(midInflow, outflowRange[1] + 1);
        }else{
            return ThreadLocalRandom.current().nextInt(outflowRange[0], midInflow + 1);
        }
    }

    public int getStopTime(int hourOfDay){
        ArrayList<Integer> list = new ArrayList<>();
        list.add((getInflow(hourOfDay) + getOutflow(hourOfDay)) * 2);
        list.add(MAX_STOP_TIME);
        return Collections.min(list);
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
