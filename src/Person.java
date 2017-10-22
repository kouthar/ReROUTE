import java.io.BufferedReader;
import java.io.FileReader;

public class Person {

	  private String name;
	  private int id;
	  private Train train;
	  private Station station;
	  
	  	// returns an error
	    FileReader in = new FileReader("/src/FirstNames.txt");

	  BufferedReader reader = new BufferedReader(in);
	  
	  public void setStationBoarded(Station station){
		   this.station = station;
	  }
	  
	  public Station getStationBoarded(){
	    return station;
	  }
	  
	 public void setTrainAlighted(Station station){
	   this.station = station;
	 }
	  
	 public Station getStationAlighted(){
	   return station;
	 }
	 
	 public void setTrain(Train train) {
		 this.train = train;
	 }
	 
	 public Train getTrain() {
		 return train;
	 }
	 
	 public void setName(String name) {
			 int i = (int) Math.random();
			 for (int j = 0; j < i; j++) {
				 this.name = reader.readLine();
			 }
			 
	 }
	 
	 public String getName() {
		 return name;
	 }
	
	public void setID(int id) {
		 this.id = id;
	 }
	 
	 public int getID() {
		 return id;
	 }
	
	}
