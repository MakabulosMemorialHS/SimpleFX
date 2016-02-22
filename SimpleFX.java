/* ***************************************************************************
 * SimpleFX.java
 *
 * A simple JavaFX program with input, process, and output.
 * This program has the objective of serving as a template for
 * your simple programs.
 *
 * Revision History:
 *
 * $Id$
 *
 * $Log$
 *
 * **************************************************************************/
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.*;

public class SimpleFX extends Application {

    public static void main(String[] args) {
                                    // Main thread goes here.
        Application.launch(args);   // This is like the QApplication::exec() function in Qt.
    }
 
    @Override public void start(Stage stage) {

        // Do some initialization on the stage.

        stage.setTitle("JavaFX Template");

        // Now we will create a scene. A scene is composed of 
        // a root node and its children. As a root node, we will use
        // a GridPane object.

        GridPane GridLayout = new GridPane();
        GridLayout.setAlignment(Pos.CENTER);

        // Now we put the root node in the scene.

	Scene scene = new Scene(GridLayout);
        scene.getStylesheets().add("default.css");
        GridLayout.getStyleClass().add("grid");

        // And assign the scene to the stage.

	stage.setScene(scene);

        // Now we add children to the root node (which is embedded in our scene).

        // First we add some Text object.
        Text bannerText = new Text("Compute Area Of Trapezoid");
        bannerText.getStyleClass().add("h1");
        GridLayout.add(bannerText, 1, 1, 2, 1);

        // The First input
        Text labelOne = new Text("Height of trapezoid");
        GridLayout.add(labelOne, 1,2, 1, 1);
        TextField textOne = new TextField();
        GridLayout.add(textOne,  2,2, 1, 1);


        // The Second input
        Text labelTwo = new Text("Length of shortest base");
        GridLayout.add(labelTwo, 1, 3, 1, 1);
        TextField textTwo = new TextField();
        GridLayout.add(textTwo,  2, 3, 1, 1);


        // The Third input
        Text labelThree = new Text("Length of longest base");
        GridLayout.add(labelThree, 1, 4, 1, 1);
        TextField textThree = new TextField();
        GridLayout.add(textThree,  2, 4, 1, 1);


        // The output area.
        Text outputArea = new Text(" ");    // Initially empty.
        GridLayout.add(outputArea,  1, 5, 2, 2);

        // Now for the Cancel and OK Buttons
        // We create an HBox for the Buttons and place it in the layout.

        HBox buttonBox = new HBox();
        GridLayout.add(buttonBox, 1, 7, 2, 1);


        // The cancel button.

	Button CancelButton = new Button();
	CancelButton.setText("Cancel");

	Button OKButton = new Button();
	OKButton.setText("  OK  ");

        Text emptyText1 = new Text("                      "); // Adjust as required. Ugly hack.

        buttonBox.getChildren().addAll(emptyText1, CancelButton, OKButton);
        buttonBox.getStyleClass().add("button-box"); // This should be here
                                                     // in this exact line.
                                                     // Sheeesh!


        // Need to add some spacer
        Text spacer1 = new Text("                      ");
        GridLayout.add(spacer1, 1, 3);

	stage.show();
    }
}
