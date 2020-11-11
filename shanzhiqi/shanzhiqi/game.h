#ifndef  __GAME_H__
#define __GAME_H__
//#pragma once//Ԥ��ͷ�ļ��ظ�����
#include<stdio.h>
#include<windows.h>
#define ROW 3
#define COL 3

void InitBoard(char board[][COL], int row, int col);

void ShowBoard(char board[][COL], int row, int col);
void PlayerMove(char board[][COL], int row, int col);

void ComputerMove(char board[][COL], int row, int col);
char IsWin(char board[][COL], int row, int col);

#endif