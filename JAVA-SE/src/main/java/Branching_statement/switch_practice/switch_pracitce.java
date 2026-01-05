package Branching_statement.switch_practice;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class switch_pracitce {
    public static void main(String[] args) {
        /*
        *  使用分支语句来模拟温度计
        *  1. 如果大于36.5 小于 40 度 输出发烧
        *  2 . 大于40.00 则 请立即就医，避免发生意外
        *  3. 否则输出 温度正常， 注意多喝开水
        * */
        Scanner sc = new Scanner(System.in);
        Double input = sc.nextDouble();
        if (40 > input && input > 36.5) {
            System.out.println("发烧了");
        } else if (input >= 40 ){
            System.out.println("请立即就医，避免发生意外");
        } else {
            System.out.println("温度正常，注意多喝热水");
        }
        int a , b ;
        a =1;
        b =3;
        int num  =  a > b ? a : b;
        System.out.println(num);
    }
}
