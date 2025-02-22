package su.harbingers_of_chaos.realisticcitiescoder.block.custom;

import net.minecraft.util.StringIdentifiable;

public enum Connection implements StringIdentifiable {
    SINGLE("single"),
    END("end"),
    MIDDLE("middle"),
    CORNER("corner"),
    TEE("tee"),
    INTERSECTION("intersection");

    private final String name;

    private Connection(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}