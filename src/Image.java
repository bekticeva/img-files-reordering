import java.io.File;

public class Image {
    File file;
    String hash;

    public Image(File file, String hash) {
        this.file = file;
        this.hash = hash;
    }

    public File getFile() {
        return file;
    }
    public String getHash() {
        return hash;
    }

}
