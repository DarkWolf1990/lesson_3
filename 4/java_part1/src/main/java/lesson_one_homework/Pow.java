package lesson_one_homework;
// Реализовать функцию возведения числа "а" в степень "b" , a
// b принадлежит к Z.
// сводя количество выполняемых действий к минимуму.
// Пример 1: a = 3 , b = 2 , ответ 9

public class Pow {
    public static void main(String[] args) {
        pow(3, 3);
        System.out.println(pow(3,3));
        System.out.println(pow(2,-2));
        System.out.println(pow(3,2));
        System.out.println(pow(3, -2));
    }

    private static double pow(double base, int pow) {
        if (pow == 1) return base;
        if (pow == 0) return 1;
        if (pow < 0) return pow(1 / base, -pow);
        double sqrt = pow(base,pow/2);
        double res = sqrt * sqrt;
        if(pow % 2 == 1) {
            res *= base;
        }
        return  res;
    }
}


