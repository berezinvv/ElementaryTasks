package com.ssitacademy.berezinvv.storage.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ModelEntity {
    String nameTable();
}
