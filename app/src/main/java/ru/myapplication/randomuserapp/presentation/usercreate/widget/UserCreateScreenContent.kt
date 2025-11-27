package ru.myapplication.randomuserapp.presentation.usercreate.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.myapplication.randomuserapp.presentation.theme.DarkBlue
import ru.myapplication.randomuserapp.presentation.usercreate.model.UserCreateData

@Composable
internal fun UserCreateScreenContent(
    state: UserCreateData,
    onGenerate: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        PrintText("Select Gender :")

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            PrintDropdown(
                items = state.genderList,
            )
        }

        PrintText("Select Nationality :")

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            PrintDropdown(
                items = state.countryList,
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 10.dp,
                    )
                    .align(alignment = Alignment.BottomCenter),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBlue,
                    contentColor = Color.White,
                ),
                onClick = onGenerate,
            ) {
                Text(
                    text = "GENERATE",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                )
            }
        }
    }
}

@Composable
private fun PrintDropdown(
    items: List<String>,
) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(items.first()) }

    Button(
        modifier = Modifier
            .padding(
                horizontal = 12.dp
            )
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(15)
            )
            .fillMaxWidth(),
        shape = RoundedCornerShape(15),
        colors = ButtonColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.Black,
        ),
        onClick = { expanded = true }
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier
                    .align(alignment = Alignment.CenterStart),
                text = selected,
                fontSize = 16.sp,
            )

            Icon(
                modifier = Modifier
                    .align(alignment = Alignment.CenterEnd)
                    .height(20.dp),
                imageVector = arrowIconOpening(
                    expanded = expanded
                ),
                contentDescription = "",
            )
        }
    }

    DropdownMenu(
        modifier = Modifier
            .background(color = Color.White),
        offset = DpOffset(
            x = 16.dp,
            y = 4.dp,
        ),
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        items.forEach { option ->
            DropdownMenuItem(
                text = {
                    Text(
                        text = option,
                        fontSize = 16.sp,
                    )
                },
                onClick = {
                    selected = option
                    expanded = false
                }
            )
        }
    }
}

@Composable
private fun arrowIconOpening(
    expanded: Boolean,
): ImageVector {
    return if (expanded) {
        Icons.AutoMirrored.Filled.KeyboardArrowRight
    } else {
        Icons.Default.KeyboardArrowDown
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    UserCreateScreenContent(
        state = UserCreateData(
            genderList = listOf(
                "Male",
                "Female",
            ),
            countryList = listOf(
                "Russian Federation",
                "United States",
                "Australia",
            )
        ),
        onGenerate = {},
    )
}