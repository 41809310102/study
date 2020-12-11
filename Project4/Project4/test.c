#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<cstring>
#define size 13//分析表大小

struct table {//用于存储分析表
	char VN;
	char VT;
	char U[20];
	int n;
};

struct Czhan {//用于建立符号栈
	char c[20];
	int i;
};

struct Szhan {//用于存储输入串
	char c[50];
	int j;
};

table M[size];
Czhan s;
Szhan str;

void ChiShiHua()//存储分析表信息
{
	M[0].VN = 'E'; M[0].VT = 'i'; M[0].n = 2; M[0].U[0] = 'T'; M[0].U[1] = 'A';
	M[1].VN = 'E'; M[1].VT = '('; M[1].n = 2; M[1].U[0] = 'T'; M[1].U[1] = 'A';
	M[2].VN = 'A'; M[2].VT = '+'; M[2].n = 3; M[2].U[0] = '+'; M[2].U[1] = 'T'; M[2].U[2] = 'A';
	M[3].VN = 'A'; M[3].VT = ')'; M[3].n = 1; M[3].U[0] = '&';//'&'表示空串
	M[4].VN = 'A'; M[4].VT = '#'; M[4].n = 1; M[4].U[0] = '&';
	M[5].VN = 'T'; M[5].VT = 'i'; M[5].n = 2; M[5].U[0] = 'F'; M[5].U[1] = 'B';
	M[6].VN = 'T'; M[6].VT = '('; M[6].n = 2; M[6].U[0] = 'F'; M[5].U[1] = 'B';
	M[7].VN = 'B'; M[7].VT = '+'; M[7].n = 1; M[7].U[0] = '&';
	M[8].VN = 'B'; M[8].VT = '*'; M[8].n = 3; M[8].U[0] = '*'; M[8].U[1] = 'F'; M[8].U[2] = 'B';
	M[9].VN = 'F'; M[9].VT = 'i'; M[9].n = 1; M[9].U[0] = 'i';
	M[10].VN = 'F'; M[10].VT = '('; M[10].n = 3; M[10].U[0] = '('; M[10].U[1] = 'E'; M[10].U[2] = ')';
	M[11].VN = 'B'; M[11].VT = ')'; M[11].n = 1; M[11].U[0] = '&';
	M[12].VN = 'B'; M[12].VT = '#'; M[12].n = 1; M[12].U[0] = '&';
}

int Find_table(Czhan& a, char b) {
	int s = 0;//标志
	for (int h = 0; h < size; h++) {
		if (M[h].VN == a.c[a.i] && M[h].VT == b){
			int d = a.i;
			a.i = a.i + M[h].n - 1;
			if (M[h].n == 1 && M[h].U[0] == '&') {
				a.i--;
			}
			else {
				for (int k = M[h].n - 1; k >= 0; k--) {
					a.c[d] = M[h].U[k];
					d++;
				}
			}
			s = 1;
			break;
		}
	}
	if (s == 1)
		return s;
	else
		return 0;
}

int main() {
	char a[2] = { '#' };
	printf("Please input a string:\n ");
	gets_s(str.c);
	strcat_s(str.c, a);
	s.i = 0;
	s.c[s.i] = '#';
	str.j = 0;
	s.i++;
	s.c[s.i] = 'E';
	ChiShiHua();
label:
	if (s.c[s.i] != 'E' && s.c[s.i] != 'A' && s.c[s.i] != 'T' && s.c[s.i] != 'B' && s.c[s.i] != 'F') {
		if (s.c[s.i] == str.c[str.j]) {
			if (str.c[str.j] == '#') {
				printf("Right!\n");
				exit(0);
			}
			else {
				s.i = s.i - 1;
				str.j = str.j + 1;
				goto label;
			}
		}
		else {
			printf("Wrong!\n");
			exit(0);
		}
	}
	else {
		if (Find_table(s, str.c[str.j]) == 1) {
			goto label;
		}
		else {
			printf("Wrong!\n");
			exit(0);
		}
	}
	return 0;
}