public class CountVowelsConsonants {
    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "Programming";
        int vowels = countVowels(s);
        int consonants = s.length() - vowels;
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
