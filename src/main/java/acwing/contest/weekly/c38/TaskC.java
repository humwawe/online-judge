package acwing.contest.weekly.c38;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
    int n;
    int sum;
    int[] a;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextCharacter() - '0';
        }
        for (int i = n - 1; i >= 2; i--) {
            if (a[i] == 0) {
                n--;
            } else {
                break;
            }
        }
        sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += a[i];
            if (dfs(i + 1, 0)) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");
    }

    private boolean dfs(int i, int cur) {
        if (i == n) {
            return cur == sum;
        }
        if (cur == sum) {
            return dfs(i + 1, a[i]);
        } else {
            if (cur + a[i] > sum) {
                return false;
            }
            return dfs(i + 1, cur + a[i]);
        }
    }
}
