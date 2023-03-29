//  
//#include <omp.h>  
//#include "windows.h"
//#include <stdlib.h>
//#include <stdio.h>
//#include <string.h>
//// globální proměnné
//int vertices,  // počet vrcholů
//    *flag, // neprošlé vrcholy
//    threadsNum,  // počet vláken
//    chunk,  // počet uzlů zpracovávaných jedním vláknem  
//    minimum,  // globální minimum společné pro všechny vlákna 
//    minimumVertex,  // vrchol, který ddosáhl minimum
//    largeint = -1;  // nnekonečno pro nastavení algoritmu  
//  
//unsigned *graph,  // 1-hop vzdálenost mezi vrcholy; "graph[i][j]" je graph[i*vertices+j]  
//         *minDistance;  // dosud nalezená minimální vzdálenost  
// 
//#define MAXTOKENS       256
//#define MAXLINE         1024     
//#define MINLEN          3   
//char **split(char *string, char *delim);/* fce pro kouskování matice */
//void init(void);
//void dowork(void);
//int main(int argc, char **argv)  
//{  int i,j;  
//    //Nastaveni hodnot timeru
//    LARGE_INTEGER start, stop, frequency;
//    long overhead;
//    QueryPerformanceFrequency(&frequency);
//    QueryPerformanceCounter(&start);
//    QueryPerformanceCounter(&stop);
//    overhead = stop.QuadPart-start.QuadPart;
//    init();  
//    QueryPerformanceCounter(&start);
//    dowork();    
//    QueryPerformanceCounter(&stop);
////   init();  
////   QueryPerformanceCounter(&start);
////   // paralelní výpočet  
////   dowork();   
////   QueryPerformanceCounter(&stop);
//  
//   printf("Beh Dijkstra alghoritmu trval %2.8f\n", 1000*(stop.QuadPart - start.QuadPart - overhead)/(double)frequency.QuadPart );  
//   // tisk hodnot
////      printf("váha grafu:\n");  
////      for (i = 0; i < vertices; i++)  {  
////         for (j = 0; j < vertices; j++)    
////            printf("%u  ",graph[vertices*i+j]);  
////         printf("\n");  
////      }  
////      printf("minimum vzálenost:\n");  
////      for (i = 1; i < vertices; i++)  
////         printf("%u\n",minDistance[i]);         
//  return (EXIT_SUCCESS);
//} 
//
//void init()  
//{  int j;  
//    FILE *ftp;
//    char *delim = " ";
//    char **tokens = NULL;
//    int mattrix[MAXTOKENS][MAXTOKENS];   
//    char line[MAXLINE];
//    int i = 0, lcount = 0;
//    
//    if ((ftp = fopen("Test240.txt","r")) == NULL){
//        printf("nepodařilo se otevřít soubor... \n");
//        return;
//    }
//        while(fgets(line, MAXLINE, ftp) != NULL) {         
////        printf("== line: %d\n", lcount);
//        tokens = split(line, delim);
//        for(i = 0; tokens[i] != NULL; i++){
//        mattrix[lcount][i] = atoi(tokens[i]);  
////        printf("%02d: %d\n", i, mattrix[lcount][i]);
//        }
//        lcount++;
//        for(i = 0; tokens[i] != NULL; i++)
//        free(tokens[i]);
//        free(tokens);
//        }       
//        fclose(ftp);
// 
//   vertices = lcount;  
//   graph = malloc(vertices*vertices*sizeof(int));  
//   minDistance = malloc(vertices*sizeof(int));  
//   flag = malloc(vertices*sizeof(int)); 
//   printf("Vertice %d\n",vertices );
//        
//    for (i = 0; i < vertices; i++)    
//      for (j = i; j < vertices; j++)  {           
//            graph[vertices*i+j] = mattrix[i][j];
//            graph[vertices*j+i] = mattrix[i][j];
////            printf("Pole graph %d\n",graph[vertices*i+j] );
//      } 
// 
//   for (i = 1; i < vertices; i++)  {  
//      flag[i] = 1;  
//      minDistance[i] = graph[i];  
//   }  
//}  
//  
//// nalezení nejbližší vzdálenosti k 0 mezi neprošlými vrcholy od s do e  
//void findThreadMinimum(int s, int e, unsigned *d, int *v)  
//{  int i;  
//   *d = largeint;   
//   for (i = s; i <= e; i++)  
//      if (flag[i] && minDistance[i] < *d)  {  
//         *d = graph[i];  
//         *v = i;  
//      }  
//}  
//  
//// zjistit, zdali existuje for each i ze [s,e], kratší cesta do i přes minimální vrchol  
//void updateminDistance(int s, int e)  
//{  int i;  
//   for (i = s; i <= e; i++)  
//      if (minDistance[minimumVertex] + graph[minimumVertex*vertices+i] < minDistance[i])    
//         minDistance[i] = minDistance[minimumVertex] + graph[minimumVertex*vertices+i];  
//}  
//  
//void dowork()  
//{    
//   #pragma omp parallel num_threads(8)  
//   {  int firstVertex,lastVertex,  // počáteční a konečný vrchol pro vlákno  
//          step,  // inkrement 
//          threadMinVertex,  // vrchol, který dosáhl minima v části programu náležícímu jednomu vláknu  
//          me = omp_get_thread_num();    
//          unsigned threadMinValue;  // min hodnota nalezená v tomto vláknu 
//      #pragma omp single     
//      {  threadsNum = omp_get_num_threads();  
//         printf("počet vrcholů %d\n", threadsNum);
//         if (vertices % threadsNum != 0) {  
//            printf("vrcholy musí být dělitelné počtem vláken\n");  
//            exit(1);  
//         }  
//         chunk = vertices/threadsNum;    
//         printf("v procesu běží %d vláken\n",threadsNum);    
//      }  
//      firstVertex = me * chunk;   
//      lastVertex = firstVertex + chunk - 1;  
//      for (step = 0; step < vertices; step++)  {  
//         // nalezení vrcholu nejbližšímu k 0 mezi neprošlými vrcholy; každé vlákno nalezne nejbližší   
//         // ve své sekci, poté nacházejí nejbližší k 0 mezi všemi vrcholy  
//         #pragma omp single   
//         {  minimum = largeint; minimumVertex = 0;  }  
//         findThreadMinimum(firstVertex,lastVertex,&threadMinValue,&threadMinVertex);  
//         // update overall min if mine is smaller  
//         #pragma omp critical    
//         {  if (threadMinValue < minimum)    
//               {  minimum = threadMinValue; minimumVertex = threadMinVertex;  }  
//         }  
//         #pragma omp barrier   
//         // označení nového vrcholu jako konečného  
//         #pragma omp single   
//         {  flag[minimumVertex] = 0;  }  
//         // update sekce  
//         updateminDistance(firstVertex,lastVertex);  
//         #pragma omp barrier   
//         }  
//   }  
//}  
//  
//
//
///* rosekání řetězce na tokeny */
// char **split(char *string, char *delim) {
// char **tokens = NULL;
// char *working = NULL;
// char *token = NULL;
// int idx = 0;
//
// tokens  = malloc(sizeof(char *) * MAXTOKENS);
// if(tokens == NULL)
//        return NULL;
// working = malloc(sizeof(char) * strlen(string) + 1);
// if(working == NULL)
//        return NULL;
//
// /* to make sure, copy string to a safe place */
// strcpy(working, string);
// for(idx = 0; idx < MAXTOKENS; idx++)
//        tokens[idx] = NULL;
//
// token = strtok(working, delim);
// idx = 0;
//
// /* always keep the last entry NULL terminDistanceated */
// while((idx < (MAXTOKENS - 1)) && (token != NULL)) {
//        tokens[idx] = malloc(sizeof(char) * strlen(token) + 1);
//                if(tokens[idx] != NULL) {
//                        strcpy(tokens[idx], token);
//                        idx++;
//                        token = strtok(NULL, delim);
//                }
// }
// free(working);
// return tokens;
//}
// 