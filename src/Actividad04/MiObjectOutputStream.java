
package Actividad04;
import java.io.*;
class MiObjectOutputStream extends ObjectOutputStream {
public MiObjectOutputStream(OutputStream out) throws IOException {
super(out);
}
@Override
protected void writeStreamHeader() throws IOException {
// No escribir cabecera
reset();
}
}