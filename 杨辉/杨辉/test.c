#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void yangHui(int n){
	int arr[30][30] = { 1 }; //��һ��ֱ����ã���������

	int i, j;
	for (i = 1; i < n; i++) //�ӵڶ��п�ʼ��
	{
	arr[i][0] = 1; //ÿ�еĵ�һ�ж�û������ֱ�Ӹ�1����֤����Խ�硣
		for (j = 1; j <= i; j++) //�ӵڶ��п�ʼ��
		{
			arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
		}
	}


	for (i = 0; i<n; i++)   //��ӡ����
	{
		for (j = 0; j<=i; j++)
		{
			printf(" %d ", arr[i][j]);
		}
		putchar('\n');
	}

}



int main(){
	int a = 5;
	yangHui(a);
	return 0;
}

/*void yangHui(int n)
{
	int data[30][30] = { 1 }; //��һ��ֱ����ã���������

	int i, j;

	for (i = 1; i < n; i++) //�ӵڶ��п�ʼ��
	{
		data[i][0] = 1; //ÿ�еĵ�һ�ж�û������ֱ�Ӹ�1����֤����Խ�硣
		for (j = 1; j <= i; j++) //�ӵڶ��п�ʼ��
		{
			data[i][j] = data[i - 1][j] + data[i - 1][j - 1]; 
		}
	}

	for (i = 0; i < n; i++) //�����ӡ
	{
		for (j = 0; j <= i; j++)
		{
			printf("%d ", data[i][j]);
		}
		putchar('\n');
	}
}


int main(){
	int a=5;
	yangHui(a);

}*/


