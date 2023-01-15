package lesson_one_homework;

public class Task {
    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        String text = "abcd fgc";
        ans.append(reverse(text.substring(0, 4)));
        System.out.println(ans);
    }
    private static String reverse(String text) {
        StringBuilder reversed = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed.append(text.charAt(i));
        }
        return reversed.toString();
    }
}
