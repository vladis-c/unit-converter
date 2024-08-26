package com.vladisc.unitconverter

enum class Unit(private val displayName: String) {
    MILLIMETERS("mm"),
    CENTIMETERS("cm"),
    METERS("m"),
    FEET("feet");

    override fun toString(): String {
        return displayName
    }
}