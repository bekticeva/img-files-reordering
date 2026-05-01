import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String folder_path = "C:\\Users\\User\\Documents\\usb backup\\test";
        String output_folder_path = "C:\\Users\\User\\Documents\\usb backup\\test1";
        ImageScanner sc = new ImageScanner(folder_path);
        ImageCompare cmp = new ImageCompare();
        Hasher hasher = new Hasher();
        GroupOutput output = new GroupOutput(output_folder_path);

        ArrayList<File> images = new ArrayList<>(sc.scan());
        ArrayList<Image> hashed_images = new ArrayList<>();
        ArrayList<Group> groups = new ArrayList<>();


        int group_id = 1;


        for (File img : images) {
            Mat f = Imgcodecs.imread(img.getAbsolutePath());

            if(f.empty()){
                System.out.println("failed: " + img.getName());
            }
            else{
                String hash = hasher.hash(f);
                Image p = new Image(img,hash);
                hashed_images.add(p);
//                System.out.println("success: " + img.getName() + " -> " + hash);
            }
        }

        for (Image img : hashed_images) {
            boolean added = false;

            for (Group g : groups){
                Image first = g.getImages().get(0);

                int d = cmp.compare(img.getHash(), first.getHash());
                if(d <= 1000){
                    g.addImage(img);
                    added = true;
                    break;
                }
            }
            if(!added){
                Group n_group = new Group("group_"+ group_id++);
                n_group.addImage(img);
                groups.add(n_group);

            }
        }

        for (Group g : groups) {
            try {
                output.export(g);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}