import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class ReRouteInterface extends Application{


    @Override
    public void start(Stage stage) {
    	
    	
    	Text headerTitle = new Text("ReROUTE Simulator");
    headerTitle.setFont(Font.font("Lato", FontWeight.BOLD, 40));
    headerTitle.setFill(Color.BLACK);
    StackPane pane = new StackPane();
	
	AnchorPane top = new AnchorPane(headerTitle);
	
    top.setBottomAnchor(headerTitle, 352.0);
    top.setTopAnchor(headerTitle, 0.0);
    top.setLeftAnchor(headerTitle, 0.0);
    top.setRightAnchor(headerTitle, 201.0);
    
    pane.getChildren().add(top);
    
    Button buttonLT = new Button("List Trains");
    
    AnchorPane right1 = new AnchorPane(buttonLT);
	
    right1.setBottomAnchor(buttonLT, 655.0);
    right1.setTopAnchor(buttonLT, 0.0);
    right1.setLeftAnchor(buttonLT, 850.0);
    right1.setRightAnchor(buttonLT, 0.0);
    
    pane.getChildren().add(right1);
    
    Button buttonLS = new Button("List Stations");
    AnchorPane right2 = new AnchorPane(buttonLS);
	
    //spacing to fix
    right2.setBottomAnchor(buttonLS, 550.0);
    right2.setTopAnchor(buttonLS, 200.0);
    right2.setLeftAnchor(buttonLS, 850.0);
    right2.setRightAnchor(buttonLS, 0.0);
    
    pane.getChildren().add(right2);
    
    Slider timeSlider = new Slider();
    timeSlider.setMin(0);
    timeSlider.setMax(100);
    timeSlider.setValue(40);
    timeSlider.setShowTickLabels(true);
    timeSlider.setShowTickMarks(true);
    timeSlider.setMajorTickUnit(50);
    timeSlider.setMinorTickCount(5);
    timeSlider.setBlockIncrement(1);
    
    AnchorPane right3 = new AnchorPane(timeSlider);
	
    right2.setBottomAnchor(timeSlider,0.0);
    right2.setTopAnchor(timeSlider, 600.0);
    right2.setLeftAnchor(timeSlider, 850.0);
    right2.setRightAnchor(timeSlider, 10.0);
    
    pane.getChildren().add(right3);
    
    Text speedText = new Text("Speed");
    speedText.setFont(Font.font("Lato", FontWeight.BOLD, 12));
    speedText.setFill(Color.BLACK);
    
    AnchorPane right4 = new AnchorPane(speedText);
    
    right4.setBottomAnchor(speedText, 100.0);
    right4.setLeftAnchor(speedText, 850.0);
    right4.setTopAnchor(speedText, 600.0);
    right4.setRightAnchor(speedText, 10.0);
    
    pane.getChildren().add(right4);
    
    
	

    Scene scene = new Scene(pane, 1000, 900);
    stage.setScene(scene);
    stage.show();
  
    		
    }

    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
