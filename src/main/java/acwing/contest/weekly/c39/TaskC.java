package acwing.contest.weekly.c39;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskC {
    int N = (int) (2e5 + 5);
    int[] p = new int[N];
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextString();
        }
        for (int i = 1; i < n; i++) {
            p[i] = i;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a[i].indexOf(c) != -1) {
                    list.add(i);
                }
            }
            for (int i = 1; i < list.size(); i++) {
                union(list.get(i), list.get(i - 1));
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (find(p[i]) == i) {
                res++;
            }
        }
        out.println(res);

    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }
        p[find(a)] = find(b);
    }
}
