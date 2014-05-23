import java.io.OutputStream;
import java.io.ObjectOutput;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInput;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.InputStream;
import java.io.Serializable;

public class MySerializer
{
    public void serialize(Serializable target) throws Exception {
        OutputStream os = new FileOutputStream("exam_ser_test.txt");
        ObjectOutput oo = new ObjectOutputStream(os);
        oo.writeObject(target);
        oo.close();
    }

    public Object deserialize() throws Exception {
        InputStream is = new FileInputStream("exam_ser_test.txt");
        ObjectInput oi = new ObjectInputStream(is);
        Object obj = oi.readObject();
        oi.close();
        return obj;
    }
}