package CryptoLock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField documentName;

    /**
     * Checks a document name for validity.
     * A document name is valid if it starts with a character or a number,
     * ends with a character or a number,
     * doesn't contain special characters except hyphens and underscores.
     */
    public static boolean isValidDocument(String document) {
        boolean valid = true;
        if (document.isEmpty()) {
            valid = false;
        } else if (!document.matches("^[A-Za-z0-9]{1}[A-Za-z0-9-_]*[A-Za-z0-9]{1}$")) {
            valid = false;
        }

        return valid;
    }

    @FXML protected void addDocument(ActionEvent event) {
        String document = documentName.getText();
        if (!isValidDocument(document)) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a valid document name.", ButtonType.OK);
            alert.setHeaderText(null);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success.", ButtonType.OK);
            alert.setHeaderText(null);
            alert.show();
        }
    }
}
