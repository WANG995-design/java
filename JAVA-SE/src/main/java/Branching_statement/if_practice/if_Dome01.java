package Branching_statement.if_practice;

import java.util.Scanner;

public class if_Dome01 {
    public static void main(String[] args) {
        /*
        *  需求： 模拟门禁卡，用户输入密码，正确执行开门操作
        *  1. 拿到用户输入的密码
        *  2. 编写分支判断，判断密码是否正确
        *  3. 如果密码正确，执行开门操作
        *  4. 如果密码错误，提示用户密码错误
        * */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入密码");
        String input = sc.next();
        if (input.equals("123456")) {
            System.out.println("密码正确，开门");
        } else if (input.equals("#")){
            System.out.println("恭喜管理员登陆");
        }
        else {
            System.out.println("密码错误");
        }

        // if 语句的简写

    }
}
