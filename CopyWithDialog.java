import javax.swing.*;
import java.io.*;

public class CopyWithDialog {
    public static void main(String[] args) {
        // Memilih file input
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Pilih file yang akan di-copy");
        int hasil = chooser.showOpenDialog(null);
        if (hasil != JFileChooser.APPROVE_OPTION) {
            System.out.println("Tidak ada file yang dipilih. Program selesai.");
            return;
        }

        File inputFile = chooser.getSelectedFile();

        // Memilih lokasi file output (Save dialog)
        chooser.setDialogTitle("Pilih lokasi dan nama file hasil copy");
        hasil = chooser.showSaveDialog(null);
        if (hasil != JFileChooser.APPROVE_OPTION) {
            System.out.println("Tidak ada lokasi output yang dipilih. Program selesai.");
            return;
        }

        File outputFile = chooser.getSelectedFile();

        // Tampilkan nama file input & output menggunakan dialog (sesuai permintaan)
        JOptionPane.showMessageDialog(null,
                "Input : " + inputFile.getAbsolutePath() + "\nOutput: " + outputFile.getAbsolutePath(),
                "Informasi File", JOptionPane.INFORMATION_MESSAGE);

        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream(inputFile);
            output = new FileOutputStream(outputFile);

            int data = input.read(); // baca byte per byte
            while (data != -1) {
                output.write(data);
                data = input.read();
            }

            // Pastikan semua data tertulis
            output.flush();
            System.out.println("Copy selesai. File tersimpan di: " + outputFile.getAbsolutePath());
        } catch (IOException ioe) {
            System.err.println("I/O error - " + ioe);
        } finally {
            try {
                if (input != null) input.close();
            } catch (IOException e) { /* abaikan */ }
            try {
                if (output != null) output.close();
            } catch (IOException e) { /* abaikan */ }
        }
    }
}
