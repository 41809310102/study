public class Demo {
    public static void main(String[] args) {

        int rows =50;
        int cows =50;
        int num = 62;

        Demo sb = new Demo();
        System.out.println(sb.movingCount(num, rows, cows));


    }

    int getNumber(int n){
        int res = 0;
        if(n>0){
            res = res+n%10;
            n=n/10;
        }
        return res;
    }

        public int movingCount(int threshold, int rows, int cols) {
            if(threshold<0||rows<=0||cols<=0) return  0;
            boolean[] visit = new boolean[rows*cols];
            for (int i=0;i<rows*cols;i++){
                visit[i] = false;}
            int count = movinggo(threshold, rows, cols, 0, 0, visit);
            return count;
        }


        public int movinggo(int threshold,int rows,int cols,int row,int col,boolean[] visit){
            int count = 0;
            if(check(threshold, rows, cols, row, col, visit)){
                visit[row*cols+col]=true;
                count= 1+movinggo(threshold, rows, cols, row+1, col, visit)
                        +movinggo(threshold, rows, cols, row, col-1, visit)
                        +movinggo(threshold, rows, cols, row-1, col, visit)
                        +movinggo(threshold, rows, cols, row, col+1, visit);
            }
            return count;
        }

        public boolean check(int threshold,int rows,int cols,int row,int col,boolean[] visit){
            if(row>=0&&row<rows&&col>=0&&col<cols&&(getNumber(row)+getNumber(col))<=threshold && !visit[row*cols+col]){
                return true;
            }
            return false;
        }
    }


