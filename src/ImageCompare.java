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
}
