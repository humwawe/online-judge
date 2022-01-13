package codeforces.c765;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class BElementaryParticles {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (map.containsKey(t)) {
                int prev = map.get(t);
                res = Math.max(res, prev + n - i);
            }
            map.put(t, i);
        }
        out.println(res);
    }
}
