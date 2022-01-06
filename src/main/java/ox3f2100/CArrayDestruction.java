package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class CArrayDestruction {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int len = n * 2;
        int[] a = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            a[i] = in.nextInt();
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        Arrays.sort(a);
        f:
        for (int i = 0; i < len - 1; i++) {
            int max = a[len - 1];
            List<Integer> res = new ArrayList<>();
            Map<Integer, Integer> cnt = new HashMap<>(map);

            res.add(max + a[i]);
            res.add(max);
            res.add(a[i]);
            cnt.put(max, cnt.get(max) - 1);
            cnt.put(a[i], cnt.get(a[i]) - 1);

            for (int j = len - 2; j >= 0; j--) {
                if (cnt.get(a[j]) > 0) {
                    res.add(a[j]);
                    cnt.put(a[j], cnt.get(a[j]) - 1);
                    if (!cnt.containsKey(max - a[j]) || cnt.get(max - a[j]) <= 0) {
                        continue f;
                    }
                    res.add(max - a[j]);
                    cnt.put(max - a[j], cnt.get(max - a[j]) - 1);
                    max = a[j];
                }
            }
            out.println("YES");
            out.println(res.get(0));
            for (int j = 1; j < res.size(); j += 2) {
                out.println(res.get(j) + " " + res.get(j + 1));
            }
            return;
        }
        out.println("NO");

    }
}
