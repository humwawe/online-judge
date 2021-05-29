package acwing.contest.weekly.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
    // 可以二分最后的值
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = in.nextIntArray(n);
        Arrays.sort(a);
        int x = n / 2;
        int y = 1;
        while (x + 1 < n && (long) (a[x + 1] - a[x]) * y <= k) {
            k -= (a[x + 1] - a[x]) * y;
            y++;
            x++;
        }
        out.println(a[x] + k / (x - n / 2 + 1));
    }
}
