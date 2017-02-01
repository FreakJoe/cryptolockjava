package CryptoLock;

/**
 *
 */
public class Document {
    public String nameHash;
    public String contents;
    public String lastEdited;

    public Document(String nameHash, String contents) {
        this.nameHash = nameHash;
        this.contents = contents;
        this.lastEdited = "0";
    }
}
