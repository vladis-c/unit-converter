package com.vladisc.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vladisc.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    val inputValue = remember {
        mutableStateOf("")
    }
    val firstSelectorIsOpen = remember {
        mutableStateOf(false)
    }
    val secondSelectorIsOpen = remember {
        mutableStateOf(false)
    }
    val firstUnit = remember {
        mutableStateOf<Unit?>(null)
    }
    val secondUnit = remember {
        mutableStateOf<Unit?>(null)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue.value,
            onValueChange = { inputValue.value = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {
                fun openFirstSelector() {
                    firstSelectorIsOpen.value = true
                }

                fun closeFirstSelector() {
                    firstSelectorIsOpen.value = false
                }

                fun setFirstUnit(unit: Unit) {
                    firstUnit.value = unit
                    closeFirstSelector()
                }
                Button(
                    onClick = {
                        openFirstSelector()
                    }
                ) {
                    Text(text = firstUnit.value?.toString() ?: "From")
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(
                    expanded = firstSelectorIsOpen.value,
                    onDismissRequest = {
                        closeFirstSelector()
                    }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(text = Unit.MILLIMETERS.toString())
                        },
                        onClick = {
                            setFirstUnit(Unit.MILLIMETERS)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = Unit.CENTIMETERS.toString())
                        },
                        onClick = {
                            setFirstUnit(Unit.CENTIMETERS)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = Unit.METERS.toString())
                        },
                        onClick = {
                            setFirstUnit(Unit.METERS)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = Unit.FEET.toString())
                        },
                        onClick = {
                            setFirstUnit(Unit.FEET)
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                fun openSecondSelector() {
                    secondSelectorIsOpen.value = true
                }

                fun closeSecondSelector() {
                    secondSelectorIsOpen.value = false
                }

                fun setSecondUnit(unit: Unit) {
                    closeSecondSelector()
                    secondUnit.value = unit
                }
                Button(
                    onClick = {
                        openSecondSelector()
                    }
                ) {
                    Text(text = secondUnit.value?.toString() ?: "To")
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(
                    expanded = secondSelectorIsOpen.value,
                    onDismissRequest = {
                        closeSecondSelector()
                    }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(text = Unit.MILLIMETERS.toString())
                        },
                        onClick = {
                            setSecondUnit(Unit.MILLIMETERS)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = Unit.CENTIMETERS.toString())
                        },
                        onClick = {
                            setSecondUnit(Unit.CENTIMETERS)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = Unit.METERS.toString())
                        },
                        onClick = {
                            setSecondUnit(Unit.METERS)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = Unit.FEET.toString())
                        },
                        onClick = {
                            setSecondUnit(Unit.FEET)
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result:")
    }
}
