package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AVitalyAndStrings {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString();
        String t = in.nextString();
        int len = s.length();
        int b = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            char nc = (char) (c + b);
            if (nc > 'z') {
                nc = 'a';
                b = 1;
            } else {
                b = 0;
            }
            stringBuilder.insert(0, nc);
        }
        if (b == 1 || stringBuilder.toString().equals(t)) {
            out.println("No such string");
        } else {
            out.println(stringBuilder.toString());
        }
    }
}
