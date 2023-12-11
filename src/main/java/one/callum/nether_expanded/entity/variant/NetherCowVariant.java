package one.callum.nether_expanded.entity.variant;

import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.util.ByIdMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

public enum NetherCowVariant {
    CRIMSON(0),
    WARPED(1);

    private static final IntFunction<NetherCowVariant> BY_ID = ByIdMap.continuous(NetherCowVariant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
    private final int id;

    NetherCowVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static NetherCowVariant byId(int id) {
        return BY_ID.apply(id);
    }
}
