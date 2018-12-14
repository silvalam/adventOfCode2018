import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution {
    private int collisionCount = 0;

    public int[] sliceIt(ArrayList<String> list){
        int claimNum = 0, hitClaimNum = 0, fromLeft = 0, fromTop = 0, width = 0, height = 0;
        int[] answer = new int[2]; // index 0 = answer part1, index 1 = answer part 2
        int[][] arr = new int[1000][1000]; // board to mark claims
        boolean[] collisions = new boolean[list.size()+1]; // track collisions, entries only on indices 1-1317

        for(int i = 0; i < list.size(); i++){
            // Parse input
            String line = list.get(i);

            claimNum = getClaimNum(line);
            fromLeft = getFromLeft(line);
            fromTop = getFromTop(line);
            width = getWidth(line);
            height = getHeight(line);

            updateBoard(arr, collisions, claimNum, fromLeft, fromTop, width, height);
        }

        answer = getAnswer(collisions);

        return answer;
    }

    private int[] getAnswer(boolean[] collisions){
        int[] ret = new int[2];

        ret[0] = collisionCount;

        for(int i = 1; i < collisions.length; i++){
            if(collisions[i] == false){
                ret[1] = i;
            }
        }

        return ret;
    }

    private void updateBoard(int[][] arr, boolean[] collisions, int claimNum, int fromLeft, int fromTop, int width, int height){
        for(int x = fromLeft; x < fromLeft+width; x++){
            for(int y = fromTop; y < fromTop+height; y++){
                if(arr[x][y] == 0){ // no existing claims
                    arr[x][y] = claimNum;
                }
                else if(arr[x][y] == -1){ // 2+ existing claims
                    if(collisions[claimNum] == false){
                        collisions[claimNum] = true;
                    }
                }
                else if(arr[x][y] > 0){ // 1 existing claim
                    if(collisions[arr[x][y]] == false){
                        collisions[arr[x][y]] = true;
                    }
                    collisions[claimNum] = true;
                    collisionCount += 1;
                    arr[x][y] = -1;
                }
            }
        }
    }

    private int getClaimNum(String line){
        Pattern pattern = Pattern.compile("#(\\d+)");
        Matcher matcher = pattern.matcher(line);

        if(!matcher.find()){
            return -1;
        }

        return Integer.valueOf(matcher.group(1));
    }
    private int getFromLeft(String line){
        Pattern pattern = Pattern.compile("@\\s(\\d+)");
        Matcher matcher = pattern.matcher(line);
        
        if(!matcher.find()){
            return -1;
        }

        return Integer.valueOf(matcher.group(1));
    }

    private int getFromTop(String line){
        Pattern pattern = Pattern.compile(",(\\d+)");
        Matcher matcher = pattern.matcher(line);
        
        if(!matcher.find()){
            return -1;
        }

        return Integer.valueOf(matcher.group(1));
    }
    private int getWidth(String line){
        Pattern pattern = Pattern.compile(":\\s(\\d+)");
        Matcher matcher = pattern.matcher(line);

        if(!matcher.find()){
            return -1;
        }

        return Integer.valueOf(matcher.group(1));
    }
    private int getHeight(String line){
        Pattern pattern = Pattern.compile("x(\\d+)");
        Matcher matcher = pattern.matcher(line);

        if(!matcher.find()){
            return -1;
        }

        return Integer.valueOf(matcher.group(1));
    }            
}