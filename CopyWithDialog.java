import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CopyWithDialog {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();

        int input = chooser.showOpenDialog(null);
        if (input != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File inputFile = chooser.getSelectedFile();

        int output = chooser.showSaveDialog(null);
        if (output != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File outputFile = chooser.getSelectedFile();

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {

            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(outputFile);

            int data;

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            fos.close();

            JOptionPane.showMessageDialog(null,
                    "Input : " + inputFile.getAbsolutePath() +
                    "\nOutput : " + outputFile.getAbsolutePath());

            System.out.println("Copy selesai. File tersimpan di: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyalin file");
        }
    }
}
