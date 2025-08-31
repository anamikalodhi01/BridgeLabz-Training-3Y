public class CompareStrings {
    public static int compare(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return s1.charAt(i) - s2.charAt(i);
        }
        return s1.length() - s2.length();
    }

    public static void main(String[] args) {
        String a = "apple", b = "banana";
        int cmp = compare(a, b);
        if (cmp < 0) System.out.println(a + " comes before " + b);
        else if (cmp > 0) System.out.println(b + " comes before " + a);
        else System.out.println("Equal Strings");
    }
}
