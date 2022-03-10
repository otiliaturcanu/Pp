import org.graalvm.polyglot.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Polyglot {
    private static void Plotare(Context polyglot, Value x,Value y) throws IOException {
        Source rSource = Source.newBuilder("R", new File("src/process.r")).build();
        Scanner sc = new Scanner(System.in);
        String location = sc.nextLine();
        String name = sc.nextLine();
        polyglot.getBindings("R").putMember("x", x);
        polyglot.getBindings("R").putMember("y", y);
        polyglot.getBindings("R").putMember("name", name);
        polyglot.getBindings("R").putMember("location", location);
        Value result = polyglot.eval(rSource);


    }



    public static void main(String[] args) throws IOException {
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();

        Source jsSource = Source.newBuilder("python", new File("src/input.py")).build();

        Value array = polyglot.eval(jsSource);
        //System.out.println(array.getArrayElement(0).getArrayElement(1));2
        Value x = array.getArrayElement(0);
        Value y = array.getArrayElement(1);
        System.out.println(x);
        System.out.println(y);
        Plotare(polyglot,x,y);
            //String element = array.getArrayElement(i).asString();


        polyglot.close();
    }
}

