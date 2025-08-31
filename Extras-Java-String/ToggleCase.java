public class ToggleCase {
    public static String toggle(String str) {
        String result = "";
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch))
                result += Character.toLowerCase(ch);
            else if (Character.isLowerCase(ch))
                result += Character.toUpperCase(ch);
            else
                result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Toggled: " + toggle("Hello World"));
    }
}
