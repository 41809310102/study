#include <stdio.h>
int main(){
	int arr[] = {1,2,3,4,5,6};
	int *p = arr;
	int len = sizeof(arr) / sizeof(arr[0]);
	for (int i =1 ;i < len; i++)
	{
			printf("%d\n", *p);
			++p;
	}
	return 0;
}
/*void Changer(char arr,int len){
	char *p = arr;
	if (p + len - 1 > p)
	{
		char *t=NULL;
		t = *(p + len-1);
		*(p + len - 1) = *p;
		*p = t;
	}
	else
		return 0;

	printf("%s", *p);
}

int main(){
	char arr[] = "hujunjie";
	int len = sizeof(arr) / sizeof(arr[0])-1;
	Changer(*arr, len);

}*/

/*void Reverse(char* arr,int len)
{
	char* left = arr;
	char* right = arr + len;
	while (left < right)
	{
		char t = *left;
		*left = *right;
		*right = t;
		++left;
		--right;
	}
}

int main(){
	char arr[] = "hujunjie";
	int len = sizeof(arr) / sizeof(arr[0]) - 1;
    Reverse(arr,len);
	char *p = arr;
	for (int i = 0; i < len; i++)
	{
		printf("%s", *p);
		++p;
	}
	return 0;
}*/

/*��Sn = a + aa + aaa + aaaa + aaaaa��ǰ5��֮�ͣ�����a��һ�����֣�

���磺2 + 22 + 222 + 2222 + 22222*/
/*void Sum(int a, int b);
int main()
{
	int a = 2;
	int b = 5;
	Sum(a, b);
}
void Sum(int a, int b){
	int sum = 0;
	int t = 0;
	int i = 0;
	for (i = 0; i<b; i++)
	{
		t = t * 10 + a;
		sum += t;
	}
	printf("%d\n", sum);
}*/


/*��C��������Ļ�����*������ͼ����
         *
	    ***
	   *****
	  *******
	 *********
	***********
   *************
#include <stdio.h>

int main()

{

	int line = 0;

	int i = 0;

	scanf_s("%d", &line);//������������

	//��ӡ�ϰ벿��

	for (i = 0; i<line; i++)

	{

		//��ӡһ��

		//��ӡ�ո�

		int j = 0;

		for (j = 0; j<line - 1 - i; j++)

		{

			printf(" ");

		}

		//��ӡ*

		for (j = 0; j<2 * i + 1; j++)

		{

			printf("*");

		}

		printf("\n");

	}





	
	//��ӡ�°벿��
	/*
	for (i = 0; i<line - 1; i++)

	{

		//��ӡһ��

		int j = 0;

		for (j = 0; j <= i; j++)

		{

			printf(" ");

		}

		for (j = 0; j<2 * (line - 1 - i) - 1; j++)

		{

			printf("*");

		}

		printf("\n");

	}

	return 0;

}
*/

