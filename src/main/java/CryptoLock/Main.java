package CryptoLock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CryptoLock.fxml"));
        Parent root = (Parent) loader.load();
        primaryStage.setTitle("CryptoLock");
        primaryStage.setScene(new Scene(root, 350, 300));
        Controller controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
