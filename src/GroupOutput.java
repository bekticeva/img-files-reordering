import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class GroupOutput {
    private String output_path;
    public GroupOutput(String output_path) {
        this.output_path = output_path;
    }
    public void export (Group g) throws IOException {
        File dir = new File(output_path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        for (Image i : g.getImages()) {
            File source = i.getFile();
            String new_filename = g.getName() +"_"+ source.getName();
            File destination = new File(dir,new_filename);

            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
