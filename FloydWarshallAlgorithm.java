//Joshua Sepulveda
//CSIT-212
//Dr. Boxiang Dong
//Final Project (12/20/2003)
public class FloydWarshallAlgorithm
    { private final static int infinity = 999999999;
        public static void main(String[] args)
        {
            int[][] AJMatrix =
                            {{0, 3, 8, infinity, -4},
                            {infinity, 0, infinity, 1, 7},
                            {infinity, 4, 0, infinity, infinity},
                            {2, infinity, -5, 0, infinity},
                            {infinity, infinity, infinity, 6, 0}
                            };
            int[][] sDistance = Floyd_Warshall(AJMatrix);
            System.out.println("The adjacent distance of matrices is: ");
            showDistances(AJMatrix);
            System.out.println("\n\nPairwise of shortest distances is");
            showDistances(sDistance);
        }
    public static int[][] Floyd_Warshall(int[][] w)
    {
        int n = w.length;
        int d[][] = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                d[i][j] = w[i][j];
            }
        }
        for(int k = 0; k < n; k++)
        {
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if (d[i][k] + d[k][j] < d[i][j])
                        d[i][j] = d[i][k] + d[k][j];
                }
            }
        }
        return d;
    }
    public static void showDistances(int[][] d)
    {
        int n = d.length;
        for(int i = 0; i < n; i++)
            System.out.print("\t" + (i + 1));
        System.out.println("\n |----------------------------------------");
        for(int i = 0; i < n; i++)
        {
            System.out.print((i + 1) + " | ");
            for(int j = 0; j < n; j++)
            {
                if(d[i][j] == infinity)
                    System.out.print( "\tinfinity");
                else
                    System.out.print( "\t" + d[i][j]);
            }
            System.out.println();
        }
    }
}