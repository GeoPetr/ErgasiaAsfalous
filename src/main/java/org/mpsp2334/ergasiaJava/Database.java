package org.mpsp2334.ergasiaJava;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)

public @interface Database {
    String name();

    String dbtype();
}
