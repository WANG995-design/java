package Branching_statement.switch_practice;

import java.util.Scanner;
// enum 枚举
public class switch_Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input){
            case 1-> System.out.println("1");
            default -> System.out.println("错误，请重新启动程序");
        }

    }
}
