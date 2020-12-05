import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvoutParser {
    static String [][] myhardware;

    public static String[][] parser() {
        String fileName= "Own.csv";
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
            myhardware = new String [count][2];
            for (int i = 0; i < myhardware.length; i++) {
                for (int j = 0; j < myhardware[i].length; j++) {
                    if (!(inputStream.hasNextLine())) {
                        break;
                    }
                    String input = inputStream.next();
                    myhardware[i][j] = input;
                }
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return myhardware;
    }

}