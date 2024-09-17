package org.mpsp2334.Class_to_translate_to_db;

import org.mpsp2334.ergasiaJava.*;
import java.util.List;
@Database(name="UnipiDB",dbtype="SQlite")
@Table(name="Student")
public class Student {
    @Field(name = "AM", type = "Text", is_primary_key = true)
    String AM;
    @Field(name="Email",type="Text", is_primary_key = false)
    String email;
    @Field(name="Year",type="Integer", is_primary_key = false)
    int yearOfStudies;
    @Field(name="FullName",type="Text", is_primary_key = false)
    String fullName;
    @Field(name="PostGraduate",type="Boolean", is_primary_key = false)
    boolean postGraduate;
    //Για τη μέθοδο αυτή μπορείτε να δοκιμάστε να επιστρέφετε
    //List<Student>
    @DBMethod(type="SelectAll")
    public List<String> getAllStudents(){
        return null;
    }
    //Ο επιστρεφόμενος ακέραιος υποδηλώνει τον αριθμό των εγγραφών
    //που διαγράφηκαν
    @DBMethod(type="DeleteOne")
    public int deleteStudents(String AM){
        return 0;
    }
}

