import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ReadAndCountVowels <nama_file>");
            System.exit(1);
        }

        String inputFile = args[0];
        BufferedReader reader = null;

        // Counters untuk vokal
        int countA = 0;
        int countI = 0;
        int countU = 0;
        int countE = 0;
        int countO = 0;

        try {
            reader = new BufferedReader(new FileReader(inputFile));

            System.out.println("---- Isi File: " + inputFile + " ----");

            String line;
            while ((line = reader.readLine()) != null) {
                // Tampilkan isi file ke console (sesuai tugas)
                System.out.println(line);

                // Hitung vokal secara case-insensitive
                for (int i = 0; i < line.length(); i++) {
                    char c = Character.toLowerCase(line.charAt(i));
                    switch (c) {
                        case 'a': countA++; break;
                        case 'i': countI++; break;
                        case 'u': countU++; break;
                        case 'e': countE++; break;
                        case 'o': countO++; break;
                        default: break;
                    }
                }
            }

            System.out.println("---- Ringkasan Vokal ----");
            System.out.println("a : " + countA);
            System.out.println("i : " + countI);
            System.out.println("u : " + countU);
            System.out.println("e : " + countE);
            System.out.println("o : " + countO);

        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found: " + inputFile);
            System.exit(1);
        } catch (IOException ioe) {
            System.err.println("I/O Error: " + ioe.getMessage());
            System.exit(1);
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
            }
        }
    }
