package me.rbrickis.pro.compiler;

import me.pogostick29dev.pro.block.Block;
import me.pogostick29dev.pro.block.Class;
import me.pogostick29dev.pro.block.Method;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

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


    public void compileMethod(Method method) {

        int type = 0;

        switch (method.getType()) {
            case INTEGER:
                type = Type.INT;
                break;
            case STRING:
                type = Type.OBJECT;
                break;
            case VOID:
                type = Type.VOID;
                break;
            default:
                type = Type.VOID;
                break;
        }


        MethodVisitor mv = writer.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, method.getName(), "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0);

        mv.visitInsn(Opcodes.RETURN);

        mv.visitEnd();


    }

    public byte[] compileClass() {
        writer.visit(49, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, clazz.getName(), null, "java/lang/Object", null);
        writer.visitSource(clazz.getName() + ".java", null);

        for(Block block : blocks) {
            if(block instanceof Method) {
                compileMethod((Method) block);
            }
        }

        writer.visitEnd();

        return writer.toByteArray();
    }

}
