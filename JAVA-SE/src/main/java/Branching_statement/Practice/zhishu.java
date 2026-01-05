package Branching_statement.Practice;

public class zhishu {
    public static void main(String[] args) {
        /*求取100  - 200 之间的质数*/

        for (int i = 100; i < 200 ; i++) {
            boolean  subject = true;
            for (int j = 2; j < i ; j++) {
                if (i % j == 0){
                 // 这个求的是非质数
                    subject = false ;
                }
            }
            if (subject){
                System.out.println(i +"shi zi shu ");
            }
        }


    }
}
