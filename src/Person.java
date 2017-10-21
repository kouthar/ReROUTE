public class Person {

	  private String personName, stationBoardedName, stationAlightedName;
	  private int stationBoardedId, stationAlightedId, trainId;
	  private Train train;
	  private Station station;
	  
	  public void setStationNameBoarded(String stationName, int stationBoardedID){
		   this.station = station;
		   stationBoardedID = stationBoardedID;
		   stationName = stationBoardedName;
		   stationBoardedID = station.getstationBoardedID();
		   stationName = station.getStationName();
		   
	  }
	  
	  public void setStationNameAlighted(String stationName, int stationAlightedID){
		   this.station = station;
		   stationAlightedID = stationAlightedId;
		   stationName = stationAlightedId;
		   stationAlightedID = station.getstationAlightedID();
		   stationName = station.getStationName();
		   
	  }
	  
	  public String getStationBoardedName(){
		  return stationBoardedName;
	  }
	  
	  public int getStationBoardedID() {
		  return stationBoardedId;
	  }
	  
	  public String getStationAlightedName() {
		  return stationAlightedName;
	  }
	  
	  public int getStationAlightedID() {
		  return stationAlightedId;
	  }
	
	 
	 
	 public void setTrain(int trainID){
		 this.train = train;
		 trainID = trainId;
		 trainID = train.getTrainID();
		
	 }	  
	 
	 public int getTrain(){
		return trainId;
	 }
}
