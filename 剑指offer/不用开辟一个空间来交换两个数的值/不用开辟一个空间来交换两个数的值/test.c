//����������������������ʱ������
#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>
//�Ӽ�
void Changer(int x, int y){
	x = x + y;
	y = x - y;
	x = x - y;
	printf("x:%d\n", x);
	printf("y:%d\n", y);
	printf("===========\n");
}

//��λ���
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
	printf("����������X,Y\n");
	scanf("%d%d", &x,&y);
	Changer(x,y);
	Changer1(x, y);
}