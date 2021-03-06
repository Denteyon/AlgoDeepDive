import java.util.*;

public class LetterCombinations {
    
        static Map<String, String> phone = new HashMap<String, String>();

        static {
            phone.put("2", "abc");
            phone.put("3", "def");
            phone.put("4", "ghi");
            phone.put("5", "jkl");
            phone.put("6", "mno");
            phone.put("7", "pqrs");
            phone.put("8", "tuv");
            phone.put("9", "wxyz");
        }
        
        

        static List<String> output = new ArrayList<String>();

        public static void backtrack(String combination, String next_digits) {
            // if there is no more digits to check
            if (next_digits.length() == 0) {
                // the combination is done
                output.add(combination);
            }
            // if there are still digits to check
            else {
                // iterate over all letters which map
                // the next available digit
                String digit = next_digits.substring(0, 1);
                String letters = phone.get(digit);
//                for (int i = 0; i < letters.length(); i++) {
//                    String letter = letters.substring(i, i + 1);
//                    // append the current letter to the combination
//                    // and proceed to the next digits
//                    backtrack(combination + letter, next_digits.substring(1));
//                }
                for (char c: letters.toCharArray()) {
                    backtrack(combination + c, next_digits.substring(1));
                }
            }
        }

        public static List<String> letterCombinations(String digits) {
            if (digits.length() != 0)
                backtrack("", digits);
            return output;
        }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }

}
