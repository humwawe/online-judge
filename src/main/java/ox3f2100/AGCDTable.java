package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AGCDTable {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n * n; i++) {
            int a = in.nextInt();
            treeMap.put(a, treeMap.getOrDefault(a, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        while (!treeMap.isEmpty()) {
            Integer p = treeMap.lastKey();
            treeMap.put(p, treeMap.get(p) - 1);
            if (treeMap.get(p) == 0) {
                treeMap.remove(p);
            }
            for (Integer q : res) {
                int g = gcd(p, q);
                treeMap.put(g, treeMap.get(g) - 2);
                if (treeMap.get(g) == 0) {
                    treeMap.remove(g);
                }
            }
            res.add(p);
        }
        for (Integer i : res) {
            out.print(i + " ");
        }
        out.println();
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
