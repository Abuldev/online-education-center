package uz.team.sabredu.exceptions;

/**
 * @author "Elmurodov Javohir"
 * @since 26/07/22/14:17 (Tuesday)
 * java-ee/IntelliJ IDEA
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
