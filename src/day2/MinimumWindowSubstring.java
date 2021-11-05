package day2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), count + 1);
        }

        int requredSize = map.size();

        int left = 0,  right = 0;

        int formed = 0;

        HashMap<Character, Integer> windowCount = new HashMap<>();
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            int count = windowCount.getOrDefault(c, 0);
            windowCount.put(c, count + 1);

            if (map.containsKey(c) && windowCount.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == requredSize) {
                c = s.charAt(left);
                if(ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowCount.put(c, windowCount.get(c) - 1);
                if (map.containsKey(c) && windowCount.get(c).intValue() < map.get(c).intValue()) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return ans[0] == -1? "" : s.substring(ans[1], ans[2] + 1);
    }


    public String minWindow2(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), count + 1);
        }

        int requredSize = map.size();
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                filteredS.add(new Pair<>(i, c));
            }
        }


        int left = 0,  right = 0;

        int formed = 0;

        HashMap<Character, Integer> windowCount = new HashMap<>();
        int[] ans = {-1, 0, 0};

        while (right < filteredS.size()) {
            char c = filteredS.get(right).getValue();
            int count = windowCount.getOrDefault(c, 0);
            windowCount.put(c, count + 1);

            if (map.containsKey(c) && windowCount.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == requredSize) {
                c = filteredS.get(left).getValue();
                int end = filteredS.get(right).getKey();
                int start = filteredS.get(left).getKey();
                if(ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }
                windowCount.put(c, windowCount.get(c) - 1);
                if (map.containsKey(c) && windowCount.get(c).intValue() < map.get(c).intValue()) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return ans[0] == -1? "" : s.substring(ans[1], ans[2] + 1);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring c = new MinimumWindowSubstring();
        c.minWindow(s, t);

    }
}
