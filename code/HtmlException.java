/**
 * This class is used to throw a HTML exception.
 * This ocurrs when there are malformed HTML structures.
 */
public class HtmlException extends RuntimeException {
    /**
     * Builds HtmlException from RuntimeException
     * @param message error message
     */
    public HtmlException(String message) {
        super(message);
    }
}