import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

    public class WriteTextToFile {

        public static void main(String[] args) {
            if (args.length != 1) {
                System.out.println("Usage: java WriteTextToFile <nama_file_tujuan>");
                System.exit(1);
            }

            String outputFile = args[0];
            BufferedReader consoleReader = null;
            BufferedWriter fileWriter = null;

            try {
                // Baca dari stdin (console)
                consoleReader = new BufferedReader(new InputStreamReader(System.in));
                fileWriter = new BufferedWriter(new FileWriter(outputFile));

                System.out.println("Masukkan teks (akhiri dengan EOF):");
                String line;
                while ((line = consoleReader.readLine()) != null) {
                    fileWriter.write(line);
                    fileWriter.newLine(); // tambahkan newline
                }

                fileWriter.flush();
                System.out.println("Teks berhasil ditulis ke file: " + outputFile);

            } catch (IOException ioe) {
                System.err.println("I/O Error: " + ioe.getMessage());
                System.exit(1);

            } finally {

                try {
                    if (consoleReader != null) consoleReader.close();
                } catch (IOException e) {

                }
                try {
                    if (fileWriter != null) fileWriter.close();
                } catch (IOException e) {
                    System.err.println("Gagal menutup file writer: " + e.getMessage());
                }
            }
        }
    }
