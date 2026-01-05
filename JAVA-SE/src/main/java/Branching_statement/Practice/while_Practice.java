package Branching_statement.Practice;

public class while_Practice {
    public static void main(String[] args) {
            /*
            * 打印十行五列的矩形*/


     /*   for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
*/
        int i  = 0;

/*        while ( i < 10){
            int j = 0;
            System.out.println();

            while (j<5){
                System.out.print("*");
                j++;
            }
            i++;
        }*/

        do{
            i++;
            int j = 0;
            System.out.println();
            do{
                System.out.print("*");
                j++;
            }
            while (j < 5);
        }
        while (i<10);
    }
}
