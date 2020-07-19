package fast.io;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author hum
 */
public class FastWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) throws IOException {
        writer.write(object.toString());
    }

    public void println(Object object) throws IOException {
        writer.write(object.toString());
        writer.write("\n");
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
