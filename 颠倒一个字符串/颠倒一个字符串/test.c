#include <stdio.h>
//��������һ��������ʵ���ҵĵߵ��Ĺ���
#include <math.h>
#include <string.h>
void Fun(char *str){
	char* lift=str;
	char* right=str+strlen(str)-1;
	while (lift<right)
	{
		char tem = *lift;
		*lift = *right;
		*right = tem;
		++lift;
		--right;
	}
}

void Fun1(char *str){
	for (int i = 0; i<=strlen(str)-1; i++)
	{
		char *p;
		char *q;
		if (str[i] = ' ')
			p = str;
		    q = str + i;
			while (p<q)
			{
				char tem = *p;
				*p = *q;
				*q = tem;
				++p;
				--q;
			}
	}

}


int main(){
	char str[] = "i like beijing";
	Fun(str);
	printf("%s\n", str);

}