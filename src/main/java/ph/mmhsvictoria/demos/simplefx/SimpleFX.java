/* ***************************************************************************
 * SimpleFX.java
 *
 * A simple JavaFX program with input, process, and output.
 * This program has the objective of serving as a template for
 * your simple programs.
 *
 *
 * **************************************************************************/
package ph.mmhsvictoria.demos.simplefx;

import java.lang.*;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.*;

public class SimpleFX extends Application {

    /* ****************************************************************************
     * This is the meat of the application.
     * Clicking the OK button calls this mainFunction() so this is where
     * yuou should put the business part of your javaFX application.
     * ****************************************************************************/

    public long mainFunction(int firstTerm, int secondTerm, int nValue) {
        int commonDiff = secondTerm - firstTerm;
	return (long) firstTerm + (nValue - 1) * commonDiff;
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

        /* Initialize the global variables. */

        // Do some initialization on the stage.
        GridPane rootLayout = new GridPane();
	Scene scene = new Scene(rootLayout);
        scene.getStylesheets().add("css/default.css");
        rootLayout.getStyleClass().add("grid");

        // And assign the scene to the stage.

	stage.setScene(scene);
        stage.setTitle("Demonstration Application");

        // Now we add children to the root node rootLayout (which is embedded in our scene).

        // First we add the Label at the top of the Pane.

        HBox hb = new HBox();
        hb.getStyleClass().add("title-box");
        GridPane.setColumnIndex(hb, 0);
        GridPane.setRowIndex(hb, 0);
        GridPane.setColumnSpan(hb, 2);
        Label bl = new Label("Arithmetic Sequences");
        bl.getStyleClass().add("h1");
        hb.getChildren().add(bl);
        rootLayout.getChildren().add(hb);


        // Now comes the labels for the various Inputs.

        Label lb1 = new Label("First Term");
        lb1.getStyleClass().add("field-labels");

        HBox dhbfl1 = new HBox();
        dhbfl1.setAlignment(Pos.CENTER_RIGHT);
        dhbfl1.getChildren().add(lb1);
        GridPane.setColumnIndex(dhbfl1, 0);
        GridPane.setRowIndex(dhbfl1, 1);
        GridPane.setColumnSpan(dhbfl1, 1);
        rootLayout.getChildren().add(dhbfl1);


        Label lb2 = new Label("Second Term");
        lb2.getStyleClass().add("field-labels");

        HBox dhbfl2 = new HBox();
        dhbfl2.setAlignment(Pos.CENTER_RIGHT);
        dhbfl2.getChildren().add(lb2);
        GridPane.setColumnIndex(dhbfl2, 0);
        GridPane.setRowIndex(dhbfl2, 2);
        GridPane.setColumnSpan(dhbfl2, 1);
        rootLayout.getChildren().add(dhbfl2);

        Label lb3 = new Label("Index");
        lb3.getStyleClass().add("field-labels");

        HBox dhbfl3 = new HBox();
        dhbfl3.setAlignment(Pos.CENTER_RIGHT);
        dhbfl3.getChildren().add(lb3);
        GridPane.setColumnIndex(dhbfl3, 0);
        GridPane.setRowIndex(dhbfl3, 3);
        GridPane.setColumnSpan(dhbfl3, 1);
        rootLayout.getChildren().add(dhbfl3);


        // The TextFields for the inputs come next.

        TextField tf1 = new TextField("");
        GridPane.setColumnIndex(tf1, 1);
        GridPane.setRowIndex(tf1, 1);
        GridPane.setColumnSpan(tf1, 1);
        tf1.getStyleClass().add("text-entries");
        rootLayout.getChildren().add(tf1);

        TextField tf2 = new TextField("");
        GridPane.setColumnIndex(tf2, 1);
        GridPane.setRowIndex(tf2, 2);
        GridPane.setColumnSpan(tf2, 1);
        tf2.getStyleClass().add("text-entries");
        rootLayout.getChildren().add(tf2);

        TextField tf3 = new TextField("");
        GridPane.setColumnIndex(tf3, 1);
        GridPane.setRowIndex(tf3, 3);
        GridPane.setColumnSpan(tf3, 1);
        tf3.getStyleClass().add("text-entries");
        rootLayout.getChildren().add(tf3);

        // The TextArea
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        GridPane.setColumnIndex(resultArea, 0);
        GridPane.setRowIndex(resultArea, 4);
        GridPane.setColumnSpan(resultArea, 1);
        GridPane.setRowSpan(resultArea, 3);
        resultArea.getStyleClass().add("text-area");
        rootLayout.getChildren().add(resultArea);

        // Now for the Cancel, Clear, and OK Buttons
        // We create a VBox for the Buttons and place it in the layout.

        VBox buttonBox = new VBox();
        GridPane.setColumnIndex(buttonBox, 1);
        GridPane.setRowIndex(buttonBox, 4);
        GridPane.setColumnSpan(buttonBox, 1);
        GridPane.setRowSpan(buttonBox, 3);
        buttonBox.getStyleClass().add("button-box");
        rootLayout.getChildren().add(buttonBox);

        // The OK button
        // When the OK button is clicked, the EventHandler will call the function
        // mainFunction().
	Button OKButton = new Button();
	OKButton.setText("OK");
        OKButton.getStyleClass().add("buttons");
        buttonBox.getChildren().add(OKButton);
        OKButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    int firstTerm, secondTerm, nValue;

		    try {
			/* Here we convert the above Strings to double values. */
			firstTerm  = Integer.parseInt(tf1.getText());
			secondTerm = Integer.parseInt(tf2.getText());
			nValue     = Integer.parseInt(tf3.getText());
		        long result = mainFunction(firstTerm, secondTerm, nValue);
                        resultArea.setText(String.format("\n%d", result));
		    }
		    catch (NumberFormatException exc) {
                        resultArea.setText("Illegal\nNumber\nFormat");
		    }
		    catch (NullPointerException exc) {
                        resultArea.setText("Illegal\nNumber\nFormat");
		    }
		}
	    }
        );


	Button ClearButton = new Button();
	ClearButton.setText("Clear");
        ClearButton.getStyleClass().add("buttons");
        buttonBox.getChildren().add(ClearButton);
        ClearButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                resultArea.setText("");
                }
            }
        );


        // The cancel button.
        // Clicking the CANCEL button should quit the application.

	Button CancelButton = new Button();
	CancelButton.setText("Quit");
        CancelButton.getStyleClass().add("buttons");
        buttonBox.getChildren().add(CancelButton);
        CancelButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                Platform.exit();
                }
            }
        );

       
	stage.show();
    }
}
