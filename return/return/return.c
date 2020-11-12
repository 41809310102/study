#define _CRT_SECURE_NO_WARNINGS 

#include <stdio.h>

void Init(int arr[], int len)

{

	int i = 0;

	for (i = 0; i<len; i++)

	{

		arr[i] = 0;

	}

}





void Print(int arr[], int len)

{

	int i = 0;

	for (i = 0; i<len; i++)

	{

		printf("%d ", arr[i]);

	}

	printf("\n");

}





void Reverse(int *arr[], int len)

{

	int left = 0;

	int right = len - 1;


	while (left<right)

	{

		int *t= arr[left];

		arr[left] = arr[right];

		arr[right] = *t;

		left++;

		right--;

	}


}

int main(){

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int arr2[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int len = sizeof(arr) / sizeof(arr[0]);

		Init( arr, len);
		for (int i = 0; i< len; i++)

		{

			printf("%d\n", arr[i]);
		}
		Print(arr1,  len);
		for (int i = 0; i< len; i++)

		{

			printf("%d\n", arr1[i]);

		}

		Reverse(*arr2, len);

		for (int i = 0; i< len; i++)

		{

			printf("%d\n", arr2[i]);

		}

		return 0;

	}

