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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.*;

public class SimpleFX extends Application {

    /* *****************************************************************************
     * These are the TextFields which accept user input. We put
     * them here because we want the other functions to have access to them.
     * We define three of them but you can add more if your program needs it
     * but don't forget to make the adjustments in the layout. These TextFields will be
     * layed out in start() function.
     *
     * ****************************************************************************/

    TextField textOne = new TextField();
    TextField textTwo = new TextField();
    TextField textThree = new TextField();



    /* ****************************************************************************
     * Start of main(). Note that in JavaFX main() does not have much to do.
     * JavaFX relies on an event-driven model of programming.
     * ****************************************************************************/

    public static void main(String[] args) {
                                    // Main thread goes here.
        Application.launch(args);   // This is like the QApplication::exec() function in Qt.
    }
 



    /* ****************************************************************************
     * All JavaFX programs must override the start() function. Typically, this
     * function is where we setup the JavaFX elements and make the call to the
     * event-loop.
     * ****************************************************************************/

    @Override public void start(Stage stage) {

        // Do some initialization on the stage.

        stage.setTitle("JavaFX Template");

        // Now we will create a scene. A scene is composed of 
        // a root node and its children. As a root node, we will use
        // a VBox object.

        VBox rootLayout = new VBox();

        // Now we put the root node in the scene.

	Scene scene = new Scene(rootLayout);
        scene.getStylesheets().add("default.css");
        rootLayout.getStyleClass().add("grid");

        // And assign the scene to the stage.

	stage.setScene(scene);

        // Now we add children to the root node (which is embedded in our scene).

        // First we add some Text object.
        Text bannerText = new Text("Compute Area\nOf Trapezoid");
        bannerText.getStyleClass().add("h1");
        rootLayout.getChildren().add(bannerText);

        // The First input
        HBox fIBox = new HBox();

        Text labelOne = new Text("Height of trapezoid        ");
        fIBox.getChildren().addAll(labelOne, textOne);
        rootLayout.getChildren().add(fIBox);

        // The Second input

        HBox sIBox = new HBox();
        Text labelTwo = new Text("Length of shortest base ");
        sIBox.getChildren().addAll(labelTwo, textTwo);
        rootLayout.getChildren().add(sIBox);


        // The Third input
        HBox tIBox = new HBox();
        Text labelThree = new Text("Length of longest base  ");
        tIBox.getChildren().addAll(labelThree, textThree);
        rootLayout.getChildren().add(tIBox);

        // The output area.
        Text outputArea = new Text("First Line of Output\nSecond Line of Output");    // Initially empty.
        outputArea.getStyleClass().add("h2");
        rootLayout.getChildren().add(outputArea);

        // Now for the Cancel, Clear, and OK Buttons
        // We create an HBox for the Buttons and place it in the layout.

        HBox buttonBox = new HBox();


        // The cancel button.

	Button CancelButton = new Button();
	CancelButton.setText("Cancel");

        // The clear button

	Button ClearButton = new Button();
	ClearButton.setText("Clear");

        // The OK button

	Button OKButton = new Button();
	OKButton.setText("  OK  ");

        Text emptyText1 = new Text("              "); // Adjust as required. Ugly hack.

        buttonBox.getChildren().addAll(emptyText1, CancelButton, ClearButton, OKButton);
        buttonBox.getStyleClass().add("button-box"); // This should be here
                                                     // in this exact line.
                                                     // Sheeesh!
        rootLayout.getChildren().add(buttonBox);

	stage.show();
    }
}
