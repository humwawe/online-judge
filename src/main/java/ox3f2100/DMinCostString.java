package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DMinCostString {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append((char) ('a' + i));
            for (int j = i + 1; j < k; j++) {
                stringBuilder.append((char) ('a' + i));
                stringBuilder.append((char) ('a' + j));
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(stringBuilder.charAt(i % stringBuilder.length()));
        }
        out.println();
    }


}
