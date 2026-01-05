package Branching_statement.for_practice;

public class For_practice {
    public static void main(String[] args) {
        /* 99 乘法表  */
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i ; j++) {
             /*   System.out.print("  " +j+"*"+i);*/
                // 修改点1：加上了 "=" 和 计算结果 (i*j)
                // 修改点2：把前面的空格改成了后面的 \t (制表符)，对齐更漂亮
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}