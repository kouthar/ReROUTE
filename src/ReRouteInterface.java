import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReRouteInterface extends Application implements EventHandler{



    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("ReROUTE Simulator");

        StackPane rootPane = new StackPane();

        Button buttonLT = new Button("List Trains");
        Button buttonLS = new Button("List Stations");

        VBox vBox = new VBox(10);
        vBox.setFillWidth(true);
        vBox.setPadding(new javafx.geometry.Insets(0, 20, 10, 20));
        //Returns error for some reason
        vBox.getChildren().addAll(buttonLT, buttonLS);
        //how to change VBox background colour?

        Text vBoxTitle = new Text("Lists");
        vBoxTitle.setFont(javafx.scene.text.Font.font("Lato", FontWeight.BOLD, 14));
        vBoxTitle.setFill(javafx.scene.paint.Color.WHITE);
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

    public static void main(String[] args) {
        launch();
    }
}