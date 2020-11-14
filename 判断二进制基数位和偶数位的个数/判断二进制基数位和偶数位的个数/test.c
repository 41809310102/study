
#define _CRT_SECURE_NO_WARNINGS 

#include <stdio.h>
void Fun(int num)
{
	for (int i = 31; i >= 1; i =i-2)
	{
		printf("%d ", (num >> i) & 1);
	}
	printf("\n");  //奇数位

	for (int i = 30; i >= 0; i =i-2)
	{
		printf("%d ", (num >> i) & 1);
	}  
	printf("\n");  //偶数位
}



int main(){
	int num;
	scanf("%d", &num);
	Fun(num);

}