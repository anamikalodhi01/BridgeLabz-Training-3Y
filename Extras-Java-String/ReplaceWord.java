public class ReplaceWord {
    public static String replaceWord(String sentence, String word, String replacement) {
        String[] words = sentence.split(" ");
        String result = "";
        for (String w : words) {
            if (w.equals(word))
                result += replacement + " ";
            else
                result += w + " ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        String s = "Java is fun and Java is powerful";
        System.out.println("Modified: " + replaceWord(s, "Java", "Python"));
    }
}
