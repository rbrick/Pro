package me.rbrickis.pro.compiler;

import me.pogostick29dev.pro.Type;
import me.pogostick29dev.pro.block.Class;
import me.pogostick29dev.pro.block.Method;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Ryan on 1/16/2015
 * <p/>
 * Project: Pro
 */
public class Main {

    public static void main(String... args) throws IOException {
        Class clazz = new Class("Test");

        Method method = new Method(clazz, "test", Type.VOID, null);

        clazz.addBlock(method);

        Compiler compiler = new Compiler(clazz);
        byte[] compiled = compiler.compileClass();
        FileOutputStream stream = new FileOutputStream("Test.class");

        stream.write(compiled);

        stream.close();

    }
}
