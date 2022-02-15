package codeforces.c771;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BOddSwapSort {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        List<Integer> o = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (a % 2 == 0) {
                o.add(a);
            } else {
                e.add(a);
            }
        }
        for (int i = 0; i < o.size() - 1; i++) {
            if (o.get(i) > o.get(i + 1)) {
                out.println("No");
                return;
            }
        }
        for (int i = 0; i < e.size() - 1; i++) {
            if (e.get(i) > e.get(i + 1)) {
                out.println("No");
                return;
            }
        }
        out.println("Yes");
    }
}
