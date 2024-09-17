//Χρησιμοποιείται η τεχνική του reflection ώστε από την Class που θα εισαχθεί στον φάκελο
//"Class_to_translate_to_db" να ληφούν τα annotations που την προσδιορίζουν με σκοπό την
//κατάληλλη διαμόρφωση πίνακα σε βάση δεδομένων
package org.mpsp2334.ergasiaJava;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectUpon {
    static Class<?> class_reflected;
    static java.lang.reflect.Field[] all_class_accessible_fields;
    static Annotation[] all_class_annotations;
    static Method[] all_class_methods;
    static List<String> outputs = new ArrayList<String>();

    public static Class<?> get_class(String class_name){
        try{
            class_reflected = Class.forName(class_name);
        }catch(Exception e){
            System.out.println(e);
        }
        outputs.add(class_reflected.toString());
        return class_reflected;
    }

    public static void get_annotations(Class<?> class_reflected){
        try{
            all_class_annotations = class_reflected.getAnnotations();
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            all_class_accessible_fields = class_reflected.getDeclaredFields();
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            all_class_methods = class_reflected.getDeclaredMethods();
        }catch(Exception e){
            System.out.println(e);
        }
        for (Annotation annot: all_class_annotations){
            outputs.add(annot.toString());
        }
        for (Field fie: all_class_accessible_fields){
            Annotation[] all_field_annot = fie.getAnnotations();
            for (Annotation annot: all_field_annot){
                outputs.add(annot.toString());
            }
        }
        for(Method meth: all_class_methods){
            Annotation[] all_method_annot = meth.getAnnotations();
            for (Annotation annot: all_method_annot){
                outputs.add(annot.toString());
            }
        }
    }

    public static List<String> getOutputs() {
        return outputs;
    }
}
