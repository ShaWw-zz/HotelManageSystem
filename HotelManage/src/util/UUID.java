package util;

public class UUID {
    public static String uuid(){
        return java.util.UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
}
