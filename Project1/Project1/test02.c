#define _CRT_SECURE_NO_WARNINGS 

#include <stdio.h>



	int Fun(int m, int n)

	{

		int t = m^n;

		int count = 0;

		while (t)

		{

			t = t&(t - 1);

			count++;

		}

		return count;

	}





	int main()

	{

		int m, n;

		while (scanf("%d %d", &m, &n) == 2)

		{

			printf("%d\n", Fun(m, n));

		}

		return 0;

	}



