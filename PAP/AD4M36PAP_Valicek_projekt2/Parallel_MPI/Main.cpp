/* 
 * File:   Main.cpp
 * Author: Ludvik VALÍCEK
 *
 * Created on 13. listopad 2010, 19:23
 */
#include "mpi.h"
#include "windows.h"
#include <stdlib.h>
#include <iostream>
#include "floyd_warshall.h"

using namespace std;

/*
 * Main class of program for searching shortest path using alghoritms Dijkstrov and Floyd-Warshall
 */

int main(int argc, char** argv) {
//   kod programu v C 
   int  numtasks, rank, len, rc;
   char hostname[MPI_MAX_PROCESSOR_NAME];
   
   rc = MPI_Init(&argc,&argv);
   
   if (rc != MPI_SUCCESS) {
     printf ("Error starting MPI program. Terminating.\n");
     MPI_Abort(MPI_COMM_WORLD, rc);
     }
   MPI_Comm_size(MPI_COMM_WORLD,&numtasks);
   MPI_Comm_rank(MPI_COMM_WORLD,&rank);
   MPI_Get_processor_name(hostname, &len);
   printf ("Number of tasks= %d My rank= %d Running on %s\n", numtasks,rank,hostname);
    numtasks = 1;
    int threadNum = 1;
    char s[20];
    cout<< "Vypocet nejkratsi cesty v ohodnocenem grafu" << endl;
    cout<< "Vysledky jsou zobrazeny ve formatu:" << endl;
    cout<< "vychozi vrchol ... cilovy vrchol ->( velikost nejkratsi cesty )"<<endl<<endl;
    cout<< "Je pripraveno 11 testovacich souboru s vazenou matici sousednosti:" << endl;
    cout<< "Test1.txt (matice 3x3) , Test2.txt (matice 4x4), Test3.txt (matice 5x5),"
            " Test4.txt (matice 10x10), Test5.txt (40x40), Test6.txt (80x80), Test7.txt (20x20), Test100.txt, TestNew240.txt, Test500.txt, Test1000.txt" << endl;
    cout<< "Zadejte nazev jednoho z vyse uvedenych souboru:" << endl;
    cin >> s;
    cout<< "Zadejte pocet vlaken" <<endl;
    cin >> threadNum;    
    cout<< "Zadejte pocet tasku" <<endl;
    cin >> numtasks;    
    ifstream in(s);
    ifstream inn(s);

    if (!in.good()) {
        cout << "Chyba pri cteni souboru - spatne zadane jmeno souboru nebo soubor neexistuje"<<endl;
        in.close();
        inn.close();
        return (1);
    }
    //Nastaveni hodnot timeru
    LARGE_INTEGER start, stop, frequency;
    long overhead;
    QueryPerformanceFrequency(&frequency);
    QueryPerformanceCounter(&start);
    QueryPerformanceCounter(&stop);
    overhead = stop.QuadPart-start.QuadPart;
    
    cout<<"Nejkratsi cesta - algoritmus Floyd-Warshall" <<endl;
    Floyd_Warshall *f = new Floyd_Warshall();
    f->preinit(inn); 
    f->init();
    int count = f->vertices / numtasks;    
    int starting = rank * count;
    int stopping = starting + count;
    cout<<"Starting  " << starting << " stopping " << stopping  << " thread no.: " << threadNum
            << " vertices no. " << f->vertices<<endl;
  
    QueryPerformanceCounter(&start);
    f->calculation(starting, stopping, threadNum);
//     f->calculation();
    QueryPerformanceCounter(&stop);
    f->output();
//    f->outputMPI();
    MPI_Finalize();
    delete f;
    cout<<"Beh Floyd_Warshalla algoritmu trval " 
    << 1000*(stop.QuadPart - start.QuadPart - overhead)/(double)frequency.QuadPart
    << " ms" << endl;
    in.close();
    inn.close();
    
    return (0);
}
