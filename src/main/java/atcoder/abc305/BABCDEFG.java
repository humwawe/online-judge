package atcoder.abc305;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class BABCDEFG {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('A', 0);
    map.put('B', 3);
    map.put('C', 4);
    map.put('D', 8);
    map.put('E', 9);
    map.put('F', 14);
    map.put('G', 23);
    char p = in.nextCharacter();
    char q = in.nextCharacter();
    out.println(Math.abs(map.get(p) - map.get(q)));
  }


}
