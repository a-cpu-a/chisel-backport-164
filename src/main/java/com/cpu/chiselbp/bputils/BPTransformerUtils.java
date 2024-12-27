package com.cpu.chiselbp.bputils;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.*;

import java.util.*;

import static org.objectweb.asm.Opcodes.*;

/*

//using in the real world:

    @Override
    public String[] getASMTransformerClass() {

        return new String[]{
                //utils
                BPTransformerUtils.class.getName(),BPTransformerUtils.BPReplaceGetStatic.class.getName(),
                BPTransformerUtils.BPReplaceNew.class.getName(),BPTransformerUtils.BPRenameMethod.class.getName(),
                BPTransformerUtils.BPAddDefaultConstructor.class.getName(),

                ChiselBPAccessTweaker.class.getName(),ChiselBPTransformer.class.getName()};
    }

jar {
    manifest {
        attributes(
                'Created-By': '1.7.0 (Oracle Corporation)',
                'FMLCorePlugin': 'com.cpu.chiselbp.ChiselBPCoreMod',
                'FMLCorePluginContainsFMLMod': '1'
            )
    }
}
*/

public class BPTransformerUtils {

    public interface BPAsmAction {
        byte[] tryTransform(String name, byte[] bytecode);
    }

    public static ArrayList<BPAsmAction> actions = new ArrayList<>();
    public static Map<BPAsmAction,Map<String,Integer>> modifiedMaps = new HashMap<>();

    public static class BPReplaceGetStatic implements BPAsmAction{

        public String clazz;//                 not.my.Class
        public String methodName;//            not_my_func
        public String methodDesc;//            ()I

        public String varFromClass;//          not/my/Class
        public String varName;//               notMyVar
        public String varDesc;//               I

        public String newVarFromClass;//       my/Class
        public String newVarName;//            myVar
        public String newVarDesc;//            I

        public byte[] tryTransform(String name, byte[] bytecode)
        {
            if(!name.equals(clazz))
                return null;

            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(bytecode);
            classReader.accept(classNode, 0);

            for (MethodNode m : (Iterable<MethodNode>) classNode.methods) {
                if ((m.name.equals(methodName)||methodName==null)
                        && m.desc.equals(methodDesc)) {
                    Iterator<AbstractInsnNode> iter = m.instructions.iterator();
                    while (iter.hasNext())
                    {
                        AbstractInsnNode currentNode = iter.next();
                        if (currentNode.getOpcode() == GETSTATIC)
                        {
                            FieldInsnNode nd = (FieldInsnNode)currentNode;
                            if(nd.desc.equals(varDesc) &&
                                    nd.name.equals(varName) &&
                                    nd.owner.equals(varFromClass))
                            {
                                nd.desc = newVarDesc;
                                nd.name = newVarName;
                                nd.owner = newVarFromClass;
                            }
                        }
                    }
                    break;
                }
            }

            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            classNode.accept(writer);

            return writer.toByteArray();
        }
    }
    public static class BPRenameMethod implements BPAsmAction{

        public String clazz;//                 not.my.Class
        public String methodName;//            not_my_func
        public String methodDesc;//            ()I

        public String newMethodName;//         my_func_name

        public byte[] tryTransform(String className, byte[] bytecode)
        {
            if(!className.equals(clazz))
                return null;

            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(bytecode);
            classReader.accept(classNode, 0);

            for (MethodNode m : (Iterable<MethodNode>) classNode.methods) {
                if ((m.name.equals(methodName)||methodName==null)
                        && m.desc.equals(methodDesc)) {
                    m.name = newMethodName;
                    break;
                }
            }

            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            classNode.accept(writer);

            return writer.toByteArray();
        }
    }
    public static class BPRenameField implements BPAsmAction{

        public String clazz;//                 not.my.Class
        public String name;//            not_my_field
        public String desc;//            I

        public String newName;//         my_func_name

        public byte[] tryTransform(String className, byte[] bytecode)
        {
            if(!className.equals(clazz))
                return null;

            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(bytecode);
            classReader.accept(classNode, 0);

            for (FieldNode m : (Iterable<FieldNode>) classNode.fields) {
                if (name==null||(m.name.equals(name))
                        && m.desc.equals(desc)) {
                    m.name = newName;
                    break;
                }
            }

            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            classNode.accept(writer);

            return writer.toByteArray();
        }
    }
    public static class BPReplaceNew implements BPAsmAction{

        public String clazz;//                 not.my.Class
        public String methodName;//            not_my_func
        public String methodDesc;//            ()I

        public String oldNewClass;//           not/my/Class
        public String oldMethodDesc;//         ()V

        public String newNewClass;//           my/Class

        public byte[] tryTransform(String name, byte[] bytecode)
        {
            if(!name.equals(clazz))
                return null;

            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(bytecode);
            classReader.accept(classNode, 0);

            System.out.println("[MRKR092] Found Class -> "+name);

            for (MethodNode m : (Iterable<MethodNode>) classNode.methods) {
                if ((m.name.equals(methodName)||methodName==null)
                        && m.desc.equals(methodDesc)) {

                    System.out.println("[MRKR093] Found Class Method -> "+methodName);

                    Iterator<AbstractInsnNode> iter = m.instructions.iterator();
                    while (iter.hasNext())
                    {
                        AbstractInsnNode currentNode = iter.next();

                        if (currentNode.getOpcode() == NEW)
                        {
                            //-> test/Test

                            TypeInsnNode nd = (TypeInsnNode)currentNode;

                            if(Objects.equals(nd.desc,
                                    oldNewClass))
                            {
                                System.out.println("[MRKR091] Patched NEW -> "+newNewClass);
                                nd.desc = newNewClass;
                            }
                        }
                        else if(currentNode.getOpcode()==INVOKESPECIAL)
                        {
                            MethodInsnNode nd = (MethodInsnNode)currentNode;
                            //System.out.println("IV_SPEC "+nd.name+" "+nd.desc+" "+nd.owner);
                            if(nd.name.equals("<init>") && nd.desc.equals(oldMethodDesc) &&
                                    Objects.equals(nd.owner, oldNewClass))
                            {
                                //System.out.println("Patched init call");
                                System.out.println("[MRKR092] Patched INIT @ "+oldNewClass);
                                nd.owner = newNewClass;
                            }
                        }
                    }
                    break;
                }
            }

            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            classNode.accept(writer);

            return writer.toByteArray();
        }
    }

    public static class BPReplaceStaticInvoke implements BPAsmAction {

        public String clazz;//                 not.my.Class
        public String methodName;//            not_my_func
        public String methodDesc;//            ()I

        public String owner;//              not/my/Class
        public String name;//               notMyFunc
        public String desc;//               ()I

        public String newOwner;//           my/Class
        public String newName;//            myFunc
        public String newDesc;//            ()I

        public byte[] tryTransform(String className, byte[] bytecode)
        {
            if(!className.equals(clazz))
                return null;

            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(bytecode);
            classReader.accept(classNode, 0);

            for (MethodNode m : (Iterable<MethodNode>) classNode.methods) {
                if ((m.name.equals(methodName)||methodName==null)
                        && m.desc.equals(methodDesc)) {
                    Iterator<AbstractInsnNode> iter = m.instructions.iterator();
                    while (iter.hasNext())
                    {
                        AbstractInsnNode currentNode = iter.next();
                        if (currentNode.getOpcode() == INVOKESTATIC)
                        {
                            FieldInsnNode nd = (FieldInsnNode)currentNode;
                            if(nd.desc.equals(desc) &&
                                    nd.name.equals(name) &&
                                    nd.owner.equals(owner))
                            {
                                if(newDesc!=null)
                                    nd.desc = newDesc;
                                nd.name = newName;
                                nd.owner = newOwner;
                            }
                        }
                    }
                    break;
                }
            }

            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            classNode.accept(writer);

            return writer.toByteArray();
        }
    }
    public static class BPAddDefaultConstructor implements BPAsmAction{
        public String clazz;//                 not.my.Class
        public String classSig;//              Lnot/my/Class;
        public String methodName;//            my_func
        public String methodDesc;//            ()I

        public byte[] tryTransform(String name, byte[] bytecode)
        {
            if(!name.equals(clazz))
                return null;
            //System.out.println("\n\n\n\n\n<PATCHED "+name+">\n\n\n\n");
            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(bytecode);
            classReader.accept(classNode, 0);

            MethodVisitor mthd  = classNode.visitMethod(ACC_PUBLIC, methodName, methodDesc, null, null);;

            mthd.visitCode();
            Label l0 = new Label();
            mthd.visitLabel(l0);
            mthd.visitLineNumber(17, l0);
            mthd.visitVarInsn(ALOAD, 0);
            mthd.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
            Label l1 = new Label();
            mthd.visitLabel(l1);
            mthd.visitLineNumber(1, l1);
            mthd.visitInsn(RETURN);
            Label l2 = new Label();
            mthd.visitLabel(l2);
            mthd.visitLocalVariable("this", classSig, null, l0, l2, 0);
            mthd.visitMaxs(1, 1);
            mthd.visitEnd();

            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            classNode.accept(writer);

            return writer.toByteArray();
        }
    }

    //only 2 load this
    static public byte[] tryApply(String name, String obfName, byte[] bytecode) {

        ArrayList<BPAsmAction> lActions = new ArrayList<>(actions);

        //if(Math.random()<0.05) System.out.println("<TRY "+name+" "+ lActions.size() +" "+bytecode.length+">");

        boolean somethingChanged= true;
        while (somethingChanged)
        {
            somethingChanged = false;

            for (BPAsmAction action : lActions) {

                boolean tryAction = false;

                Map<String, Integer> x = modifiedMaps.get(action);
                if(x==null)
                {
                    tryAction = true;
                    x = new HashMap<>();
                    modifiedMaps.put(action,x);
                }
                Integer xv = x.get(name);
                if(xv==null)
                {
                    tryAction = true;
                    x.put(name, bytecode.length);
                }
                else if(xv!=bytecode.length)
                    tryAction = true;


                if(tryAction)
                {
                    byte[] v = action.tryTransform(name,bytecode);
                    if(v!=null)
                    {
                        x.put(name, v.length);
                        //System.out.println("<USED "+action+" on "+name+" "+ lActions.size() +" "+v.length+">");
                        somethingChanged= true;
                        bytecode =v;
                        actions.remove(action);
                        break;
                    }
                    actions.remove(action);
                }
            }
        }

        return bytecode;
    }
}
