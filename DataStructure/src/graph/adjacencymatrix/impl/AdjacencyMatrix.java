package graph.adjacencymatrix.impl;

//	그래프를 행렬로 표현 https://wonit.tistory.com/208?category=758730
//	특정 정점에 한 번에 접근할 수 있음. 
public class AdjacencyMatrix {

	private int[][] adjMatrix;
	private int vertex;

	public AdjacencyMatrix(int vertex) {
		this.vertex = vertex;
		adjMatrix = new int[vertex][vertex];
	}

	public void addEdge(int vertex1, int vertex2) {
		adjMatrix[vertex1][vertex2] = 1;
		adjMatrix[vertex2][vertex1] = 1;
	}

	public void removeEdge(int vertex1, int vertex2) {
		adjMatrix[vertex1][vertex2] = 0;
		adjMatrix[vertex2][vertex1] = 0;
	}
	
	public int getVertex() {
		return vertex;
	}
	
}
