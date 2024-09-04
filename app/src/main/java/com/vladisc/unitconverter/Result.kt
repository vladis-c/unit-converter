package com.vladisc.unitconverter

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

fun setMultiplier(unit1: Unit?, unit2: Unit?): Double? {
    return when {
        unit1 === Unit.MILLIMETERS && unit2 === Unit.CENTIMETERS -> 0.01
        unit1 === Unit.MILLIMETERS && unit2 === Unit.METERS -> 0.0001
        unit1 === Unit.MILLIMETERS && unit2 === Unit.FEET -> 0.00328084
        unit1 === Unit.CENTIMETERS && unit2 === Unit.MILLIMETERS -> 10.00
        unit1 === Unit.CENTIMETERS && unit2 === Unit.METERS -> 0.001
        unit1 === Unit.CENTIMETERS && unit2 === Unit.FEET -> 0.0328084
        unit1 === Unit.METERS && unit2 === Unit.CENTIMETERS -> 100.00
        unit1 === Unit.METERS && unit2 === Unit.MILLIMETERS -> 1000.00
        unit1 === Unit.METERS && unit2 === Unit.FEET -> 0.328084
        unit1 === Unit.FEET && unit2 === Unit.MILLIMETERS -> 304.8
        unit1 === Unit.FEET && unit2 === Unit.CENTIMETERS -> 30.48
        unit1 === Unit.FEET && unit2 === Unit.METERS -> 0.3048
        (unit1 != null && unit2 != null) && (unit1 === unit2) -> 1.00
        else -> null
    }
}


@Composable
fun Result(unit1: Unit?, unit2: Unit?, input: String?) {
    val multiplier = remember { mutableStateOf<Double?>(null) }

    LaunchedEffect(unit1, unit2, input) {
        if (input != null) {
            if (input != "") {
                multiplier.value = setMultiplier(unit1, unit2)
            }
        }
    }

    if (multiplier.value != null) {
        val result =
            (multiplier.value!! * (input?.toDouble() ?: 1.0)).toBigDecimal().stripTrailingZeros()
                .toPlainString()
        Text(
            text = "Result: $result"
        )
    }

}