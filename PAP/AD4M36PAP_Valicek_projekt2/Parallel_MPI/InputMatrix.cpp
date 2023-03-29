/*
 * File:   InputMatrix.cpp
 * Author: Ludvik VALÍCEK
 *
 * Created on 9. říjen 2010, 9:29
 */


#include <string>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstdlib>
#include <sstream>
#include <limits>
#include "floyd_warshall.h"

using namespace std;

/*
 *Method inputMatrix.cpp reads required values from matrix, enregistred as text file.
 */
string trim( const string& s )
  {
  string result( s );
  result.erase( result.find_last_not_of( " " ) + 1 );
  result.erase( 0, result.find_first_not_of( " " ) );
  return result;
  }

int inputMatrix(int graph[][MAX], int *vertices, ifstream &in) {

    int row=0, column=0, step=0, count=0;
    string line;

    while( getline(in, line)) {

        if (in.fail()){
            cout << "Chyba vstupniho souboru" << endl ;
            return (1);
        }
        
        row++;
        istringstream tokenizer(line); // insert the string into the stream
        string token;

        while (getline(tokenizer, token, ' ')){
            count++;
            step++;
            istringstream int_convert(trim( token )); // conversion string into int
            
            if (int_convert >> graph[row][step]){
                if (graph[row][step] < 0){
                    graph[row][step]=0;
                    cout<<"Na pozici vstupni matice "<<row<<","<<step<<" bylo nalezeno zaporne ohodnoceni, ktere bylo nastaveno na 0"<<endl;
                }
                if (graph[row][step]>numeric_limits<int>::max()){
                    graph[row][step]=numeric_limits<int>::max();
                    cout<<"Na pozici vstupni matice "<<row<<","<<step<<" bylo nalezeno ohodnoceni, ktere prevysuje maximalni mozne cislo, pozice byla nastavena na maximalni integer"<<endl;
                }
            }
            else {
                cout<<"Vstupni soubor neobsahuje ciselna data"<<endl;
                return(1);
            }
        }
        column=step;
        step=0;        
        }   

    if (row == 0){
            cout<<"Vstupni soubor je prazdny" << endl;
            return (1);
        }

    if (((count%row)>0)||(count%column)>0){
        cout<<"Chyba vstupniho souboru - ve vstupni ctvercove matici chybi nebo prebyvaji prvky"<<endl;
        return (1);
    }

    if (row==column)*vertices=row;
    else{
            cout << "Chyba vstupniho souboru - nestejny pocet radku a sloupcu" <<endl;
            return (1);
        }
    return (0);
}
