package CryptoLock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField documentName;

    public static boolean isValidDocument(String document) {
        boolean valid = true;
        if (document.isEmpty()) {
            valid = false;
        }

        return valid;
    }

    @FXML protected void addDocument(ActionEvent event) {
        String document = documentName.getText();
        if (!isValidDocument(document)) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Please enter a valid document name.", ButtonType.OK);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.NONE, "Success.", ButtonType.OK);
            alert.show();
        }
    }
}
