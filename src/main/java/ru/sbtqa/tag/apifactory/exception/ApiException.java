package ru.sbtqa.tag.apifactory.exception;

/**
 *
 * @author Konstantin Maltsev <mkypers@gmail.com>
 */
public class ApiException extends Exception {

    /**
     * Constructor for ApiException.
     *
     * @param message a {@link java.lang.String} object.
     * @param e a {@link java.lang.Throwable} object.
     */
    public ApiException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * Constructor for ApiException.
     *
     * @param message a {@link java.lang.String} object.
     */
    public ApiException(String message) {
        super(message);
    }

}   