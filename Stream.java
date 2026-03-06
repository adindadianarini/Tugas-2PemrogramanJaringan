import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Stream {
     public static void main(String[] args){
        try {
            OutputStream os = new FileOutputStream("praktek1.txt");
            Scanner s = new Scanner("System.in");
            System.out.println("Masukkan kalimat =");
            String data = s.nextLine();
            os.write(data.getBytes());
            os.flush();
            os.close();
            System.out.println("pengiriman data berhasil");
        }catch (Exception e) {
            System.err.println("Pengiriman data tidak berhasil");
        }

        }
     }

