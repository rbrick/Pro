package me.rbrickis.pro.compiler;

import me.pogostick29dev.pro.block.Class;

import java.io.IOException;

/**
 * Created by Ryan on 1/16/2015
 * <p/>
 * Project: Pro
 */
public class Main {

    public static void main(String... args) throws IOException {
        Class clazz = new Class("Test");

        Compiler compiler = new Compiler(clazz);
        byte[] compiled = compiler.compileClass();
        System.out.write(compiled);
    }
}
