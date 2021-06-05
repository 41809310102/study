import java.util.Arrays;

/**
 * 实现ArrayList类
 */

public class MyArrayList {
   /* public  int[] elem = new int[10]; //实现数组特征
    public  int usedSize = 0; //实现长度特征
    */
    private  int[] elem;
    private  int useSize;

    public  MyArrayList(){
        this.elem = new int[5]; //默认长度为11的数组
    }

    public  MyArrayList(int len){
        this.elem = new int[len];  //动态初始化数组
    }


    public  boolean isFull(){
        if(this.useSize==this.elem.length){
            return  true;  //如果当前的长度和数组的长度相等，那么就说明顺序表满了
        }
        return false; //顺序表未
    }



    public  void display(){
        for (int i =0;i<this.useSize;i++){
            System.out.println(" "+this.elem[i]);
        }
    }

    //给定位置插入元素
    public void add(int pos, int data) {
        if(isFull()){
           // System.out.println("顺序表已经满了！");
            resize();
           // return;
        }
        if(pos<0||pos>this.useSize){
            System.out.println("输入位置不合法！");
            return;
        }
        for( int i =this.useSize-1;i>=pos;i--){
            this.elem[i+1] = this.elem[i]; //将pos位置后的元素向后移动元素，到pos位置停止；
        }
        this.elem[pos] = data;//将数据插入
        this.useSize++; //顺序表长度增加1
    }
    //尾插法
    public  void addLast(int data){
        if(isFull()){
           // System.out.println("顺序表已经满了");
            resize();
            //return;
        }
        this.useSize++;//长度加一
        this.elem[this.useSize] = data;
    }
    //头插法
    public  void addHead(int data){
        if(isFull()){
            // System.out.println("顺序表已经满了");
            resize();
            //return;
        }
     for(int i = this.useSize-1;i>=0;i--){
         this.elem[i+1] = this.elem[i];
     }
     this.elem[0] = data;
     this.useSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if(this.elem==null||this.useSize<=0) {
            System.out.println("线性表是空的！");
            return false;
        }
        for(int i = 0;i<this.useSize;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        if(this.elem==null||this.useSize<=0){
            System.out.println("线性表是空的！");
            return -1;
        }
        for(int i =0;i<this.useSize;i++){
            if(this.elem[i]==toFind){
                return i;//找到则返回下标
            }
        }
        return -1; //没有找到则返回-1
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(this.elem==null||this.useSize<=0){
            System.out.println("线性表是空的！");
            return -1;
        }
        if(pos>=0&&pos<this.useSize){
            return this.elem[pos];
        }
        return -1;
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(this.elem==null||this.useSize<=0){
            System.out.println("顺序表为空！");
            return;
        }
       this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if(this.elem==null||this.useSize<=0){
            System.out.println("线性表为空！");
            return;
        }
        //1.查找是否有key
        if(contains(toRemove)){ //查找是否包含toRemove
            int i = search(toRemove); //得到toRemove的位置
            for(int n = i ;n<this.useSize-1;n--)
            this.elem[n] = this.elem[n+1];
        }
    }
    // 获取顺序表长度
    public int size() {
        return this.useSize;
    }
    // 清空顺序表
    public void clear() {
     this.useSize=0;
    }
    //扩容
    public  void resize(){
     this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
    }
}
