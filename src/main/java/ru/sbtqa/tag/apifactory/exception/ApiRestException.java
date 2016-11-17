package ru.sbtqa.tag.apifactory.exception;

/**
 *
 * @author Konstantin Maltsev <mkypers@gmail.com>
 */
public class ApiRestException extends ApiException {

    /**
     * Constructor for ApiRestException.
     *
     * @param message a {@link java.lang.String} object.
     * @param e a {@link java.lang.Throwable} object.
     */
    public ApiRestException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * Constructor for ApiRestException.
     *
     * @param message a {@link java.lang.String} object.
     */
    public ApiRestException(String message) {
        super(message);
    }

}
