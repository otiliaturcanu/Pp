import org.graalvm.polyglot.*;

import java.io.File;
import java.io.IOException;

class Polyglot {
    private static int Nraruncari;
    private static int x;

    private static double Probabilitate(Context polyglot) throws IOException {
        Source rSource = Source.newBuilder("R", new File("src/process.r")).build();

        polyglot.getBindings("R").putMember("x", x);
        polyglot.getBindings("R").putMember("Nraruncari", Nraruncari);

        Value result = polyglot.eval(rSource);

        return result.asDouble();
    }


    private static void Citire(Context polyglot) throws IOException {
        Source pythonSource = Source.newBuilder("python", new File("src/citire.py")).build();

        Value result = polyglot.eval(pythonSource);
        Nraruncari = result.getArrayElement(0).asInt();
        x = result.getArrayElement(1).asInt();
        System.out.println(Nraruncari);
        System.out.println(x);

    }

    public static void main(String[] args) throws IOException {
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();

        Citire(polyglot);
        double prob = Probabilitate(polyglot);
        //System.out.println(prob);
        polyglot.close();
    }
}

