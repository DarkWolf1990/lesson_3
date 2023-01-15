package lesson_one_homework;

// You are given two strings word1 and word2.
// Merge the strings by adding letters in alternating order, starting with word1.
// if a string is longer than the other, append the additional letters onto the end
// of the merged string.
// Return thе merged string.
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        // классы пишутся всегда с большой буквы
        // Здесь вызывается у класса Math метод max
        int maxLength = Math.max(word1.length(), word2.length());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                ans.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                ans.append(word2.charAt(i));
            }
        }
        return ans.toString();
    }
}

