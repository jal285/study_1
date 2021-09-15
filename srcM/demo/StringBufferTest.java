package demo;

/**
 * @author badpoone
 * 线程安全
 */
public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer sBuffer = new StringBuffer("菜鸟学StringBuffer: ");
        sBuffer.append("fafa");
        sBuffer.append(".fafa");
        sBuffer.append(" is really");
        System.out.println(sBuffer);

    }
}
