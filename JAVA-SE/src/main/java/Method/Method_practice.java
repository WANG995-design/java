package Method;

public class Method_practice {
    public static void main(String[] args) {

        int mun = add(10 , 20);
        System.out.println(mun);

         MathUtils.printHello();
    }
    public static int add(int x , int y ){
        int z = x + y;
        System.out.println(z);
        return  z;
    }
    /*
    * 优先级排行榜 (由高到低)
精准匹配 (Exact Match)

基本数据类型自动提升 (Widening Primitive Conversion)

自动装箱/拆箱 (Auto-boxing/Unboxing)

可变参数 (Varargs)
*
*
*
* 什么时候用递归？

处理树形结构（文件夹、JSON解析、XML解析）。

算法本身就是递归定义的（归并排序、二叉树遍历）。

代码的可读性远重要于微小的性能损耗时。

什么时候用循环？

简单的线性处理（遍历一个数组、累加）。

极度在乎性能和内存空间。

递归层数可能极深，有爆栈风险时。
*
*
* */


}
