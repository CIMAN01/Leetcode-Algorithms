/*
Improved version of palindrome using a faster algorithm.
*/

public class Palindrome {

    // a method that checks whether a string is a valid Palindrome or not
    public static boolean isPalindrome(String str) {
        // remove spaces from string and change to lower case
        str = str.replaceAll("\\s","").toLowerCase();
        // create starting and ending indexes
        int left = 0;
        int right = str.length()-1;
        // check the string for similar characters
        // (start at each end and meet in the middle while string has not been tested)
        while ((str.charAt(left) == str.charAt(right)) && (left < right)) {
            left++; // traverse right
            right--; // traverse left
        }
        // return false if string already tested
        if (left < right) {
            return false;
        }
        return true;
    }


    /* solution below takes O(n) time complexity and O(1) constant space complexity */

    // a method take checks if an integer input is a valid Palindrome or not
    public static boolean isPalindrome2(int num) {
        // if number is negative or last digit of number is equal to zero but the number itself is not zero (an integer ending with zero cannot be a palindrome by default)
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }
        // below is the input number split in half and reverted
        int revertedNum = 0;
        // while there are more digits to process
        while (num > revertedNum) { // i.e. 12321 -> 12|321 becomes 12|123
//            int pop = num % 10; // grabs the last digit in num
//            revertedNum = revertedNum * 10 + pop;
            // reverse each digit in num from right to middle and append to revertedNum variable
            revertedNum = revertedNum * 10 + num % 10;
            // remove the last digit in num
            num = num / 10;
        }
        //  even number of digits || odd number of digits (last digit gets dropped)
        return num == revertedNum || num == revertedNum/10;
    }

    public static void main(String[] args) {
        // create a palindrome string
        String name = "Able was I ere I saw Elba";
        System.out.println();
        // print string and invoke the method that will return a true or false
        System.out.println("is the string: '" + name + "' a Palindrome? " + isPalindrome(name)); // true
        System.out.println();
        // create a number
        int number = 12321;
        // print the number and invoke the method that will return a true or false
        System.out.println("is the number '" + number + "' a Palindrome? " + isPalindrome2(number)); // true
        System.out.println();
    }

}
