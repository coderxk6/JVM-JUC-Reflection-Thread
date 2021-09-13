package Demo;

import java.util.Arrays;
//冒泡排序

public class ArrayMaoPao {
    public static void main(String[] args) {
        int[] a = {1,5,2,66,22,88,100};
        int[] sort = sort(a);//调用自己写的排序方法
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] array){
        int tmp=0;//临时变量
        //外层循环，判断要走多少次
        for (int i=0;i<array.length-1;i++){
            boolean flag = false;//优化：通过flag标识位减少不必要的比较
            //内层循环，判断两个数大小，如果后一个数小于前一个数，则交换位置
            for (int j=0;j<array.length-1-i;j++){
                if (array[j+1]<array[j]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = true;
                }
            }
            if (flag==false){
                break;
            }
        }
        return array;
    }
}
