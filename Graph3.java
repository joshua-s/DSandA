package graph;

public class Graph3 {
	int n;
	int[][] A;
	int[] d;	//shortest distance
	/**
	 * @param args
	 */
	
	public Graph3 () {
		
	}
	
	public Graph3 (int _n, int[][] _A) {
		n = _n;
		A = _A;
		d = new int[n];
	}
	
	public void initialize_single_source(int s) {
		for (int i = 0; i < n; i++)
			d[i] = Integer.MAX_VALUE;
		d[s] = 0;
	}
	
	public void relax (int u, int v) {
		if (d[v] > (d[u] + A[u][v])) 
			d[v] = d[u] + A[u][v];
	}
	
	public boolean bellman_ford (int s) {
		//fill in your code
		initialize_single_source(s); //call the method initialize_single_source()
		int verticen = A.length;
		for(int i = 1; i <= verticen - 1; i++) {
			for(int u = 0; u <= verticen - 1; u++) {
				for (int v = 0; v <= verticen -1; v++) {
					if(A[u][v] != 0) {
						relax(u, v);
					}
				}
			}
		}
	for (int u = 0; u <= verticen - 1; u++)
	{
		for (int v = 0; v <= verticen - 1; v++) {
			if(A[u][v] != 0) {
				if(d[v] > d[u] + A[u][v]) {
					System.out.println("The Graph contains a negative edge cycle");
					return false;
				}
			}
		}
	}
	return true;
}
		
	public void dijkstra (int s) {
		initialize_single_source(0);
		int VerticeN = A.length;
		int vis[] = new int[VerticeN];
		for(int i = 0; i < VerticeN; i++) {
			vis[i] = 0;
		}
		for(int count = 0; count < VerticeN - 1; count++) {
			//loop finds the minimum distance vertex from the set of vertices. 
				int min = Integer.MAX_VALUE, 
				u = 0;
			for (int v = 0; v < VerticeN; v++)
				if(vis[v] == 0 && d[v] <= min) {
					min = d[v]; 
					v = u;
			}
				vis[u] = 1;
				//makes sure that the vertex visited is picked
				for (int v = 0; v < VerticeN; v++) {
					if (vis[v] == 0 && A[u][v] > 0 && d[u] != Integer.MAX_VALUE && d[u] + A[u][v] < d[v]) {
						d[v] = d[u] + A[u][v];
					}
				}
		}
	}
		
	public void display_distance () {
		for (int i = 0; i < n; i++)
			System.out.println(i + ": " + d[i]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] A = {
		{0, 6, 0, 7, 0},
		{0, 0, 5, 8, -4},
		{0, -2, 0, 0, 0},
		{0, 0, -3, 0, 9},
		{2, 0, 7, 0, 0}
		};
		Graph3 g1 = new Graph3(n, A);
		g1.bellman_ford(0);
		g1.display_distance();
		
		System.out.println("-----------------------");
		
		int[][] B = {
		{0, 10, 0, 5, 0},
		{0, 0, 1, 2, 0},
		{0, 0, 0, 0, 4},
		{0, 3, 9, 0, 2},
		{7, 0, 6, 0, 0}
		};
		Graph3 g2 = new Graph3(n, B);
		g2.dijkstra(0);
		g2.display_distance();
	}

}
