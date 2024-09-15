package com.vladisc.unitconverter

enum class Unit(private val displayName: String, val multiplier: Double) {
    MILLIMETERS("mm", 0.001),
    CENTIMETERS("cm", 0.01),
    METERS("m", 1.0),
    FEET("feet", 0.328084);

    override fun toString(): String {
        return displayName
    }
}