package dp;

public class LCS {
	
	public static int lcs_length (String X, String Y) {
		int m, n;
		char[] x = X.toCharArray();
		m = x.length;
		char[] y = Y.toCharArray();
		n = y.length;
		return lcs_l(x, y, m, n);
		}
		
	private static int lcs_l(char[] x, char[] y, int m, int n) {
		if ( m == 0 || n == 0)
			return 0;
		if (x[m - 1] == y[n - 1])
			return 1 + lcs_l(x ,y, m - 1, n- 1);
		else
			return Math.max(lcs_l(x, y, m, n - 1), lcs_l(x, y, m -1, n));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LCS.lcs_length("ABCBDAB", "BDCABA"));
		System.out.println(LCS.lcs_length("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA"));
	}

}
