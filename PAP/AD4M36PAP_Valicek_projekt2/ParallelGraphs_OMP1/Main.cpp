/* 
 * File:   Main.cpp
 * Author: Ludvik VALÍCEK
 *
 * Created on 13. listopad 2010, 19:23
 */

#include "windows.h"
#include <stdlib.h>
#include <iostream>
#include "dijk.h"
#include "floyd_warshall.h"

using namespace std;

/*
 * Main class of program for searching shortest path using alghoritms Dijkstrov and Floyd-Warshall
 */

int main() {
    int threadNum = 1;
    char s[20];
    cout<< "Vypocet nejkratsi cesty v ohodnocenem grafu" << endl;
    cout<< "Vysledky jsou zobrazeny ve formatu:" << endl;
    cout<< "vychozi vrchol ... cilovy vrchol ->( velikost nejkratsi cesty )"<<endl<<endl;
    cout<< "Jsou pripraveny 3 testovaci soubory s vazenou matici sousednosti:" << endl;
    cout<< "Test1.txt (matice 3x3) , Test2.txt (matice 4x4), Test3.txt (matice 5x5),"
            " Test4.txt (matice 10x10), Test5.txt (40x40), Test6.txt (80x80), Test7.txt (20x20), Test100.txt, Test240.txt, Test500.txt, Test1000.txt" << endl;
    cout<< "Zadejte nazev jednoho z vyse uvedenych souboru:" << endl;
    cin >> s;
    cout<< "Zadejte pocet vlaken" <<endl;
    cin >> threadNum;
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
    cout<<"Nejkratsi cesta - algoritmus Dijkstrov" <<endl;
    Dijk *d = new Dijk();
    d->preinit(in);
    QueryPerformanceCounter(&start);

    for (int j=1;j<=d->vertices; j++){
    d->init(j);
    d->calculation();
    d->output();
    }
    QueryPerformanceCounter(&stop);
    delete d;
    cout<<"Beh Dijkstrovova algoritmu trval " 
    << 1000*(stop.QuadPart - start.QuadPart - overhead)/(double)frequency.QuadPart
       << " ms" << endl;
    cout<<endl;
    cout<<"Nejkratsi cesta - algoritmus Floyd-Warshall" <<endl;
    Floyd_Warshall *f = new Floyd_Warshall();
    f->preinit(inn);
 
    f->init();
    QueryPerformanceCounter(&start);
    f->calculation(threadNum);

    QueryPerformanceCounter(&stop);
    f->output();
    delete f;
    cout<<"Beh Floyd_Warshalla algoritmu trval " 
    << 1000*(stop.QuadPart - start.QuadPart - overhead)/(double)frequency.QuadPart
       << " ms" << endl;
    in.close();
    inn.close();

    return (0);
}