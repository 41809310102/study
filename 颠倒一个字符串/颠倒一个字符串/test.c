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


int main(){
	char str[] = "I LOVE YOU ,dear";
	Fun(str);
	printf("%s\n", str);

}