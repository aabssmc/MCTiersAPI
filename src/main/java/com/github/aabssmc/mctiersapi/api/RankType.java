package com.github.aabssmc.mctiersapi.api;

/**
 * Rank Type Class
 */
@SuppressWarnings("unused")
public enum RankType {
    /**
     * Vanilla rank.
     */
    VANILLA("vanilla"),
    /**
     * Sword rank.
     */
    SWORD("sword"),
    /**
     * Axe rank.
     */
    AXE("axe"),
    /**
     * Potion rank.
     */
    POTION("pot"),
    /**
     * SMP rank.
     */
    SURVIVAL_MULTIPLAYER("smp"),
    /**
     * UHC rank.
     */
    ULTRA_HARDCORE("uhc"),
    /**
     * Netherite potion rank.
     */
    NETHERITE_POTION("neth_pot");

    /**
     * @param name The name of the rank
     */
    RankType(String name) {
        this.name = name;
    }

    private final String name;

    /**
     * @return The name of the rank
     */
    public String getName() {
        return name;
    }
}
