package com.vladisc.unitconverter

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Result(unit1: Unit?, unit2: Unit?, input: String?) {
    var multiplier by remember { mutableStateOf<Double?>(null) }

    LaunchedEffect(unit1, unit2) {
        unit1 ?: return@LaunchedEffect
        unit2 ?: return@LaunchedEffect
        1.0 / unit1.multiplier * unit2.multiplier
        multiplier = 1.0 / unit1.multiplier * unit2.multiplier
    }

    val num = input?.takeUnless { it.isBlank() }?.toBigDecimalOrNull() ?: return
    val mul = multiplier?.toBigDecimal() ?: return

    val result = (num * mul).stripTrailingZeros().toPlainString()
    Text(
        text = "Result: $result"
    )

}