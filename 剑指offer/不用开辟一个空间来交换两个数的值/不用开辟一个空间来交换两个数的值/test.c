//交换两个变量（不创建临时变量）
#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>
//加减
void Changer(int x, int y){
	x = x + y;
	y = x - y;
	x = x - y;
	printf("x:%d\n", x);
	printf("y:%d\n", y);
	printf("===========\n");
}

//按位异或
void Changer1(int x, int y){
	x = x^y;
	y = x^y;
	x = x^y;
	printf("x:%d\n", x);
	printf("y:%d\n", y);
}



int main(){
	int x;
	int y;
	printf("输入两个数X,Y\n");
	scanf("%d%d", &x,&y);
	Changer(x,y);
	Changer1(x, y);
}