import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4}};
      /* int  rows= arr.length;
        int  cols=arr[0].length;
        System.out.println(rows);
        System.out.println(cols);

*/
    }

    public  static  ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int  rows=matrix.length;
        int  cols=matrix[0].length;
        if(matrix==null||rows<=0||cols<=0){
            return list;
        }
        int start=0;
        while (cols>start*2&&rows>start*2){
            list = PrintMatrixIn(matrix,cols,rows,start);
            ++start;
        }
        return  list;
    }

    public static  ArrayList<Integer>  PrintMatrixIn(int[][] matrix, int cols, int rows, int start) {
        ArrayList<Integer> list1 = new ArrayList<>();
        int endX = cols-1-start;
        int endY = rows-1-start;
        //从左往又打印一行
        for(int i = start;i<=endX;++i){
            int number = matrix[start][i];
            list1.add(number);
        }
        //从上往下打印一列
        if(start<endY){
            for(int i = start+1;i<=endY;++i){
                int number = matrix[i][endX];
                list1.add(number);
            }
        }
        //从右往左打印一行
        if(start<endX&&start<endY){
            for(int i = endX-1;i>=start;--i){
                int number = matrix[endY][i];
                list1.add(number);
            }
        }
        //从下往上打印
        if(start<endX&&start<endY-1){
            for(int i = endY-1;i>=start+1;--i){
                int number = matrix[i][start];
                list1.add(number);
            }
        }
        return list1;
    }
}
