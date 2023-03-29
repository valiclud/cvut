/*
 * File:   Floyd_Warshall.cpp
 * Author: Ludvik VALĂŤCEK
 *
 * Created on 28. Ĺ™Ă­jen 2010, 20:52
 */
//#include <omp.h>
#include "mpi.h"
#include "windows.h"
#include "floyd_warshall.h"

/*
 *Search the shortest path by Floyd-Warshall alghoritm. Input is read via InputMatrix.cpp and
 * output is printed on the screen.
 */
using namespace std;

 Floyd_Warshall::Floyd_Warshall(){
 }

 Floyd_Warshall::~Floyd_Warshall(){
 }

int Floyd_Warshall::preinit(ifstream &ip){
    vertices = 0;
    file_result=inputMatrix(graph, &vertices, ip);

    if (file_result==1){
        cout<<"Chyba vstupniho souboru - program skonci"<<endl;
        ip.close();
        return (1);
    }
}

void Floyd_Warshall::init(){
    for(int i = 1; i <= vertices; i++){
               for(int j = 1; j <= vertices; j++){
                   if (graph[i][j] <= 0){
                        graph[i][j] = numeric_limits<int>::max(); // Equal to NO path
                   }
                   if(i == j) graph[i][j] = 0; // No distance from a node to that same node
               }
         }
}

void Floyd_Warshall::calculation( int starting, int stopping, int threadNum){
    cout<<"Starting stopping in function calculation " <<starting +1 << " " << stopping
            << " thread no.: " << threadNum  << " vertices no. " << vertices<<endl;
    int k, total_nloops = 0;
// zakomentovaný kód pro MPI - OMP implementaci 
//# pragma omp parallel shared (starting, stopping) private(i,j) num_threads(threadNum) 
//    {
//    # pragma omp for collapse (3)     
    for(k = starting+1 ; k <=stopping; k++){
               for(int i = starting+1; i <=stopping; i++){
                       for(int j = starting+1; j <=stopping; j++){
                                MPI_Bcast(&stopping, 1, MPI_INT, 0, MPI_COMM_WORLD); 
                                if (stopping == 0) 
                                        break; 
                                else { 
                                graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j]);
                                MPI_Reduce( &graph, &graphFinal, 1, MPI_INT, MPI_MIN,0, MPI_COMM_WORLD );  
                                }
                        }
                }    
   }
}
  //puvodni neparaelizovany vypocet 
//    void Floyd_Warshall::calculation( ){
//    
//    for(k = 1 ; k <=vertices; k++){
//               for(int i = 1; i <=vertices; i++){
//                       for(int j = 1; j <=vertices; j++){
//                               graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j]);
//                       }
//               }
//       }
//}
    

void Floyd_Warshall::output(){
    for(int i = 1; i <= vertices; i++){
               for(int j = 1; j <= vertices; j++){
                   cout << i << "..." << j << "->(";
                   cout<<graph[i][j] << ")"<<endl;
               }
    }
}
    
    
    void Floyd_Warshall::outputMPI(){
    for(int i = 1; i <= vertices; i++){
               for(int j = 1; j <= vertices; j++){
                   cout << i << "..." << j << "->(";
                   cout<<graphFinal[i][j] << ")"<<endl;
               }
    }
}
