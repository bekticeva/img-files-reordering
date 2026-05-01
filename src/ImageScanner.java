import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

public class ImageScanner {
    private String folder_path;

    public ImageScanner(String folder_path){
        this.folder_path = folder_path;
    }

    static final String[] EXTENSIONS = new String[]{
            "jpg", "jpeg", "png", "bmp"
    };

    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    public ArrayList<File> scan(){
        ArrayList<File> images = new ArrayList<>();
        scanRec(new File(folder_path),images);
        return images;
    }
    private void scanRec(File dir,ArrayList<File> images){
        if(!dir.isDirectory())return;

        File[] files = dir.listFiles();
        if(files == null)return;

        for (File file : files) {
            if (file.isDirectory()) {
                scanRec(file,images);
            } else if (IMAGE_FILTER.accept(dir, file.getName())) {
                images.add(file);
            }
        }
    }
}
