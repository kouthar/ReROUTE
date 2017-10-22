import java.awt.Button;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIObject extends Application{
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
		Button buttonLT = new Button("List Trains");
		Button buttonLS = new Button("List Stations");
		
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(0, 20, 10, 20));
		vBox.getChildren().addAll(buttonLT, buttonLS);
		
		Scene scene = new Scene(vBox, 900, 500);
		
		stage.setScene(scene);
	}
}
