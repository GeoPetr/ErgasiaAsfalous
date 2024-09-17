package org.mpsp2334.ergasiaJava;

public class AnalyzeAnnotations {

    static String[] Modded_Annotations = new String[1000];
    static int no_of_annots;
    static String Tablename = null;
    static String Field = null;
    static String[] Methods= new String[1000];
    static String DBtype = null;
    static String DBname = null;


    public static void contract_annotations(String[] Detected_Annotations){ //Συγκεντρώνονται όλα τα annotations από την
        try {                                                               //καίρια κλάση και αποθηκεύονται σε array
            no_of_annots = Detected_Annotations.length;
            for (int i = 0; i < no_of_annots; i ++) {
                int Data_Start_Index = Detected_Annotations[i].lastIndexOf(".") + 1;
                Modded_Annotations[i]= (Detected_Annotations[i]).substring(Data_Start_Index);
                //System.out.println(Modded_Annotations[i]);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void analyze_annotations(){                           //Τα annotations αναλύονται ανάλογα τον τύπο
        try{                                                            //τους και τα χαρακτηριστικά τους, ώστε να
            for (int i = 0; i < no_of_annots; i ++) {                   //μπορούν να αξιοποιηθούν για την επικοινωνία
                System.out.println(Modded_Annotations[i]);              //με βάση δεδομένων.
                String temp_str = Modded_Annotations[i];                //Η ανάλυση γίνεται με προσπέλασή των String
                if (temp_str.contains("Database(name=")){               //που τα αντιπροσωπεύουν.
                    if (temp_str.contains("dbtype=\"SQlite\"")){

                        int index_of_next_escape = temp_str.indexOf("\"",15);
                        DBname = temp_str.substring(15,index_of_next_escape);
                        DBtype = "sqlite";
                        //System.out.println("SQlite");
                        //System.out.println(db_name);
                    }
                    else if (temp_str.contains("dbtype=\"Derby\"")){

                        int index_of_next_escape = temp_str.indexOf("\"",15);
                        DBname = temp_str.substring(15,index_of_next_escape);
                        DBtype = "derby";
                        //System.out.println("Derby");
                        //System.out.println(db_name);
                    }
                    else if (temp_str.contains("dbtype=\"H2\"")){

                        int index_of_next_escape = temp_str.indexOf("\"",15);
                        DBname = temp_str.substring(15,index_of_next_escape);
                        DBtype = "h2";
                        //System.out.println("H2");
                        //System.out.println(db_name);
                    }
                    else{
                        System.out.println("Non standard DB request");
                    }
                }
                else if (temp_str.contains("Table(name=")){
                    int index_of_next_escape = temp_str.indexOf("\"",12);
                    String table_name = temp_str.substring(12,index_of_next_escape);
                    Tablename = table_name;
                    System.out.println(table_name);
                }
                else if (temp_str.contains("Field(name=")){
                    if (temp_str.contains("is_primary_key=true")){
                        int index_first_name =  temp_str.indexOf("\"")+1;
                        int index_last_name = temp_str.indexOf("\"",index_first_name);
                        Field = temp_str.substring(index_first_name,index_last_name);
                        int index_fist_type = temp_str.indexOf("\"",index_last_name)+1;
                        int index_last_type = temp_str.indexOf("\"",index_fist_type);
                        System.out.println(Field);
                    }
                }
                //else{
                    //System.out.println("bad given class");
                    //break;
                //}
            }

        }catch (Exception e){
            System.out.println(e);

        }
    }

    public static void create_database(){                           //Δημιουργία βάσης δεδομένων με ηθελημένα
        CreateDB.createNewDatabase(DBname,DBtype);                  //χαρακτηριστικά
        //CreateDB.connect(DBname,DBtype);
        CreateDB.createTable(DBname,DBtype,Tablename,Field);
    }
}
