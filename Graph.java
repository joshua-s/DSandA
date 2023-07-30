package graph;

public class Graph
{

  public int n;

  public int[][] A;

  private final int WHITE = 2;
  private final int GRAY = 3;
  private final int BLACK = 4;

  public Graph () {
    n = 0;
    A = null;
  }

  public Graph (int _n, int[][]_A){
    this.n = _n;
    this.A = _A;
  }
  
  public int[] bfs (int s1) {
    int frontvalue = 0;
    int rearvalue = 0;
    int[][] que = new int[n][2];
    boolean[]vis = new boolean[n];
    vis[s1] = true;
    que[rearvalue][0] = s1;
    que[rearvalue++][1] = 0;
    int[] dis = new int[n];
    dis[s1] = 0;
    while (frontvalue != rearvalue)
      {
	int inde = que[frontvalue][0];
	for (int i1 = 0; i1 < n; i1++)
	  {
	    if (!vis[i1] && A[inde][i1] == 1)
	      {
		vis[i1] = true;
		que[rearvalue][0] = i1;
		que[rearvalue][1] = que[frontvalue][1] + 1;
		dis[i1] = que[rearvalue][1];
		rearvalue++;
	      }
	  }
	frontvalue++;
      }
    return dis;
  }
  public void print_array (int[]array)
  {
    for (int i = 0; i < array.length; i++)
      System.out.println (i + ": " + array[i]);
  }
  public static void main (String[]args)
  {
    int n = 8;
    int[][] A = { 
	    {0, 1, 0, 0, 1, 0, 0, 0},
	    {1, 0, 0, 0, 0, 1, 0, 0},
	    {0, 0, 0, 1, 0, 1, 1, 0},
	    {0, 0, 1, 0, 0, 0, 1, 1},
	    {1, 0, 0, 0, 0, 0, 0, 0},
	    {0, 1, 1, 0, 0, 0, 1, 0},
	    {0, 0, 1, 1, 0, 1, 0, 1},
	    {0, 0, 0, 1, 0, 0, 1, 0}
    };
    Graph g = new Graph (n, A);
    g.print_array (g.bfs (0));
  }
}
