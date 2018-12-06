import java.io.*;
import java.util.*;

class Solution {
    public String getCommonLetters(ArrayList<String> list){
        Collections.sort(list);
        String answer = "";

        for(int i = 0; i + 1 < list.size(); i++){
            String s1 = list.get(i);
            String s2 = list.get(i+1);
            int diffCount = 0, nonDiffIndex = 0;

            for(int j = 0; j < s1.length(); j++){
                if((s1.charAt(j) ^ s2.charAt(j)) != 0){
                    diffCount += 1;
                    nonDiffIndex = j;
                }
            }

            if(diffCount == 1){
                if(nonDiffIndex > 0){
                    answer = answer + s1.substring(0, nonDiffIndex);
                }
                
                if(nonDiffIndex < s1.length() - 1){
                    answer = answer + s1.substring(nonDiffIndex + 1, s1.length());    
                }

                break;
            }
        }
        
        return answer;
    }
    
    public int getCheckSum(ArrayList<String> list){
        int countTwiceRepeat = 0, countThreeRepeat = 0;
        boolean isTwiceRepeat = false, isThreeRepeat = false;
        HashMap<String, Integer> map = new HashMap<String, Integer>(list.get(0).length());
        
        for(int i = 0; i < list.size(); i++){
            String boxID = list.get(i);
            map.clear();
            initHashMap(map, boxID);

            // Check if current string has any 2 or 3 repeats
            if(map.containsValue(2)){
                countTwiceRepeat += 1;
            }

            if(map.containsValue(3)){
                countThreeRepeat += 1;
            }
        }

        return countTwiceRepeat * countThreeRepeat;    
    }

    private void initHashMap(HashMap<String, Integer> map, String boxID){
        for(int i = 0; i < boxID.length(); i++){
            String key = boxID.valueOf(boxID.charAt(i));
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }
            else {
                map.put(key, 1);
            }
        }
    }
}