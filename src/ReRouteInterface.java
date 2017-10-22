import java.awt.Rectangle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.text.html.ListView;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
    
    AnchorPane right = new AnchorPane(buttonLT);
	
    right.setBottomAnchor(buttonLT, 600.0);
    right.setTopAnchor(buttonLT, 0.0);
    right.setLeftAnchor(buttonLT, 850.0);
    right.setRightAnchor(buttonLT, 0.0);
    
    pane.getChildren().add(right);
    
    Button buttonLS = new Button("List Stations");
    AnchorPane left = new AnchorPane(buttonLS);
	
    left.setBottomAnchor(buttonLT, 400.0);
    left.setTopAnchor(buttonLT, 200.0);
    left.setLeftAnchor(buttonLT, 850.0);
    left.setRightAnchor(buttonLT, 0.0);
    
    pane.getChildren().add(left);
    
    

    Scene scene = new Scene(pane, 1000, 900);
    stage.setScene(scene);
    stage.show();
  
    		
    }

    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
