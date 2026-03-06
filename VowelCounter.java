import javax.swing.*;
import java.io.*;

public class VowelCounter {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Pilih file teks untuk dihitung vokalnya");
        int res = chooser.showOpenDialog(null);
        if (res != JFileChooser.APPROVE_OPTION) {
            System.out.println("Tidak ada file dipilih. Selesai.");
            return;
        }

        File file = chooser.getSelectedFile();
        BufferedReader br = null;

        int countA = 0, countI = 0, countU = 0, countE = 0, countO = 0;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            int ch;
            while ((ch = br.read()) != -1) {
                char c = Character.toLowerCase((char) ch);
                switch (c) {
                    case 'a': countA++; break;
                    case 'i': countI++; break;
                    case 'u': countU++; break;
                    case 'e': countE++; break;
                    case 'o': countO++; break;
                    default: break;
                }
            }

            String result = String.format("File: %s%nJumlah huruf a: %d%ni: %d%n u: %d%ne: %d%no: %d",
                    file.getName(), countA, countI, countU, countE, countO);
            JOptionPane.showMessageDialog(null, result, "Hasil Penghitungan Vokal", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(result);
        } catch (IOException ioe) {
            System.err.println("I/O error - " + ioe);
        } finally {
            try { if (br != null) br.close(); } catch (IOException e) { /* abaikan */ }
        }
    }
}
