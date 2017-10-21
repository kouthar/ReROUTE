public class Person {

	  private String name;
	  private int id;
	  private Train train;
	  private Station station;
	  
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
		 this.name = name;
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
