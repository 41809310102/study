/*#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>
int reverse(int x){
	int a = 0;
	while (x)
	{
		int b = (unsigned)a * 10;
		if (b / 10 != a)
			return 0;
		a = b + x % 10;
		x = x / 10;
	}
}
int main()
{
	int a;
	printf("请输入你要反转的数\n");
	scanf("%d", &a);
	int c=reverse(a);
	printf("%d\n",c);
	return 0;
}*/