package CryptoLock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

    public static HashMap<String, Document> getDocuments() {
        Type DocumentsType = new TypeToken<HashMap<String, Document>>(){}.getType();
        HashMap<String, Document> documents = gson.fromJson("{'abc': {'nameHash': 'abc', 'contents': 'this is text', 'lastEdited': '3'}}", DocumentsType);

        return documents;
    }

    public static Document getDocument(String nameHash) {
        return getDocuments().get(nameHash);
    }

    public static String readDocumentsFile() {
        String docFileContents = "{}";
        try {
            docFileContents = new String(Files.readAllBytes(Paths.get("documents.json")));
        } catch (IOException ex) {}

        return docFileContents;
    }
}
