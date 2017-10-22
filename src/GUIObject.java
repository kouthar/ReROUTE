import java.awt.Button;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIObject extends Application implements EventHandler {
    private double pos;

    /**
    * Creates a GUIObject object at position 0.*/
    public GUIObject() {
        pos = 0;
    }

    /**
     * Create a GUIObject object at position pos
     *
     * @param pos the position to create the object at
     */
    public GUIObject(double pos) {
        setPos(pos);
    }

    /**
    * Returns the position of this GUIObject.
    *
    * @return the position this object.
    * */
    public double getPos() {
        return pos;
    }


    /**
     * Sets the position of this GUIObject.
     * Throws IllegalArgumentException if pos not between -30200 and 30200
     *
     * @param pos the position to set this object to. */
    public void setPos(double pos) {
        if (-30200 <= pos && pos <= 30200){
            this.pos = pos;
        }
        else{
            throw new IllegalArgumentException("Position must be between -30200 and 30200");
        }
    }

    /**
     * Returns the distance from this object to other.
     *
     * @param other the other GUIObject.
     * @return      the distance from this object to other.
     */
    public double distanceTo(GUIObject other) {
        return this.pos - other.pos;
    }

    /**
     * Returns the horizontal coordinate of this object.
     *
     * @return the horizontal coordiante of this object.*/
    public double getX(){return 0;}

    /**
     * Returns the vertical coordinate of this object.
     *
     * @return the vertical coordiante of this object.*/
    public double getY(){return 0;}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ReROUTE Simulator");
		
		StackPane rootPane = new StackPane();
		
		Button buttonLT = new Button("List Trains");
		Button buttonLS = new Button("List Stations");
		
		VBox vBox = new VBox(10);
		vBox.setFillWidth(true);
		vBox.setPadding(new Insets(0, 20, 10, 20));
		//Returns error for some reason
		vBox.getChildren().addAll(buttonLT, buttonLS);
		//how to change VBox background colour?
		
		Text vBoxTitle = new Text("Lists");
		vBoxTitle.setFont(Font.font("Lato", FontWeight.BOLD, 14));
		vBoxTitle.setFill(Color.WHITE);
		vBox.getChildren().add(vBoxTitle);
		
		HBox header = new HBox();
		header.setPadding(new Insets(15, 12, 15, 12));
	    header.setSpacing(10);
	    header.setStyle("-fx-background-color: ##19b585;");	
		Text headerTitle = new Text("ReROUTE Simulator");
	    headerTitle.setFont(Font.font("Lato", FontWeight.BOLD, 16));
	    headerTitle.setFill(Color.WHITE);
		header.getChildren().add(headerTitle);
		
		rootPane.getChildren().addAll(vBox, header);
	    Scene scene = new Scene(rootPane, 900, 500);
	    
		
		stage.setScene(scene);
	}

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		
	}
}
