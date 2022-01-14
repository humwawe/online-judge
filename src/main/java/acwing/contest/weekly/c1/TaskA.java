package acwing.contest.weekly.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskA {
    // 可以直接取两个数组的最大值
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : a) {
            set1.add(i);
        }
        for (int i : b) {
            set2.add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = a[i] + b[j];
                if (!set1.contains(tmp) && !set2.contains(tmp)) {
                    out.println(a[i] + " " + b[j]);
                    return;
                }
            }
        }

    }
}
