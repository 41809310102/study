
#define _CRT_SECURE_NO_WARNINGS 

#include <stdio.h>
void Fun(int num)
{
	for (int i = 31; i >= 1; i =i-2)
	{
		printf("%d ", (num >> i) & 1);
	}
	printf("\n");  //����λ

	for (int i = 30; i >= 0; i =i-2)
	{
		printf("%d ", (num >> i) & 1);
	}  
	printf("\n");  //ż��λ
}



int main(){
	int num;
	scanf("%d", &num);
	Fun(num);

}