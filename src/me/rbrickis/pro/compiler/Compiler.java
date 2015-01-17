package me.rbrickis.pro.compiler;

import me.pogostick29dev.pro.block.Block;
import me.pogostick29dev.pro.block.Class;
import me.pogostick29dev.pro.block.Method;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * Created by Ryan on 1/16/2015
 * <p/>
 * Project: Pro
 */
public class Compiler {

    Class clazz;

    Block[] blocks;

    ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
    public Compiler(Class clazz) {
         this.clazz = clazz;
         this.blocks = clazz.getSubBlocks();
    }


    public void compile() {
        compileClass();
    }


    public void compileForLoop() {
        // TODO
    }

    public void compileMethod(Method method) {

    }

    public byte[] compileClass() {
        writer.visit(49, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, clazz.getName(), null, "java/lang/Object", null);
        writer.visitSource(clazz.getName() + ".java", null);
        writer.visitEnd();
        return writer.toByteArray();
    }

}
