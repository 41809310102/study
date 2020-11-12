#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>
int main()
{
	int arr1[10] = { 0 };
	int arr2[10] = { 0 };
	int i = 0;


	printf("请输入10个数字:>");
	for (i = 0; i<10; i++)
	{
		scanf("%d", &arr1[i]);
	}
	printf("请输入10个数字:>");
	for (i = 0; i<10; i++)
	{
		scanf("%d", &arr2[i]);
	}
	//交换
	for (i = 0; i<10; i++)
	{
		int tmp = arr1[i];
		arr1[i] = arr2[i];
		arr2[i] = tmp;
	}

	return 0;
}