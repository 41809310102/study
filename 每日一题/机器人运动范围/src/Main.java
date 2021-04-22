public class Main {
    public static void main(String[] args) {

        int rows =6;
        int cows =6;


     Main sb = new Main();
        System.out.println(sb.movingCount(rows, cows));


    }


    public int movingCount( int rows, int cols) {
        if(rows<=0||cols<=0) return  0;
        boolean[] visit = new boolean[rows*cols];
        for (int i=0;i<rows*cols;i++){
            visit[i] = false;}
        int count = movinggo( rows, cols, 0, 0, visit);
        return count;
    }


    public int movinggo(int rows,int cols,int row,int col,boolean[] visit){
        int count = 0;
        if(check(rows, cols, row, col, visit)){
            visit[row*cols+col]=false;
            count= 1+movinggo( rows, cols, row+1, col, visit)
                    +movinggo(rows, cols, row, col+1, visit);
        }
        return count;
    }

    public boolean check(int rows,int cols,int row,int col,boolean[] visit){
        int threshold = 12;
        if(row>=0&&row<rows&&col>=0&&col<cols&&(col+row)<=threshold && !visit[row*cols+col]){
            return true;
        }
        return false;
    }
}


