
package Pgm1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Wafa M Yakhlif
 * 
 *
 */
public class solveVertexCover {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = args[0];
		Scanner inLine = new Scanner(new File("graphs18.txt"));
		int input =0;
		while(inLine.hasNextInt()) {
			//Getting the number of vertices
			int V = inLine.nextInt();
			//make sure the graph has elements
			if(V!=0){
				int[][] graph = new int[V][V];
				//filling up the graph matrix
				for(int i =0;i<V;i++){
					for(int j =0;j<V;j++){
						graph[i][j]=inLine.nextInt();						
					}
				}
				System.out.print("{");
				solve(graph,V);
				System.out.println("}");
			}
		}
	}
	public static int[] solve(int[][] graph,int V) {
		int vertexCover[] = new int[100];
		int counter = 0;
		int z =0;
		int [][] s1 = solved(V);
		while(!Arrays.equals(graph, s1)) {
			int rmvNum = maxLine(graph,V);
			if(rmvNum==0){
				z++;
				if(z>1) {
					break;
				}
			}
			System.out.print(rmvNum+" ");
			vertexCover[counter]=rmvNum;
			counter++;
			for(int i =0;i<V;i++){
				graph[i][rmvNum]=0;
				graph[rmvNum][i]=0;
			}
			graph[rmvNum][rmvNum]=1;
		}
		return vertexCover;
	}
	//RETURNS LINE WITH HIGHEST COUNT
	public static int maxLine(int[][]graph,int V) {
		int result = 0;
		int max = 0;
		int temp = 0;
		for(int i =0;i<V;i++){
			for(int j =0;j<V;j++){
				if(graph[i][j]==1) {
					temp++;
				}
			}
			if(temp>max) {
				max = temp;
				result = i;
			}
			temp =0;
		}
		return result;
	}
	//returns a graph int a solved stated of size v
	public static int[][] solved(int V){
		int s[][] = new int[V][V];
		for(int i =0;i<V;i++){
			for(int j =0;j<V;j++){
				s[i][j]=0;
			}
		}
		for(int i=0;i<V;i++){
			s[i][i]=1;
		}
		return s;
	}

}
