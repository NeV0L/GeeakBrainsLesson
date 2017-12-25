import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ArrayExceprtion {
    public static void main(String[]args) {
        try {
            Scanner sc = new Scanner(new File("src/array.txt"));

            sc.useDelimiter(",\r\n");
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
