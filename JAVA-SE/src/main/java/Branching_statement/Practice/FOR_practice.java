package Branching_statement.Practice;

public class FOR_practice {
    public static void main(String[] args) {
        /* 打印1-100之间中13的倍数使用 continue关键字 使用 for*/
        for (int i = 1; i < 100; i++) {
            if (i%13 !=0){
                continue;
            }
            System.out.println(i + " 这个数是13的倍数");
        }
    }
}
