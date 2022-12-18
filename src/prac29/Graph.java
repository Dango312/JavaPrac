package prac29;

import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] graph = new int[n][n];
        int roadsCount = 0;
        for(int i = 0; i < n; i++){
            String[] strGraph = sc.nextLine().split(" ");
            for(int j = 0; j<strGraph.length; j++){
                graph[i][j] = Integer.parseInt(strGraph[j]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j<n;j++){
                if(graph[i][j] != 0){
                    roadsCount++;
                }
            }
        }
        System.out.println(roadsCount);

    }
}