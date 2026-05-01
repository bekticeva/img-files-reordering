public class ImageCompare {
    public ImageCompare() {

    }

    public int compare(String h1,String h2) {
        int count = 0;

        for (int i = 0; i < h1.length(); i++) {
            if (h1.charAt(i) != h2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public double compareColor(double[]c1, double[]c2) {
        double dB = c1[0] - c2[0];
        double dG = c1[1] - c2[1];
        double dR = c1[2] - c2[2];

        return Math.sqrt(dB*dB + dG*dG + dR*dR);
    }
}
