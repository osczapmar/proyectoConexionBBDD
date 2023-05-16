package basedatospersonaje;

/**
 *
 * @author santi
 */
public class NullConnectionException extends Exception{
    
    public NullConnectionException()
    {
        this("No se pueden realizar operaciones sobre una conexión nula o cerrada");
    }
    
    public NullConnectionException(String msg)
    {
        super(msg);
    }
}
