import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FizzBuzz {

    // Approach 1: Naive Approach
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    public static List<String> fizzBuzz1(int number) {
        // answer list
        List<String> answer = new ArrayList<>();
        //
        for (int num = 1; num <= number; num++) {
            //
            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);
            //
            if (divisibleBy3 && divisibleBy5) {
                // divides by both 3 and 5, add FizzBuzz
                answer.add("FizzBuzz");
            } else if (divisibleBy3) {
                // divides by 3, add Fizz
                answer.add("Fizz");
            } else if (divisibleBy5) {
                // divides by 5, add Buzz
                answer.add("Buzz");
            } else {
                // not divisible by 3 or 5, add the number
                answer.add(Integer.toString(num));
            }
        }
        return answer;
    }

    // Approach 2: String Concatenation
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    public static List<String> fizzBuzz2(int number) {
        // answer list
        List<String> answer = new ArrayList<>();
        //
        for (int num = 1; num <= number; num++) {
            //
            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);
            //
            String numAnsStr = "";
            //
            if (divisibleBy3) {
                // divides by 3, add Fizz
                numAnsStr += "Fizz";
            }
            //
            if (divisibleBy5) {
                // divides by 5, add Buzz
                numAnsStr += "Buzz";
            }
            //
            if (numAnsStr.equals("")) {
                // not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }
            // append the current answer str to the answer list
            answer.add(numAnsStr);
        }
        return answer;
    }


    // Approach 3: Hash it!
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    public static List<String> fizzBuzz3(int number) {
        // answer list
        List<String> answer = new ArrayList<>();
        // Hash map to store all fizzbuzz mappings.
        HashMap<Integer, String> fizzBuzzDict = new HashMap<>() {
                    {
                        put(3, "Fizz");
                        put(5, "Buzz");
                    }
                };
        //
        for (int num = 1; num <= number; num++) {
            //
            String numAnsStr = "";
            //
            for (Integer key : fizzBuzzDict.keySet()) {
                // if the num is divisible by key, then add the corresponding string mapping to current numAnsStr
                if (num % key == 0) {
                    numAnsStr += fizzBuzzDict.get(key);
                }
            }
            //
            if (numAnsStr.equals("")) {
                // not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }
            // append the current answer str to the ans list
            answer.add(numAnsStr);
        }
        return answer;
    }

    // main method
    public static void main(String[] args) {
        System.out.println();
        System.out.println(fizzBuzz1(25));
        System.out.println();
        System.out.println(fizzBuzz2(25));
        System.out.println();
        System.out.println(fizzBuzz3(25));
        System.out.println();
    }

}
