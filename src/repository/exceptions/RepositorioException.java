package repository.exceptions;

public class RepositorioException extends Exception{
    public RepositorioException(String message, Exception cause) {
        super(message, cause);
    }
    public RepositorioException(String message) {
        super(message);
    }
}
