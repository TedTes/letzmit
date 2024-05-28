package com.tutego.date4u.interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE,
        ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface ThumbnailRendering {
    enum RenderingQuality {
        FAST, QUALITY
    }

    RenderingQuality value();
}
