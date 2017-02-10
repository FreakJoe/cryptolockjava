package CryptoLock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class DocumentViewController {
    @FXML
    TextField documentName;
    @FXML
    TextArea documentContents;
    private Document documentObject = null;

    private class initializeForm implements Runnable {
        public void run() {
            try {
                int i = 0;
                while (documentObject == null && i < 1000) {
                    Thread.sleep(1);
                    i += 1;
                }
                documentName.setText(documentObject.nameHash);
                documentContents.setText(documentObject.contents);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    public void initialize() {
        // Start a new thread to wait for the document name while the form is loaded
        (new Thread(new initializeForm())).start();
    }

    public void setDocument(Document documentObject) {
        this.documentObject = documentObject;
    }

    @FXML
    protected void cancel(ActionEvent event) {
        try {
            Stage primaryStage = Controller.getPrimaryStage();
            FXMLLoader loader = new FXMLLoader(Controller.class.getResource("CryptoLock.fxml"));
            Parent root = (Parent) loader.load();
            primaryStage.setTitle("CryptoLock");
            primaryStage.setScene(new Scene(root, 350, 300));
            primaryStage.show();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
