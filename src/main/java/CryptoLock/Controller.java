package CryptoLock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.lang.reflect.Type;
import java.util.HashMap;

public class Controller {
    @FXML protected void addDocument(ActionEvent event) {
        //System.out.println(DocumentHandler.getDocument("abc").contents);
        System.out.println(DocumentHandler.readDocumentsFile());
    }
}
