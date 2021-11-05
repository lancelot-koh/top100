package day1;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> map = new HashMap();
        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList());
            }
            map.get(s).add(strs[i]);
        }
        return null;
//        return new ArrayList<>(map.values());
    }
}
