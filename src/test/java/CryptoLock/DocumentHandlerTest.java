package CryptoLock;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class DocumentHandlerTest {
    static private String testJson = "{'a': {'nameHash': 'a', 'contents': 'a text', 'lastEdited': '0'}}";

    /**
     * @throws Exception
     * Tests whether json is properly saved to the documents.json file and accessible
     */
    @Test
    public void saveDocumentsFile() throws Exception {
        DocumentHandler.fileName = DocumentHandler.testFileName;
        DocumentHandler.saveDocumentsFile(testJson);
        Assert.assertEquals(DocumentHandler.getDocument("a").contents, "a text");
    }

    /**
     * @throws Exception
     * Tests whether the entirety of documents can properly be loaded from json
     */
    @Test
    public void getDocuments() throws Exception {
        DocumentHandler.getDocuments("");
        DocumentHandler.getDocuments(testJson);
    }

    /**
     * @throws Exception
     * Tests whether single documents are loaded properly.
     */
    @Test
    public void getDocument() throws Exception {
        DocumentHandler.getDocument("hello");
        Assert.assertEquals(DocumentHandler.getDocument("b", testJson), null);
        Assert.assertEquals(DocumentHandler.getDocument("a", testJson).contents, "a text");
        Assert.assertEquals(DocumentHandler.getDocument("a", testJson).lastEdited, "0");
    }
}