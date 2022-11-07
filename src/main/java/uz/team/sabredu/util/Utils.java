package uz.team.sabredu.util;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import uz.team.sabredu.exceptions.PhoneNumberFormatException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Utils {


    public static List<String> regions = List.of("Karakalpakstan", "Xorazm", "Navoiy","Bukhara", "Samarqand", "Qashqadaryo",
            "Surxondaryo", "Jizzakh", "Sirdaryo", "Tashkent", "Namangan", "Fergana", "Andijan","Tashkent City");

    public static Map<String,List<String>> cities = new HashMap<>();


    public static String COVER_EXTENSION = "jpg";
    public static final String COVER_CONTENT_TYPE = "image/" + COVER_EXTENSION;

    public static boolean isDigit(@NonNull String character) {
        if (character.isBlank())
            return false;
        for (char ch : character.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static String generateUniqueFileName() {
        return generateSerialId() + ".pdf";
    }

    public static String generateUniqueCoverName() {
        return generateSerialId() + "." + COVER_EXTENSION;
    }

    public static String getCoverFileName(@NonNull String filename) {
        return filename.substring(0, filename.indexOf(".")) + "." + COVER_EXTENSION;
    }

    private static String generateSerialId() {
        return "" + System.currentTimeMillis();
    }


    public static String encodePassword(@NonNull final String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public static boolean matchPassword(@NonNull final String plainPassword, @NonNull final String encodedPassword) {
        return BCrypt.checkpw(plainPassword, encodedPassword);
    }

    public static void checkForValidNumber(String phone) {
        if(!phone.startsWith("+998")) throw new PhoneNumberFormatException("Number starts with \"+998\"");
        if (phone.length()!=13)  throw new PhoneNumberFormatException("Number format \"+998*********\"");
        if (!StringUtils.isNumeric(phone.substring(1))) {
            throw new PhoneNumberFormatException("Number must be only one plus and digits \"+998*********\"");
        }
    }
}
