/* 
 * File:   dijk.h
 * Author: Ludvik VALĂŤCEK
 *
 * Created on 27. Ĺ™Ă­jen 2010, 21:14
 */

#ifndef _DIJK_H
#define	_DIJK_H

#define MAX 600
#include <fstream>
#include <iostream>
#include <stdlib.h>
#include <iomanip>
#include <limits>
#include <istream>

int inputMatrix(int graph[][MAX],int *vertices, std::ifstream &in);

class Dijk
{
public:
    Dijk(void);
    ~Dijk(void);
    int preinit(std::ifstream &in);
    int init(int);
    void calculation(void);
    void printway(int);
    void output(void);
    
    int vertices, first;
    int graph[MAX][MAX];
    char s[20];

private:
    int minimal(void);
    int actual[MAX], estimation[MAX], last[MAX],mark[MAX];
    int min;
    int i,k;
    int file_result;
};

#endif	/* _DIJK_H */