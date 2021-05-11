import java.util.Scanner;

/**
 * 每次读取一个数之后，算出他经过k次洗牌后的位置，只用一个长度为2n数组用来输出
 * 根据当前数的位置，可以算出经过一次洗牌后的位置
 * 如果当前数小于等于n（即在左手），则他下次出现的位置是 2*当前位置-1
 * 如果当前位置大于n（即在右手）,则他下次出现的位置是 2*（当前位置 - n）
 * 个人建议在线面试题的时候如果5分钟内没想到好方法建议就使用暴力方法，
 * 毕竟测试用例不通过什么都没用
 * Created by lizo on 2016/8/20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        while (groups-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] res = new int[2*n];
            for(int i=0;i<2*n;i++){
                int tmp = i + 1;
                for(int j = 0; j < k;j++){
                    if (tmp <= n) tmp = 2*tmp - 1;
                    else tmp = 2 * (tmp - n);
                }
                res[tmp - 1]=sc.nextInt();
            }
            //输出
            if(res.length> 0) System.out.print(res[0]);
            for(int i = 1;i< 2*n;i++){
                System.out.print(" "+res[i]);
            }
            System.out.println();
        }
    }
}
/*
* 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// 使用Scanner来获取键盘输入

        // 第一次输入的是T
        // T：要洗牌的牌组数量
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            // 第二次输入的是n和k
            // n：2n即牌的数量
            // k：洗牌的次数
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            // 获得牌组cards，并分成两堆cards1和cards2
            ArrayList<Integer> cards = new ArrayList<>();
            ArrayList<Integer> cards1 = new ArrayList<>();
            ArrayList<Integer> cards2 = new ArrayList<>();

            // 获得牌组cards所有数
            for (int j = 0; j < 2 * n; j++) {
                cards.add(scanner.nextInt());
            }
            Collections.reverse(cards);// 将牌组顺序翻转，便于洗牌

            for (int x = 0; x < k; x++) {
                cards1.clear();
                cards2.clear();

                //将下半堆放入cards1
                for (int j = 0; j < n; j++) {
                    cards1.add(cards.get(j));
                }

                // 将上半堆放入cards2
                for (int j = n; j < 2 * n; j++) {
                    cards2.add(cards.get(j));
                }

                // 洗牌过程
                cards.clear();
                for (int j = 0; j < n; j++) {
                    cards.add(cards1.get(j));
                    cards.add(cards2.get(j));
                }
            }

            Collections.reverse(cards);// 再把牌组顺序反转为正常顺序
            System.out.println(
                    cards.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }

        scanner.close();
    }
}
发表于 2016-08-24 00:18:30*/