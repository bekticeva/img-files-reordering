import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class Hasher {
    private int size;

    public Hasher(int size) {
        this.size = size;
    }

    public String hash(Mat img) {
        Mat gray = new Mat();
        Mat resized = new Mat();

        Imgproc.resize(img, resized, new Size(size,size));
        Imgproc.cvtColor(resized, gray, Imgproc.COLOR_BGR2GRAY);

        double total = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                total += gray.get(i, j)[0];
            }
        }

        double average = total / (size*size);

        StringBuilder hash = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double p = gray.get(i, j)[0];

                if (p > average) {
                    hash.append("1");
                }
                else {
                    hash.append("0");
                }
            }
        }
        return hash.toString();
    }
}
