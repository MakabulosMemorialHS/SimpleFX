/* ***************************************************************************
 * Temperature.java
 *
 * This JavaFX demonstration shows how to make GUI elements communicate with
 * each other. If the value in a TextField is changed, the values in the
 * other TextFields are also recalculated. To pull this off properly without
 * falling into an endless loop, we have to borrow the ideas of Qt's Signals and
 * Slots mechanism. 
 *
 * Read the documentation on JavaFX Event Handling for more information.
 *
 * Written by: Robert Pascual/
 * github.com/RobertPascualPH (c) 2016
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

public class Temperature extends Application {

    /* *****************************************************************************
     * These are the TextFields which accept user input. We put
     * them here because we want the other functions to have access to them.
     * We define three of them but you can add more if your program needs it
     * but don't forget to make the adjustments in the layout. These TextFields will be
     * layed out in start() function.
     *
     * ****************************************************************************/

    TextField celsiusValue = new TextField();
    TextField kelvinValue = new TextField();
    TextField fahrenheitValue = new TextField();


    /* ****************************************************************************
     * Thsi is the meat of the application.
     * Clicking the OK button calls this mainFunction() so this is where
     * yuou should put the business part of your javaFX application.
     * ****************************************************************************/

    public void mainFunction() {
        /* The contents of input fields are made available to
           us as Strings. Convert them to the data you require. */

        String inputOne   = celsiusValue.getText();
        String inputTwo   = fahrenheitValue.getText();
        String inputThree = kelvinValue.getText();

        try {
	    /* Here we convert the above Strings to double values. */
	    double height   = Double.parseDouble(inputOne);
	    double baseOne  = Double.parseDouble(inputTwo);
	    double baseTwo  = Double.parseDouble(inputThree);

	    /* Now compute the area of the trapezoid. */
	    double area = height*(baseOne+baseTwo)/2;

     
	    /* Output routine */
	    String output = new String("The area of the trapezoid is\n" + area);

        }
        catch (NumberFormatException e) {
            String output = new String("\nCannot parse one of the input.\n");
            return;
        }
        catch (NullPointerException e) {
            String output = new String("\nNothing to compute.\n");
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

        stage.setTitle("Convert Temperatures");

        // Now we will create a scene. A scene is composed of 
        // a root node and its children. As a root node, we will use
        // a VBox object.

        VBox rootLayout = new VBox();

        // Now we put the root node in the scene.

	Scene scene = new Scene(rootLayout);
        scene.getStylesheets().add("Temperature.css");
        rootLayout.getStyleClass().add("root-grid");

        // And assign the scene to the stage.

	stage.setScene(scene);

        // Now we add children to the root node (which is embedded in our scene).

        // First we add some Text object.
        Text bannerText = new Text("Temperature Conversion");
        bannerText.getStyleClass().add("h1");
        rootLayout.getChildren().add(bannerText);

        // We want our Labels to be aligned and we also want our
        // TextFields to be aligned. To achieve that, we put the labels
        // in a VBox, the TextFields in another VBox and then
        // place this two VBoxes into an HBox.  

        // This will be the HBox child node. Let's call it ... childHBox.
        HBox childHBox = new HBox();
        childHBox.getStyleClass().add("childHBox");

        // The Labels will get their own labelVBox.
        VBox labelVBox = new VBox();
        labelVBox.getStyleClass().add("labelVBox");

        Text labelOne = new Text("Celsius");
        labelOne.getStyleClass().add("labels");
        Text labelTwo = new Text("Fahrenheit");
        labelTwo.getStyleClass().add("labels");
        Text labelThree = new Text("Kelvin");

        labelThree.getStyleClass().add("labels");

        labelVBox.getChildren().addAll(labelOne, labelTwo, labelThree);


        // And the Textfields aren't far behind.
        VBox textFieldVBox = new VBox();
        textFieldVBox.getStyleClass().add("textFieldVBox");
        textFieldVBox.getChildren().addAll(celsiusValue, fahrenheitValue, kelvinValue);
 
        // Add the label box and the textfield box into childHBox.
        childHBox.getChildren().addAll(labelVBox, textFieldVBox);
        rootLayout.getChildren().add(childHBox);

        // We'll need two Buttons. The Button for quitting, and
        // the Button for clearing the TextFields. We put the two
        // Buttons into an HBox.

        HBox buttonBox = new HBox();
        buttonBox.getStyleClass().add("button-box");


        // The clear button
        // Clicking the CLEAR Button should clear the input and output fields.
        // All of them.

	Button clearButton = new Button();
	clearButton.setText("Clear");
        clearButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                celsiusValue.setText("");
                fahrenheitValue.setText("");
                kelvinValue.setText("");
                }
            }
        );

	Button quitButton = new Button();
	quitButton.setText("Quit");
        quitButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                Platform.exit();
                }
            }
        );

        buttonBox.getChildren().addAll(clearButton, quitButton);
        rootLayout.getChildren().add(buttonBox);

	stage.show();
    }
}
