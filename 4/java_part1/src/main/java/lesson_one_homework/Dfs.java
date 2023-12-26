package lesson_one_homework;

public class Dfs {
//    public static void main(String[] args) {
//        dfs(1, 7,2,1, "");
//    }

    // dfs - обход в глубину
    private static void dfs(int src, int target, int mult, int add, String path) {
        if (src == target) {
            System.out.println(path);
            return;
        }
        if (src > target) {
            return;
        }
        dfs(src * mult, target, mult, add, path + "k1");
        dfs(src + add, target, mult, add, path + "k2");

    }
}
