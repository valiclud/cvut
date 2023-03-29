/*
 * File:   Dijkstr.cpp
 * Author: Ludvik VALĂŤCEK
 *
 * Created on 9. Ĺ™Ă­jen 2010, 9:29
 */

#include "dijk.h"
#include "windows.h"
/*
 *Search the shortest path by Dijkstrov alghoritm. Input is read via InputMatrix.cpp and
 * output is printed on the screen.
 */
using namespace std;

Dijk::Dijk(){
}

Dijk::~Dijk(){
}

int Dijk :: preinit(ifstream &in){
    vertices = 0;
    
    file_result=inputMatrix(graph, &vertices, in);

    if (file_result==1){
        cout<<"Chyba vstupniho souboru - program skonci"<<endl;
        in.close();
        return (1);
    }
}

int Dijk::init(int j){
   first = j;

   for(int i=1;i<=vertices;i++){
    mark[i]=0;
    estimation[i]=numeric_limits<int>::max();
    last[i]=0;
 }
 estimation[first]=graph[first][first];
}

void Dijk::calculation(void){
 signed int count=-1;
 int i;
 int min;

while(count<vertices){
  min=minimal();
  actual[++count]=min;
  mark[min]=1;
  for(i=1;i<=vertices;i++)
  {
   if(graph[min][i]>0)
   {
    if(mark[i]!=1){
        if(estimation[i]>estimation[min]+graph[min][i]){
            estimation[i]=estimation[min]+graph[min][i];
            last[i]=min;
    }
    }
   }
  }
 }
}

////paralelizace smycky while - původní program - metoda forParallel
//  int sj, sstop, tn, tj, tstop;
//  omp_set_num_threads(4);
//  sj = -1;     // sdílený čítač smyčky
//  sstop = 0;   // sdílená hodnota pro ukončení smyčky
//  #pragma omp parallel private(tn,tj,tstop)
//  {
//      #pragma omp single 
//      { tn = omp_get_thread_num();
//       }     
//    while (!sstop)
//    {
//      //jednotlivá vlákna načítají čítač
//      #pragma omp critical
//      {
//        sj++;      
//        tj = sj;   // kopie čítače
//      }
//      //paralelní volání funkce
//      tstop = forParallel(tj);
//      //ukončení vláken při naplnění čítače
//      if (tstop)
//      {
//        sstop = 1;
//        #pragma omp flush(sstop)
//      }
//    }
//  }
//}
int Dijk::minimal(void){
     int m = numeric_limits<int>::max();
     int i,t;
 for(i=1;i<=vertices;i++){
  if(mark[i]!=1)
  {
   if(estimation[i]<=m){
   m=estimation[i];
   t=i;
   }
  }
 }
     return t;
}

void Dijk::printway(int i){

    if(i==first){
        cout<<first;
    }
    else if(last[i]==0)
        cout<<"no path from "<<first<<" to " <<i;
    else{
        printway(last[i]);
        cout<<"..."<<i;
}
}

void Dijk::output(void){

// for(int i=1;i<=vertices;i++){
//    printway(i);
// if(estimation[i]!=numeric_limits<int>::max())
//  cout<<"->("<<estimation[i]<<")"<<endl;
// }
}