package codeforces.cgr19;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class EBestPair {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, Integer> cnt = new HashMap<>();
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            set.add((a * (long) 1e9 + b));
            set.add((b * (long) 1e9 + a));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> kv : cnt.entrySet()) {
            map.computeIfAbsent(kv.getValue(), x -> new ArrayList<>()).add(kv.getKey());
        }
        for (List<Integer> value : map.values()) {
            value.sort((x, y) -> y - x);
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            List<Integer> list1 = map.get(i);
            if (list1 == null) {
                continue;
            }
            for (int x : list1) {
                for (int j = 1; j <= i; j++) {
                    List<Integer> list2 = map.get(j);
                    if (list2 == null) {
                        continue;
                    }
                    for (int y : list2) {
                        if (x != y && !set.contains(x * (long) 1e9 + y)) {
                            res = Math.max(res, (long) (i + j) * (x + y));
                            break;
                        }
                    }
                }
            }
        }
        out.println(res);

    }
}
