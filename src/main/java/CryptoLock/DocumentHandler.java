package CryptoLock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class DocumentHandler {
    private static Gson gson = new Gson();

    public static HashMap<String, Document> getDocuments(String json) throws ValueError {
        // Allow for testing by manually supplying a json string
        String docFile;
        if (json == "") {
            docFile = readDocumentsFile();
        } else {
            docFile = json;
        }

        if (docFile == ""){
            throw new ValueError("Invalid json file specified");
        }
        Type DocumentsType = new TypeToken<HashMap<String, Document>>(){}.getType();
        HashMap<String, Document> documents = gson.fromJson(docFile, DocumentsType);

        return documents;
    }

    public static HashMap<String, Document> getDocuments() {
        HashMap<String, Document> documents;
        try {
            documents = getDocuments("");
        } catch (ValueError ex) {
            documents = new HashMap<String, Document>();
        }

        return documents;
    }

    public static Document getDocument(String nameHash, String json) {
        try {
            return getDocuments(json).get(nameHash);
        } catch(ValueError ex) {
            return null;
        }
    }

    public static Document getDocument(String nameHash) {
        return getDocument(nameHash, "");
    }

    public static String readDocumentsFile() {
        String docFileContents = "{}";
        try {
            docFileContents = new String(Files.readAllBytes(Paths.get("documents.json")));
        } catch (IOException ex) {}

        return docFileContents;
    }
}
