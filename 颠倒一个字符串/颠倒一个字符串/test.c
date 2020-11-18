#include <stdio.h>
//我来定义一个函数来实现我的颠倒的功能
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