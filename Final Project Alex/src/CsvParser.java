import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvParser {
   static String [][] hardware;

    public static String[][] parser() {
        String fileName= "Inventory.csv";
        File file= new File(fileName);

        // this gives you a 2-dimensional array of strings
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);
            Scanner inputCount = new Scanner(file);
            int count = 0;
            while (inputCount.hasNextLine()) {
                count++;
                inputCount.nextLine();
            }
           hardware = new String [count][2];
            for (int i = 0; i < hardware.length; i++) {
                for (int j = 0; j < hardware[i].length; j++) {
                    if (!(inputStream.hasNextLine())) {
                        break;
                    }
                    String input = inputStream.next();
                    hardware[i][j] = input;
                }
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return hardware;
    }

}
