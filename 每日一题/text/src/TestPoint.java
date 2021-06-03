import java.awt.*;
import java.util.HashMap;

public class TestPoint {
    public static void main(String[] args) {
        Point[]points=new Point[6];
        points[0]=new Point(1,1);
        points[1]=new Point(3,2);
        points[2]=new Point(5,3);
        points[3]=new Point(4,1);
        points[4]=new Point(2,3);
        points[5]=new Point(1,4);
        int m=get(points);
        System.out.println(m);
    }
    public static int get(Point[] points){
        int maxofall=0;
        int size=points.length;
        if(size==0)
            return 0;
        if(size==1)
            return 1;
        for (int i = 0; i < size; i++) {
            int curmax=1;//现在一条直线上最多有几个点  初始化
            HashMap<Double,Integer> map= new HashMap<>();//key用来存斜率 value用来存值  也就是该斜率的点有多少个
            int verticalsituation=0;//垂直的情况
            int samesituation=0;//两点重合的情况
            int x=points[i].x;
            int y=points[i].y;
            for (int i1 = 0; i1 < size; i1++) {
                if(i!=i1){
                    int xx=points[i1].x-x;
                    int yy=points[i1].y-y;
                    if(x==points[i1].x&&y==points[i1].y){ //两点重合的情况
                        samesituation++;
                    }
                    else if(x==points[i1].x&&y!=points[i1].y){ //两点垂直的情况
                        if(verticalsituation==0)
                            verticalsituation+=2;
                        else{
                            verticalsituation++;}
                        curmax= Math.max(verticalsituation,curmax);
                    }
                    else {
                        //普通情况 求相同斜率点的个数
                        if (xx != 0) {
                            double k = yy / xx;
                            if (!map.containsKey(k))
                                map.put(k, 2);
                            else map.put(k, map.get(k) + 1);
                            curmax = Math.max(map.get(k), curmax);
                        }
                    }
                }
                maxofall=Math.max(maxofall,curmax+samesituation);//重复的点+最大的点就是一条线上最多点的个数
            }

        }
        return maxofall;
    }
}
