package CryptoLock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.HashMap;

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

    /**
     * Returns true if a valid document name is provided.
     * If not, it prompts the user to enter a valid name and returns false.
     */
    private static boolean ensureValidity(String document) {
        if (!isValidDocument(document)) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a valid document name.\n" +
                    "A document name is valid if it starts with a character or a number, " +
                    "ends with a character or a number and " +
                    "doesn't contain special characters except hyphens and underscores.", ButtonType.OK);
            alert.setHeaderText(null);
            alert.show();
            return false;
        }

        return true;
    }

    private static boolean createDocument(String document) {
        boolean success = DocumentHandler.addDocument(document);

        return success;
    }

    private static boolean accessDocument(String document) {
        if (ensureValidity(document)) {
            Document documentObject = DocumentHandler.getDocument(document);
            if (documentObject == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "The document you are trying to access " +
                        "does not exist.", ButtonType.OK);
                alert.setHeaderText(null);
                alert.show();
                return false;
            }
            System.out.println(documentObject.contents);
        }
        return true;
    }

    @FXML protected void addDocument(ActionEvent event) {
        String document = documentName.getText();
        if (ensureValidity(document)) {
            boolean documentCreated = createDocument(document);
            if (documentCreated) {
                accessDocument(document);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "There was an error creating " +
                        "the document.", ButtonType.OK);
                alert.setHeaderText(null);
                alert.show();
            }
        }
    }

    @FXML protected void accessDocument(ActionEvent event) {
        String document = documentName.getText();
        accessDocument(document);
    }
}
