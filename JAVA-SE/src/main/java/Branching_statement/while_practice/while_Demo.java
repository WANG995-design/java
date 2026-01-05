package Branching_statement.while_practice;

public class while_Demo {
    public static void main(String[] args) {
        int i = 0;
        while (i < 3) {
            i = 0;
            while (i < 3) {
                System.out.print("*");
                i++;
            }
            System.out.println();
            System.out.print("*");
            i++;
        }
        System.out.println();
    }
}
