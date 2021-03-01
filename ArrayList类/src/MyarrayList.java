

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

class MyArraylist<T>{
    public T[] elem;
    public int usedsize;

    public MyArraylist(T[] elem, int usedsize) {
        this.elem = elem;
        this.usedsize = usedsize;
    }

    public MyArraylist() {

        this.elem= (T[]) new Object[5] ;
    }
    public  int Getsize(){
        return this.usedsize;
    }

    public void Add(T data){
        this.elem[this.usedsize]=data;
        this.usedsize++;
    }
//获取ihdex位置的元素
    public T Get(int index){
        if (index>this.usedsize){
            return null;
        }
        return this.elem[index];
    }

    public T Remove(int index){
        if (index>this.usedsize){
            return null;
        }
        T res = this.elem[index];
        for (int i =index;i<usedsize;i++){
            this.elem[i]=this.elem[i+1];
        }
        this.usedsize=this.usedsize-1;
        return res;
    }

    @Override
    public String toString() {
        return "MyArraylist{" +
                "elem=" + Arrays.toString(elem) +
                '}';
    }
}