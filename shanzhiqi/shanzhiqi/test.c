#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
void menu()
{
	printf("***********************\n");
	printf("********0.exit********\n");
	printf("********1.play**********\n");
	printf("***********************\n");
}
void game()
{
	//printf("����Ϸ\n");
	char board[ROW][COL] = { 0 };
	InitBoard(board, ROW, COL);
	ShowBoard(board, ROW, COL);
	int ret = 0;
	while (1)
	{
		PlayerMove(board, ROW, COL);
		ShowBoard(board, ROW, COL);
		ret = IsWin(board, ROW, COL);
		if (ret != ' ')
		{
			break;//�϶���һ����Ӯ��
		}
		ComputerMove(board, ROW, COL);
		ShowBoard(board, ROW, COL);
		ret = IsWin(board, ROW, COL);
		if (ret != ' ')
		{
			break;//�϶���һ����Ӯ��
		}
	}

	if (ret == ' Q')
	{
		printf("ƽ��\n");
		return;
	}
	if (ret == 'X')
	{
		printf("���Ӯ\n");
		return;
	}
	if (ret == 'O')
	{
		printf("����Ӯ\n");
		return;
	}
}
void test1()
{
}
void test2()
{
	test1();
}
int main()
{
	test2();
	/*for (i = 0; i <= 12; i++)
	{
	arr[i] = 0;
	printf("hehe\n");
	}*/

	srand((unsigned)time(NULL));
	int input = 0;
	printf("��������Ĳ�����\n");
	do
	{
	menu();
	scanf("%d", &input);
	switch (input)
	{
	case 1:
	game();
	break;
	case 0:
	printf("�˳���Ϸ\n");
	break;
	default:
	break;
	}

	} while (input);
	system("pause");
	return 0;
}
void Show(int arr1[][3],int row,int col)
{
	for (int i = 0; i < row; i++)
{
	for (int j = 0; j < col; j++)
{			printf("%d ", arr1[i][j]);
	}
	printf("\n");
}
}
//void bubbleSort(int arr[],int len)
//{
//	//i��������
//	for (int i = 0; i < len-1; i++)
//	{
//		//                        5-1-3
//		for (int j = 0; j < len-1-i; j++)
//		{
//			if (arr[j] > arr[j + 1])
//			{
//				int tmp = arr[j];
//				arr[j] = arr[j+1];
//				arr[j + 1] = tmp;
//			}
//		}
//	}
//}
//
//void ShowArr(int arr[],int len)
//{
//	for (int i = 0; i < len; i++)
//	{
//		printf("%d ",arr[i]);
//	}
//	printf("\n");
//}
//int main()
//{
//	int arr1[] = {1,21,13,4,15,6};
//	printf("%d\n", arr1);//������Ԫ�صĵ�ַ
//	printf("%d\n", &arr1[0]);
//	printf("%d\n", &arr1);//��������ĵ�ַ
//	//��Ȼ  ֵ ��һ����  ���� ���岻һ��
//	//�ܽ᣺����������������� �����������飺
//	//1��sizeof(arr)->ǰ�᣺���������ʱ��        2��&arr
//
//
//	/*int len = sizeof(arr1) / sizeof(arr1[0]);
//	ShowArr(arr1,len);
//	bubbleSort(arr1,len);
//	ShowArr(arr1, len);
//*/
//
//	/*printf("%d,%d\n",arr1[0][2],arr1[1][0]);
//	printf("%d,%d\n", &arr1[0][2], &arr1[1][0]);*/
//
//
//
//	//Show(arr1,2,3);
//	/*for (int i = 0; i < 2; i++)
//	{
//		for (int j = 0; j < 3; j++)
//		{
//			printf("%d ",arr1[i][j]);
//		}
//		printf("\n");
//	}*/
//
//
//
//
//	//int arr2[2][3] = { { 1, 2, 3 }, { 4, 5, 6 } };
//	//int arr3[2][3] = { { 1, 2 }, {3,4,5} };//ʣ��û�г�ʼ���Ĳ���0
//	//
//	////int arr4[2][] = { { 1, 2, 3 }, { 4, 5, 6 } }; ע�⣺����ʡ����
//	//int arr5[][3] = { { 1, 2, 3 }, { 4, 5, 6 } };
//	//
//	//int arr6[2][3];//Ĭ�Ͼ������ֵ
//
//	system("pause");
//	return 0;
//}