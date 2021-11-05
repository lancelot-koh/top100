package day1;

import java.util.HashMap;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        // S = "abcdefder";
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                j = Math.max(map.get(c), j);
            }
            max = Math.max(max, i - j + 1);
            map.put(c,i + 1);
        }

        return max;

    }
}
