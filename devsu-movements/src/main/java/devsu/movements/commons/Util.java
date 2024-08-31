package devsu.movements.commons;

import java.util.Arrays;
import java.util.Random;

import static devsu.movements.constants.Constants.STR_NULL;

public class Util {
    public static boolean convertToNull(String input) {
        return STR_NULL.equals(input) ? Boolean.TRUE : Boolean.parseBoolean(input);
    }


    public static String generateAccountNumber() {
        Random rand = new Random();
        int firstNumber = rand.nextInt(9) + 1;
        int othersNumber = rand.nextInt(100000); // generate number between 0 and 99999 [5 digits]

        return String.format("%d%05d", firstNumber, othersNumber);
    }

    public static boolean isAmountValid(final Double value) {
        return value > 0;
    }

    public static boolean isTypeAccountValid(final String type) {
        return Arrays.stream(AccountTypeEnum.values()).anyMatch(item -> item.name().equals(type.toUpperCase()));
    }

    public static boolean isTypeMovementValid(final String typeMovement) {
        return Arrays.stream(MovementTypeEnum.values()).anyMatch(item -> item.name().equals(typeMovement.toUpperCase()));
    }
}
