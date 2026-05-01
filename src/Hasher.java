import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class Hasher {

    public String hash(Mat img) {
        Mat gray = new Mat();
        Mat resized = new Mat();

        Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.resize(gray, resized, new Size(50,50));

        double total = 0;

        for (int i = 0; i < resized.rows(); i++) {
            for (int j = 0; j < resized.cols(); j++) {
                total += resized.get(i, j)[0];
            }
        }

        double average = total / (resized.rows()*resized.cols());

        StringBuilder hash = new StringBuilder();

        for (int i = 0; i < resized.rows(); i++) {
            for (int j = 0; j < resized.cols(); j++) {
                double pixel = resized.get(i, j)[0];

                if(pixel >= average){
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
