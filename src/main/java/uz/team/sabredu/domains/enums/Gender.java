package uz.team.sabredu.domains.enums;

public enum Gender {

    FEMALE, MALE, OTHER;

    public static Gender findByName(String gender) {
        for (Gender value : values()) {
            if (value.name().equals(gender)){
                return value;
            }
        }
        return OTHER;
    }
}
