package day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class LetterCombinationsofaPhoneNumber {
    static List<String> combinations = new ArrayList<>();

    static String phoneDigits;
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return combinations;
        }

        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    static void backtrack(int index, StringBuilder path) {
        if(path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return;
        }

        String possibleLetters = getPossibleLetters(phoneDigits.charAt(index));
        for(char letter: possibleLetters.toCharArray()) {
            path.append(letter);
            backtrack(index + 1, path);
            path.deleteCharAt(path.length() -1 );
        }
    }

    static String getPossibleLetters(Character key) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return map.get(key);
    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinationsofaPhoneNumber.letterCombinations(digits);
    }
}
