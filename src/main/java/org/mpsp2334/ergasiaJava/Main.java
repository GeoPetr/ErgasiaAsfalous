package org.mpsp2334.ergasiaJava;

import java.util.Scanner;

import static org.mpsp2334.ergasiaJava.ReflectUpon.*;
import static org.mpsp2334.ergasiaJava.AnalyzeAnnotations.*;

public class Main {

    static String class_name = "org.mpsp2334.Class_to_translate_to_db.";
    static Class<?> Class_to_reflect;
    static String[] Detected_Annotations;

    public static void main(String[] args) {
        System.out.println("Enter name of class");                  //Εισαγωγή ονόματος της κλάσης
        Scanner scanner_action = new Scanner(System.in);            //που θα χρησιμοποιηθεί
        class_name = class_name+scanner_action.nextLine();

        Class_to_reflect = get_class(class_name);                   //Με βάση το όνομα, στον αντίστοιχο φάκελο,
        get_annotations(Class_to_reflect);                          //αναλύεται η κλάση ώστε να χρησιμοποιηθεί με το
        Detected_Annotations = getOutputs().toArray(new String[0]); //database που ορίστηκε. (Δουλεύει μόνο η sqlite)
        contract_annotations(Detected_Annotations);                 //εξαιτίας έλλειψης driver
        analyze_annotations();
        create_database();

    }
}