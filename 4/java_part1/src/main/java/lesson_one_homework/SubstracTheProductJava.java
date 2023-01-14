package lesson_one_homework;

public class SubstracTheProductJava {
    public int substracProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            prod = prod * digit; // prod *= digit;
            sum = sum * digit; // sum *= digit;
            n = n / 10; // n /= 10
        }
        return prod - sum;
    }

}
