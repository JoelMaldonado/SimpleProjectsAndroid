package com.jjmf.android.diezmovec.ui.features.Menu.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jjmf.android.diezmovec.ui.theme.ColorP1


@Composable
fun IconBottom(
    isSelected: Boolean,
    iconOn: ImageVector,
    iconOff: ImageVector,
    text: String,
    click: () -> Unit,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(if (isSelected) ColorP1.copy(0.1f) else Color.Transparent)
            .clickable { click() }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            imageVector = if (isSelected) iconOn else iconOff,
            contentDescription = null,
            tint = if (isSelected) ColorP1 else Color.Gray
        )
        AnimatedVisibility(visible = isSelected) {
            Text(text = text, color = ColorP1, fontSize = 14.sp)
        }
    }
}