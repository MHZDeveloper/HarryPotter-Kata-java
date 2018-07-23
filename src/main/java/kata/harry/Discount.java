package kata.harry;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class Discount {

    private final static Map<Integer, BigDecimal> DISCOUNT_TABLE = new HashMap<>();
    static {
        DISCOUNT_TABLE.put(1, BigDecimal.ONE);
        DISCOUNT_TABLE.put(2, BigDecimal.valueOf(0.95));
        DISCOUNT_TABLE.put(3, BigDecimal.valueOf(0.90));
        DISCOUNT_TABLE.put(4, BigDecimal.valueOf(0.80));
        DISCOUNT_TABLE.put(5, BigDecimal.valueOf(0.75));
    }

    public BigDecimal getDiscountFromVolumeSize(int volumeSize) {
        return DISCOUNT_TABLE.get(volumeSize);
    }
}
