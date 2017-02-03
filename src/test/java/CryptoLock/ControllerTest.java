package CryptoLock;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class ControllerTest {
    @Test
    public void isValidDocument() throws Exception {
        // Test if characters (upper and lower) and numbers, hyphens and underscores (not
        // in first or last position) are allowed
        Assert.assertTrue(Controller.isValidDocument("TestDocument"));
        Assert.assertTrue(Controller.isValidDocument("Test_document"));
        Assert.assertTrue(Controller.isValidDocument("Test-document"));
        Assert.assertTrue(Controller.isValidDocument("TestDocument1"));
        Assert.assertTrue(Controller.isValidDocument("1TestDocument"));

        // Test if special characters except hyphens and underscores are not allowed
        // And only characters and numbers are allowed at the beginning and at the end of the name
        Assert.assertFalse(Controller.isValidDocument("Test'Document"));
        Assert.assertFalse(Controller.isValidDocument("Test Document"));
        Assert.assertFalse(Controller.isValidDocument("!TestDocument"));
        Assert.assertFalse(Controller.isValidDocument("_TestDocument"));
        Assert.assertFalse(Controller.isValidDocument("TestDocument_"));
    }

}