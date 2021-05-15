import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        while(jin.hasNext()) {
            int row = jin.nextInt();
            int col = jin.nextInt();
            int[][] maze = new int[row][col];
            for(int i = 0; i < row; i++)
                for(int j = 0; j < col; j++)
                    maze[i][j] = jin.nextInt();
            check(maze, 0, 0);//预先探测迷宫一遍，将走不通的路置1
            System.out.println(mazePath(maze, 0, 0));//正式走迷宫
        }
    }
    public static int check(int[][] maze, int x, int y) {
        //如果是右下角的出口
        if(x == maze.length - 1 && y == maze[x].length - 1) return 1;
        //如果当前位置是路
        if(x < maze.length && y < maze[maze.length - 1].length && maze[x][y] == 0) {
            //如果下一步横竖都是死
            if(check(maze, x + 1, y) == -1 && check(maze, x, y + 1) == -1) {
                //将本位置封死
                maze[x][y] = 1;
                return -1;
            }else return 1;
            //如果当前位置不是路
        }else return -1;
    }
    public static String mazePath(int[][] maze, int x, int y) {
        //如果是右下角的出口，返回坐标
        if(x == maze.length - 1 && y == maze[x].length - 1) return "(" + x + "," + y + ")";
        //如果当前位置是路，返回坐标并且继续前进
        if(x < maze.length && y < maze[maze.length - 1].length && maze[x][y] == 0) return "(" + x + "," + y + ")" + "\n" + mazePath(maze, x + 1, y) + mazePath(maze, x, y + 1);
            //如果当前位置不是路，什么也不做
        else return "";
    }
}