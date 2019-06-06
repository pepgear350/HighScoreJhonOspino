import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {


        JButton jButton = new JButton();
        JFileChooser jFileChooser = new JFileChooser();
        Path currentRelativePath = Paths.get("");
        String pathAbsolute = currentRelativePath.toAbsolutePath().toString();
        jFileChooser.setCurrentDirectory(new File(pathAbsolute));
        jFileChooser.setDialogTitle("Seleccione su archivo.txt");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        jFileChooser.setFileFilter(filter);

        if (jFileChooser.showOpenDialog(jButton) == JFileChooser.APPROVE_OPTION) {
            String path = jFileChooser.getSelectedFile().getAbsolutePath();
            new Input(new BufferedReader(new FileReader(path)));

        }
    }



}
