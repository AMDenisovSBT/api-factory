package ru.sbtqa.tag.apifactory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Api request header title.
 *
 * @author Konstantin Maltsev <mkypers@gmail.com>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ApiRequestHeader {

    /**
     * By this title header will be searched by framework
     *
     * @return a {@link java.lang.String} object.
     */
    public String header();
}
