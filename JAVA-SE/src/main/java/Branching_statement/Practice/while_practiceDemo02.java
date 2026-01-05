package Branching_statement.Practice;

import java.util.Scanner;

public class while_practiceDemo02 {
    public static void main(String[] args) {

        boolean select = true;
        while(select){
            System.out.println("\t");
            System.out.print("1.增加\t");
            System.out.print("2.删除\t");
            System.out.print("3.修改\t");
            System.out.print("4.查询\t");
            System.out.print("5.退出\t");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()){
                case 1 : System.out.println("增加成功"); break;
                case 2 : System.out.println("删除成功"); break;
                case 3 : System.out.println("修改成功"); break;
                case 4 : System.out.println("查询成功"); break;
                case 5 : System.out.println("退出成功"); select = false; break;
                default : System.out.println("请输入正确的数字进行查询");
            }
        }
    }
}
