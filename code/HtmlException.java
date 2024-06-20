/*
 * This class is used to throw a HTML exception.
 * This ocurrs when there are malformed HTML structures.
 */
public class HtmlException extends RuntimeException {
    public HtmlException(String message) {
        super(message);
    }
}