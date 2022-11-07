package uz.team.sabredu.exceptions;

public class PhoneNumberFormatException extends BadRequestException{
    public PhoneNumberFormatException(String message) {
        super(message);
    }
}
