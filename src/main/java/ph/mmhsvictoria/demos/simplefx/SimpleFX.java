/* ***************************************************************************
 * SimpleFX.java
 *
 * A simple JavaFX program with input, process, and output.
 * This program has the objective of serving as a template for
 * your simple programs.
 *
 *
 * **************************************************************************/
import java.lang.*;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
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
    Text outputArea = new Text("\n\n\n");    // Initially empty.


    /* ****************************************************************************
     * Thsi is the meat of the application.
     * Clicking the OK button calls this mainFunction() so this is where
     * yuou should put the business part of your javaFX application.
     * ****************************************************************************/

    public void mainFunction() {
        /* The contents of input fields are made available to
           us as Strings. Convert them to the data you require. */

        String inputOne   = textOne.getText();
        String inputTwo   = textTwo.getText();
        String inputThree = textThree.getText();

        try {
	    /* Here we convert the above Strings to double values. */
	    double height   = Double.parseDouble(inputOne);
	    double baseOne  = Double.parseDouble(inputTwo);
	    double baseTwo  = Double.parseDouble(inputThree);

	    /* Now compute the area of the trapezoid. */
	    double area = height*(baseOne+baseTwo)/2;

     
	    /* Output routine */
	    String output = new String("The area of the trapezoid is\n" + area);

	    /* Display output */
	    outputArea.setText(output);
        }
        catch (NumberFormatException e) {
            String output = new String("\nCannot parse one of the input.\n");
            outputArea.setText(output);
            return;
        }
        catch (NullPointerException e) {
            String output = new String("\nNothing to compute.\n");
            outputArea.setText(output);
            return;
        }
    }
    
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
        outputArea.getStyleClass().add("h2");
        rootLayout.getChildren().add(outputArea);

        // Now for the Cancel, Clear, and OK Buttons
        // We create an HBox for the Buttons and place it in the layout.

        HBox buttonBox = new HBox();


        // The cancel button.
        // Clicking the CANCEL button should quit the application.

	Button CancelButton = new Button();
	CancelButton.setText("Cancel");
        CancelButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                Platform.exit();
                }
            }
        );

        // The clear button
        // Clicking the CLEAR Button should clear the input and output fields.
        // All of them.

	Button ClearButton = new Button();
	ClearButton.setText("Clear");
        ClearButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                outputArea.setText("\n\n\n");
                textOne.setText("");
                textTwo.setText("");
                textThree.setText("");
                }
            }
        );


        // The OK button
        // When the OK button is clicked, the EventHandler will call the function
        // mainFunction().
	Button OKButton = new Button();
	OKButton.setText("  OK  ");
        OKButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                mainFunction();
                }
            }
        );

        Text emptyText1 = new Text("              "); // Adjust as required. Ugly hack.

        buttonBox.getChildren().addAll(emptyText1, CancelButton, ClearButton, OKButton);
        buttonBox.getStyleClass().add("button-box"); // This should be here
                                                     // in this exact line.
                                                     // Sheeesh!
        rootLayout.getChildren().add(buttonBox);

	stage.show();
    }
}
