import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class ColorHasher {

    public double[] colorHash (Mat img){
        Mat resized = new Mat();

        Imgproc.resize(img,resized,new Size(32,32));

        double B = 0;
        double G = 0;
        double R = 0;

        int pixels = resized.rows()*resized.cols();

        for (int i = 0; i < resized.rows(); i++) {
            for (int j = 0; j < resized.cols(); j++) {
                double[] pixel = resized.get(i,j);
                B += pixel[0];
                G += pixel[1];
                R += pixel[2];
            }
        }
        double avgB = B/pixels;
        double avgG = G/pixels;
        double avgR = R/pixels;

        return new double[]{avgB,avgG,avgR};
    }

}
