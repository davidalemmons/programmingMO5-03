import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorSelector extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Text that will change color
        Text coloredText = new Text("Sample Text");
        coloredText.setStyle("-fx-font-size: 24px;");

        // Sliders for Red, Green, Blue, and Opacity values
        Slider sliderRed = new Slider(0, 255, 0);
        sliderRed.setShowTickLabels(true);
        sliderRed.setShowTickMarks(true);

        Slider sliderGreen = new Slider(0, 255, 0);
        sliderGreen.setShowTickLabels(true);
        sliderGreen.setShowTickMarks(true);

        Slider sliderBlue = new Slider(0, 255, 0);
        sliderBlue.setShowTickLabels(true);
        sliderBlue.setShowTickMarks(true);

        Slider sliderOpacity = new Slider(0, 1, 1);
        sliderOpacity.setShowTickLabels(true);
        sliderOpacity.setShowTickMarks(true);

        // Binding the text color to the slider values
        coloredText.fillProperty().bind(Bindings.createObjectBinding(() ->
                        Color.rgb((int) sliderRed.getValue(),
                                (int) sliderGreen.getValue(),
                                (int) sliderBlue.getValue(),
                                sliderOpacity.getValue()),
                sliderRed.valueProperty(),
                sliderGreen.valueProperty(),
                sliderBlue.valueProperty(),
                sliderOpacity.valueProperty()));

        VBox root = new VBox(10);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.getChildren().addAll(new Label("Adjust the sliders to change the text color:"),
                coloredText, sliderRed, sliderGreen, sliderBlue, sliderOpacity);

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
