import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.File;

public class ImageGridPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a grid pane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Directory path for images
        String directoryPath = "Asset Directory/images/";

        // Load images from the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // Add images to image views
        for (int i = 0; i < 4 && i < files.length; i++) {
            Image image = new Image(files[i].toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
            gridPane.add(imageView, i % 2, i / 2);
        }

        // Create scene and set it in the stage
        Scene scene = new Scene(gridPane, 450, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Grid Pane");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
