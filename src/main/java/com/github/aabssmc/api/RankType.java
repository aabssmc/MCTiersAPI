package com.github.aabssmc.api;

@SuppressWarnings("unused")
public enum RankType {
    VANILLA("vanilla"),
    SWORD("sword"),
    AXE("axe"),
    POTION("pot"),
    SURVIVAL_MULTIPLAYER("smp"),
    ULTRA_HARDCORE("uhc"),
    NETHERITE_POT("neth_pot");

    RankType(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
