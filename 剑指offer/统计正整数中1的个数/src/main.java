public class main {

    int count = 1;
        if(n==0) return 0;
        if(n<10&&n>-10) return 1;
        for(int i = 10;i<=n;i++){
        int num = i;
        while(num!=0){
            int res = num%10;
            if(res==1){
                count++;
            }
            num=num/10;
        }
    }
    return count;
}

}
