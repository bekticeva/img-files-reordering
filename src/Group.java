import java.util.ArrayList;

public class Group {
    private String name;
    private ArrayList<Image> images;

    public Group(String name) {
        this.name = name;
        this.images = new ArrayList<>();
    }
    public void addImage (Image img) {
        images.add(img);
    }
    public String getName() {
        return name;
    }
    public ArrayList<Image> getImages() {
        return images;
    }
}
