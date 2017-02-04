package CryptoLock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 *
 */
public class DocumentHandler {
    private static Gson gson = new Gson();
    public static String fileName = "documents.json";
    public static String testFileName = "testDocuments.json";

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

    public static boolean saveDocumentsFile(String documents) {
        boolean success = true;
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.write(documents);
            writer.close();
        } catch (IOException e) {
            success = false;
        }
        return success;
    }

    public static boolean saveDocumentsFile(HashMap<String, Document> documents) {
        boolean success = true;
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.write(gson.toJson(documents));
            writer.close();
        } catch (IOException e) {
            success = false;
        }
        return success;
    }

    public static Document getDocument(String nameHash, String json) {
        try {
            return getDocuments(json).get(nameHash);
        } catch(ValueError ex) {
            return null;
        }
    }

    public static boolean addDocument(String documentName) {
        HashMap<String, Document> documents = getDocuments();
        Document document = new Document(documentName, "");
        documents.put(documentName, document);
        boolean success = saveDocumentsFile(documents);

        return success;
    }

    public static Document getDocument(String nameHash) {
        return getDocument(nameHash, "");
    }

    public static String readDocumentsFile() {
        String docFileContents = "{}";
        try {
            docFileContents = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException ex) {}

        return docFileContents;
    }
}
