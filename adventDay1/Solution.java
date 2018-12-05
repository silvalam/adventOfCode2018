import java.io.*;
import java.util.*;

class Solution {
    public int getFrequencySum(ArrayList<Integer> freqList){
        int sum = 0;
        for(int i = 0; i < freqList.size(); i++){
            sum += freqList.get(i);
        }

        return sum;    
    }

    public int getFirstDuplicateFrequency(ArrayList<Integer> freqList){
        HashSet<Integer> map = new HashSet<Integer>();
        int sum = 0, answer = 0;

        map.add(sum);

        for(int i = 0; i <= freqList.size(); i++){
            if(i == freqList.size()){
                i = -1;
            }
            else {
                sum += freqList.get(i);

                if(map.contains(sum)){
                    answer = sum;
                    break; 
                }
                else{
                    map.add(sum);
                    continue;
                }
            }
        }

        return answer;
    }
}