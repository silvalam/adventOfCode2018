import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String line = null;
        ArrayList<String> list = new ArrayList<String>();

        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        Solution sol = new Solution();

        System.out.println("Advent Day 2a: " + sol.getCheckSum(list));
        System.out.println("Advent Day 2b: " + sol.getCommonLetters(list));
  }
}