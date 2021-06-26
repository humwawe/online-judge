package acwing.contest.weekly.c5;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] cnt = new int[64];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long x = in.nextLong();
            for (int j = 0; j < 64 && x > 0; j++) {
                cnt[j] += x % k;
                x /= k;
            }
        }
        for (int value : cnt) {
            if (value > 1) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }
}
