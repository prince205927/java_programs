import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFXInputForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane for layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add a TextField
        Label nameLabel = new Label("Enter your name:");
        TextField nameField = new TextField();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        // Add RadioButtons (using ToggleGroup)
        Label genderLabel = new Label("Gender:");
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);

        gridPane.add(genderLabel, 0, 1);
        gridPane.add(maleRadio, 1, 1);
        gridPane.add(femaleRadio, 2, 1);

        // Add CheckBoxes
        Label hobbiesLabel = new Label("Hobbies:");
        CheckBox readingCheck = new CheckBox("Reading");
        CheckBox travelingCheck = new CheckBox("Traveling");
        gridPane.add(hobbiesLabel, 0, 2);
        gridPane.add(readingCheck, 1, 2);
        gridPane.add(travelingCheck, 2, 2);

        // Add ChoiceBox (Dropdown)
        Label countryLabel = new Label("Country:");
        ChoiceBox<String> countryChoice = new ChoiceBox<>();
        countryChoice.getItems().addAll("Nepal", "India", "USA", "UK");
        gridPane.add(countryLabel, 0, 3);
        gridPane.add(countryChoice, 1, 3);

        // Add TextArea
        Label aboutLabel = new Label("About you:");
        TextArea aboutText = new TextArea();
        aboutText.setPrefRowCount(4);
        aboutText.setPrefColumnCount(20);
        gridPane.add(aboutLabel, 0, 4);
        gridPane.add(aboutText, 1, 4);

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("JavaFX Input Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
