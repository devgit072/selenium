package entity.exception;

/**
 * Created by devraj.singh on 12/25/15.
 */
public class BrowserNotSupportedException extends Exception{

    public BrowserNotSupportedException()
    {
        super();
    }
    public BrowserNotSupportedException(String message)
    {
        super(message);
    }
}
