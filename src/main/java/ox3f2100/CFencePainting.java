package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CFencePainting {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = in.nextIntArray(n);
        int[] b = in.nextIntArray(n);
        int[] c = in.nextIntArray(m);
        int last = -1;
        Map<Integer, List<Integer>> need = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                need.computeIfAbsent(b[i], k -> new ArrayList<>()).add(i);
            }
        }
        if (need.containsKey(c[m - 1])) {
            List<Integer> list = need.get(c[m - 1]);
            last = list.get(list.size() - 1);
        } else {
            for (int i = 0; i < n; i++) {
                if (b[i] == c[m - 1]) {
                    last = i;
                    break;
                }
            }
        }
        if (last == -1) {
            out.println("NO");
            return;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (need.containsKey(c[i])) {
                res.add(need.get(c[i]).remove(0));
                if (need.get(c[i]).size() == 0) {
                    need.remove(c[i]);
                }
            } else {
                res.add(last);
            }
        }
        if (need.size() == 0) {
            out.println("YES");
            for (Integer i : res) {
                out.print(i + 1 + " ");
            }
            out.println();
        } else {
            out.println("NO");
        }
    }
}
