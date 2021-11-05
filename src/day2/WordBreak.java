package day2;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visted = new boolean[s.length()];

        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
            if(visted[start]) {
                continue;
            }
            for(int end = start + 1; end < s.length(); end++) {
                if(wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if (end == s.length()) {
                        return true;
                    }
                }
            }
            visted[start] = true;
        }
        return false;
    }
}
