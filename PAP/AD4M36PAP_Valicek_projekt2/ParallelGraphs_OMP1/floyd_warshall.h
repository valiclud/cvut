/* 
 * File:   floyd_warshall.h
 * Author: Ludvik VALÍCEK
 *
 * Created on 28. říjen 2010, 21:33
 */

#ifndef _FLOYD_WARSHALL_H
#define	_FLOYD_WARSHALL_H

#define MAX 600

#include <stdlib.h>
#include <iostream>
#include <limits>
#include <stdio.h>
#include <fstream>

int inputMatrix(int graph[][MAX],int *vertices, std::ifstream &in);

class Floyd_Warshall
{
public:
    Floyd_Warshall(void);
    ~Floyd_Warshall(void);
    int preinit(std::ifstream &in);
    void init(void);
    void calculation(int);
    void output(void);

    int vertices;
    int graph[MAX][MAX];
    char s[20];

private:
    int i,j,k;
    int file_result;
};

#endif	/* _FLOYD_WARSHALL_H */
