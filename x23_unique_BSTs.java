public class x23_unique_BSTs {
 public static void main(String[] args) {
  int n = 7;
  System.out.println(numTrees(n));
 }

 public static int numTrees(int n) {
  int dp[] = new int[n + 2];

  dp[0] = 1;
  dp[1] = 1;

  // Fill entries in catalan[]
  // using recursive formula
  for (int i = 2; i <= n; i++) {
   dp[i] = 0;
   for (int j = 0; j < i; j++) {
    dp[i] += dp[j] * dp[i - j - 1];
   }
  }

  // Return last entry
  return dp[n];
 }

}
