import org.opencv.core.Mat;

import java.io.File;

public class Image {
    File file;
    String hash;
    double[] color_hash;

    public Image(File file, String hash, double[] color_hash) {
        this.file = file;
        this.hash = hash;
        this.color_hash = color_hash;
    }

    public File getFile() {
        return file;
    }
    public String getHash() {
        return hash;
    }
    public double[] getColorHash() {
        return color_hash;
    }

}
