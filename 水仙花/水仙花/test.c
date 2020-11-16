#include <stdio.h>
#include <windows.h>

int Num(int i)
{
	int count = 0;//计数
	while (i > 0){
		count++;
		i /= 10;
	}
	return count;
}

int Is_shuixianhua(int i, int num)
{
	int sum = 0;
	int j = 0;
	int m = i;//为了避免i的值发生改变
	int n = 1;//存放各个位的n次方
	while (m > 0){
		int temp = m % 10;//从个位开始，存储每一位的数字
		m /= 10;
		for (j = num; j > 0; j--){
			n *= temp;//计算每一位的n次方
		}
		sum += n;
		n = 1;//重置n
	}
	if (sum == i){
		return 1;//是水仙花数
	}
	else{
		return 0;//不是水仙花数
	}
}

int main()
{
	int i = 0;
	for (i = 0; i < 100000; i++){//求0~100000的水仙花数
		int num = Num(i);
		if (Is_shuixianhua(i, num)){
			printf("%d\n", i);
		}
	}
	system("pause");
	return 0;
}