package org.mpsp2334.ergasiaJava;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)

public @interface Field {
    String name();

    String type();

    boolean is_primary_key();
}
