package lesson_one_homework;
// Given two binaru string a and b, return their sum as a binary string.
// Example 1:
// Input: a = "11". b = "1"
// Output: "100"
public class AddBinary{
    public static void main(String[] args) {

    }
    public String addBinary(String a, String b){
    // хочу чтобы строка "a" была наибольшей
    if (a.length() < b.length()){
        return addBinary(b, a);
    }
    int carry = 0;
    StringBuilder res = new StringBuilder();

    // i --   i -= 1      i = i - 1
        int j = b.length() - 1;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(1) == '1') {
                carry ++;
            }
            if (j >= 0 && b.charAt(j) == '1'){
                carry++;
            }
            res.append(carry % 2);
            carry /= 2;
            j--;

        }
        if (carry == 1){
            res.append(1);
        }
        return res.reverse().toString();
}
}
