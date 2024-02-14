import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\mv025187\\IdeaProjects\\newproject\\inputdata.txt");
            Scanner myScanner = new Scanner(myObj);


            //create out file
            File outFile = new File("outputdata.txt");
            if (outFile.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            String output = "";
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine() ;
                if(isPrime(Integer.parseInt(data))){
                    output = output + data + "\n";

                }
            }
            System.out.println(output);
            FileWriter myWriter = new FileWriter("outputdata.txt");
            myWriter.write(output);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

            myScanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
