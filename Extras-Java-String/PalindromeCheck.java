public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        return str.equals(reverse(str));
    }

    public static String reverse(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) rev += s.charAt(i);
        return rev;
    }

    public static void main(String[] args) {
        String word = "madam";
        System.out.println(word + " is Palindrome? " + isPalindrome(word));
    }
}
