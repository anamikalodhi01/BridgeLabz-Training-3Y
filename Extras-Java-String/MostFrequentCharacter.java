public class MostFrequentCharacter {
    public static char mostFrequent(String str) {
        int[] freq = new int[256];
        for (char ch : str.toCharArray()) freq[ch]++;
        int max = 0; char result = ' ';
        for (char ch : str.toCharArray()) {
            if (freq[ch] > max) {
                max = freq[ch];
                result = ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Most Frequent: " + mostFrequent("success"));
    }
}
