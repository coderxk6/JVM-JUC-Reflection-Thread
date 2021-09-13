package Demo;

import java.util.Arrays;

public class DemoArrayList {

    public static void main(String[] args) {
        int [] a =new int[]{1,2,6,6,6,3,10};
        int [] b = Arrays.copyOf(a,7);
//        for(int element:a){
//            System.out.println(element);
//        }
        int [][] array = {{1,2},{3,3},{5,5},{10,10},{8,7}};
        //打印二维数组array所有元素
        for(int[] row:array){
            for (int value:row){
                System.out.println(value);
            }
        }
        System.out.println(Arrays.deepToString(array));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(a));
        printArray(array[2]);
    }
    //打印数组元素
    public static void printArray(int[] arrays){
        for (int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+" ");
        }
    }
}
