package Branching_statement.while_practice;

import java.util.Scanner;

public class do_while_practice {
    public static void main(String[] args) {
        /*
        *  1. do_while 简易版曾删改查
        *  2 界面如下：
        *    1 .增加， 2 .删除  3.查询 。 4 修改。 5.退出
        *  3.选择对应编号执行响应的操作
        * */

        int index = 0;
        do{
            System.out.println("*****这里是信息数据管理系统*****");
            System.out.println("1.增加");
            System.out.println("2.修改");
            System.out.println("3.查询");
            System.out.println("4.删除");
            System.out.println("4.退出");
            System.out.println("请输入你要选择的操作");
            Scanner sc = new Scanner(System.in);
            index = sc.nextInt();
            switch(index){
                case 1 -> add();
                case 2 -> delect();
                case 3 -> change();
                case 4 -> type();
            }
        }
                while(index !=  5 );
    }
    public static void  add(){
        System.out.println("zengjia ");
    }
    public static void  delect(){
        System.out.println("de");
    }
    public static void  change(){
        System.out.println("change");
    }
    public static void  type(){
        System.out.println("删除");
    }


}
