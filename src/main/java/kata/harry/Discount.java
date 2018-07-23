package kata.harry;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class Discount {

    private final static Map<Integer, BigDecimal> DISCOUNT_TABLE = new HashMap<>();
    static {
        DISCOUNT_TABLE.put(1, BigDecimal.ZERO);
        DISCOUNT_TABLE.put(2, BigDecimal.valueOf(0.05));
        DISCOUNT_TABLE.put(3, BigDecimal.valueOf(0.1));
        DISCOUNT_TABLE.put(4, BigDecimal.valueOf(0.2));
        DISCOUNT_TABLE.put(5, BigDecimal.valueOf(0.25));
    }

    public BigDecimal getDiscountFromVolumeSize(int volumeSize) {
        return DISCOUNT_TABLE.get(volumeSize);
    }
}
