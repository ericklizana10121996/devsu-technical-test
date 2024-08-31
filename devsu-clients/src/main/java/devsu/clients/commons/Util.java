package devsu.clients.commons;

import static devsu.clients.constants.Constants.STR_NULL;

public class Util {
    public static boolean convertToNull(String input) {
        return STR_NULL.equals(input) ? Boolean.TRUE : Boolean.parseBoolean(input);
    }
}
