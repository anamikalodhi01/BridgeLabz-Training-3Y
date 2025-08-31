public class RemoveCharacter {
    public static String remove(String str, char c) {
        String result = "";
        for (char ch : str.toCharArray()) {
            if (ch != c) result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Modified: " + remove("Hello World", 'l'));
    }
}
