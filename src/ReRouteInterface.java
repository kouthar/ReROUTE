import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReRouteInterface extends Application implements EventHandler{



    @Override
    public void start(Stage stage) throws Exception {
    		
    	
    		int height = 900;
    		int width = 900;
    		
    		int headerInsetTop = 15;
    		int headerInsetRight = 12;
    		int headerInsetBottom = 15;
    		int headerInsetLeft = 12;
    		
    		int LPInsetTop = 0;
    		int LPInsetRight = 20;
    		int LPInsetBottom = 10;
    		int LPInsetLeft = 20;
    		
    		int rightPaneX = 0;
    		int rightPaneY = 0;
        stage.setTitle("ReROUTE Simulator");

        StackPane rootPane = new StackPane();

        Button buttonLT = new Button("List Trains");
        Button buttonLS = new Button("List Stations");
        
        //Using dummy values for insets for now
        Pane leftPane  = new Pane();
        leftPane.setPadding(new javafx.geometry.Insets(LPInsetTop, LPInsetRight, 
        		LPInsetBottom, LPInsetLeft));
        //Returns error for some reason
        leftPane.getChildren().addAll(buttonLT, buttonLS);
        //how to change VBox background colour?

        Text leftPaneTitle1 = new Text("Lists");
        leftPaneTitle1.setFont(javafx.scene.text.Font.font("Lato", FontWeight.BOLD, 14));
        leftPaneTitle1.setFill(javafx.scene.paint.Color.WHITE);
        leftPane.getChildren().add(leftPaneTitle1);

        HBox header = new HBox();
        header.setPadding(new Insets(headerInsetTop, headerInsetRight, headerInsetBottom, headerInsetRight));
        header.setSpacing(10);
        header.setStyle("-fx-background-color: ##19b585;");
        Text headerTitle = new Text("ReROUTE Simulator");
        headerTitle.setFont(Font.font("Lato", FontWeight.BOLD, 16));
        headerTitle.setFill(Color.WHITE);
        header.getChildren().add(headerTitle);
        
        //idk if these height/width measurements are correct
        Canvas canvas = new Canvas(width - LPInsetRight, height - headerInsetTop);
        canvas.setLayoutX(rightPaneX);
        canvas.setLayoutY(rightPaneY);
        //idk if these are correct
        canvas.setHeight(height - headerInsetTop);
        canvas.setWidth(width - LPInsetLeft);
        
        StackPane  rightPane = new StackPane();
        rightPane.getChildren().add(canvas);
        rightPane.setStyle("-fx-background-color: black");

        

        rootPane.getChildren().addAll(leftPane, rightPane, header);
        Scene scene = new Scene(rootPane, width, height);


        stage.setScene(scene);
    }

    @Override
    public void handle(Event arg0) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        launch(args);
    }
}
