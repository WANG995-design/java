package Branching_statement.for_practice;

public class For_Demo01 {
    public static void main(String[] args) {
        /* 输出 1 - 6 之间的素数
        * */
        /* 这里面求的是100以内不是质数的 */
        int i = 1;
        int j = i;
        for (i = 1 ;i <=  100 ; i ++) {
            System.out.println();
              for (j=2; j < i; j++ ){
                  if (i%j==0){
                      System.out.println(i);
                      break;
                  }
              }
        }
        /* 求的是质数 */
        for (int k = 2; k < 100 ; k++) {
            boolean isPrime = true;

            for (int l = 2; l < k ; l++) {
                if (k%l == 0){
                    isPrime = false;
                    break;
                }
            }

            if (isPrime){
                System.out.println(k);
            }
        }
    }
    }

