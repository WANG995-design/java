package Branching_statement.if_practice;

import java.util.Scanner;

public class if_Demo02 {
    public static void main(String[] args) {
        /*
        *  需求： 某电信公司电话计费规则如下：
        *  1。 前三分钟2角
        *  2. 之后一分钟 1.5 角
        *  3. 不够一分钟按一分钟
        *  4. 求x秒需要多少钱
        * */
        // 输入使用了多少秒
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入电话时间");
        double min = sc.nextDouble();
        if ( min<=3 && 0< min){
            System.out.println("你花费的时间为");
            System.out.println(0.2*min);
        } else if ( min <= 0) {
            System.out.println("请重新输入，时间错误");
        } else {
            System.out.println("你花费的时间为");
            System.out.println(0.2*3+0.15*(min-3));
        }
    }
}
