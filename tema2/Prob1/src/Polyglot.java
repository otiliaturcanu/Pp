import org.graalvm.polyglot.*;

import java.io.File;
import java.io.IOException;

class Polyglot {
    private static String RToUpper(Context polyglot, String token) throws IOException {
        Source rSource = Source.newBuilder("R", new File("src/process.r")).build();

        polyglot.getBindings("R").putMember("token", token);

        Value result = polyglot.eval(rSource);

        return result.asString();
    }

    private static int SumCRC(Context polyglot, String token) throws IOException {
        Source pythonSource = Source.newBuilder("python", new File("src/process.py")).build();

        polyglot.getBindings("python").putMember("token", token);

        Value result = polyglot.eval(pythonSource);

        return result.asInt();
    }
    private static void SumeEgale(Context polyglot, String[] cuvinte, int[] sume) throws IOException {
        Source pythonSource = Source.newBuilder("python", new File("src/sumegale.py")).build();

        polyglot.getBindings("python").putMember("cuvinte", cuvinte);
        polyglot.getBindings("python").putMember("suma", sume);

        Value result = polyglot.eval(pythonSource);


    }

    public static void main(String[] args) throws IOException {
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();

        Source jsSource = Source.newBuilder("js", new File("src/input.js")).build();

        Value array = polyglot.eval(jsSource);
        String[] Upperarray = new String[(int)array.getArraySize()];
        int[] Sume = new int[(int)array.getArraySize()];
        for (int i = 0; i < array.getArraySize();i++){
            String element = array.getArrayElement(i).asString();
            String upper = RToUpper(polyglot, element);
            int crc = SumCRC(polyglot, upper);
            Upperarray[i] = upper;
            Sume[i] = crc;

            System.out.println(upper + " -> " + crc);
        }
        SumeEgale(polyglot,Upperarray,Sume);

        polyglot.close();
    }
}

