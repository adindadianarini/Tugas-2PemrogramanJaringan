import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class VowelCounter {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();

        int result = chooser.showOpenDialog(null);

        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = chooser.getSelectedFile();

        int a = 0, i = 0, u = 0, e = 0, o = 0;

        try {

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), "UTF-8"));

            int ch;

            while ((ch = br.read()) != -1) {

                char c = Character.toLowerCase((char) ch);

                switch (c) {
                    case 'a': a++; break;
                    case 'i': i++; break;
                    case 'u': u++; break;
                    case 'e': e++; break;
                    case 'o': o++; break;
                }
            }

            br.close();

            JOptionPane.showMessageDialog(null,
                    "File: " + file.getName() +
                    "\nJumlah huruf a: " + a +
                    "\ni: " + i +
                    "\nu: " + u +
                    "\ne: " + e +
                    "\no: " + o);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error membaca file");
        }
    }
}
