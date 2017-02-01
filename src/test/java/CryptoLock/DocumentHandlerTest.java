package CryptoLock;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class DocumentHandlerTest {
    static private String testJson = "{'a': {'nameHash': 'a', 'contents': 'a text', 'lastEdited': '0'}}";
    @Test
    public void getDocuments() throws Exception {
        DocumentHandler.getDocuments("");
        DocumentHandler.getDocuments(testJson);
    }

    @Test
    public void getDocument() throws Exception {
        DocumentHandler.getDocument("hello");
        Assert.assertEquals(DocumentHandler.getDocument("a", testJson).contents, "a text");
        Assert.assertEquals(DocumentHandler.getDocument("a", testJson).lastEdited, "0");
    }

    @Test
    public void readDocumentsFile() throws Exception {
        
    }
}