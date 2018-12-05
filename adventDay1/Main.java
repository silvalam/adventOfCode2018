import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String line = null;
        ArrayList<Integer> list = new ArrayList<Integer>();

        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                list.add(Integer.valueOf(line));
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

        System.out.println("Advent Day 1a: " + sol.getFrequencySum(list));
        System.out.println("Advent Day 1b: " + sol.getFirstDuplicateFrequency(list));
  }
}