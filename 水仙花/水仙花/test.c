#include <stdio.h>
#include <windows.h>

int Num(int i)
{
	int count = 0;//����
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
	int m = i;//Ϊ�˱���i��ֵ�����ı�
	int n = 1;//��Ÿ���λ��n�η�
	while (m > 0){
		int temp = m % 10;//�Ӹ�λ��ʼ���洢ÿһλ������
		m /= 10;
		for (j = num; j > 0; j--){
			n *= temp;//����ÿһλ��n�η�
		}
		sum += n;
		n = 1;//����n
	}
	if (sum == i){
		return 1;//��ˮ�ɻ���
	}
	else{
		return 0;//����ˮ�ɻ���
	}
}

int main()
{
	int i = 0;
	for (i = 0; i < 100000; i++){//��0~100000��ˮ�ɻ���
		int num = Num(i);
		if (Is_shuixianhua(i, num)){
			printf("%d\n", i);
		}
	}
	system("pause");
	return 0;
}