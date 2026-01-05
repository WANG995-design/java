package Branching_statement.Practice;

public class nine_nine {
    public static void main(String[] args) {
        for (int i = 1; i < 10 ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+j*i+"\t" );
            }
            System.out.println();
        }
    }
}
