package algo;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultDijsktra {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
		
    	if (edges.size() < n) {
    		int size = n - edges.size();
    		for (int i =0; i <size; i ++) {
    			ArrayList<Integer> ints = new ArrayList<Integer>(
    		            Arrays.asList(0, 0, 0));
    			edges.add(ints);
    		}
    	}
    	//converting input matrix to required format for searching
    	int [][] edges_zero_based = new int [n][n];
    	int adjMat1 [][] = new int [n][n];
    	for (int i =0; i <edges.size(); i ++) {
    		for (int j =0; j < 3; j ++) {
    			if (j == 2) {
    				adjMat1[i][j] = edges.get(i).get(j);
    			}else {
    				if(edges.get(i).get(j) != 0)
    					adjMat1[i][j] = edges.get(i).get(j) -1;
    			}
    		}
    	}
    	
    	for (int i = 0; i < adjMat1.length; i++) {
			int from = adjMat1[i][0];
			int to = adjMat1[i][1];
			edges_zero_based[from][to] = adjMat1[i][2];
			edges_zero_based[to][from] = adjMat1[i][2];
} 
    	
		for (int i = 0; i < edges_zero_based.length; i++) {
			for (int j = 0; j < edges_zero_based.length; j++) {
				System.out.print(edges_zero_based[i][j] + " ");
			}
			System.out.println();
		}
    	
    	// creating a distance array to keep a note of distance of vertex from source
		int[] distance = new int[edges_zero_based.length];
		// taking source vertex to be 0
		int source = s-1;

		// creating a visited array to keep a count of visited vertices.
		boolean[] visited = new boolean[edges_zero_based.length];

		// marking distance of source vertex
		distance[source] = s-1;

		// filling up other distance in array "distance" as infinity or the max value
		for (int i = 0; i < edges_zero_based.length; i++) {
			if (i == source)
				continue;
			distance[i] = Integer.MAX_VALUE;
		}
		
		// finding the vertex that is most close to current node or source
		for (int i = 0; i < edges_zero_based.length; i++) {
			int minDistVertex = findMinDistVertex(distance, visited);

			// marking the vertex that is most close to source/current vertex as true
			visited[minDistVertex] = true;

			// exploring the neighbors of each vertex and updating distance array with new
			// distance
			for (int j = 0; j < edges_zero_based.length; j++) {
				if (edges_zero_based[minDistVertex][j] != 0 && visited[j] == false
						&& distance[minDistVertex] != Integer.MAX_VALUE) {
					int newDist = distance[minDistVertex] + edges_zero_based[minDistVertex][j];
					if (newDist < distance[j]) {
						distance[j] = newDist;
					}
				}
			} 
		}
		
		for (int j = 0; j < distance.length; j++) {
			if (distance[j] == Integer.MAX_VALUE)
				distance[j] = -1;
		}
		
    	return Arrays.stream(distance)
    			  .filter(i -> i != 0)
    		      .boxed()
    		      .collect(Collectors.toList());
    }
    
	public static int findMinDistVertex(int[] distance, boolean[] visited) {

		int minVertex = -1;

		// traversing through the distance array and finding the least distance vertex
		// whose visited is also false
		for (int i = 0; i < distance.length; i++) {
			if (visited[i] == false && (minVertex == -1 || distance[i] < distance[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

}

public class SolutionDijsktra {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = ResultDijsktra.shortestReach(n, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
