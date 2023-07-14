package com.example.swipe.swipe

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

class SwipeAction(
    val onSwipe: ()->Unit,
    val icon: @Composable ()->Unit,
    val background: Color,
    val weight: Double = 1.0,
    val isUndo: Boolean = false
) {

    init {
        // require() checks if all pre defined attributes in correct scope, and throw exception if not.
        require(weight >0.0) {"invalid weight $weight; must be greater than zero"}
    }

    //copy() copies all attributes of SwipeAction class
    fun copy(
        onSwipe: () -> Unit = this.onSwipe,
        icon: @Composable () -> Unit = this.icon,
        background: Color = this.background,
        weight: Double = this.weight,
        isUndo: Boolean = this.isUndo,
    ) = SwipeAction(
        onSwipe = onSwipe,
        icon = icon,
        background = background,
        weight = weight,
        isUndo = isUndo
    )

    @SuppressLint("NotConstructor")
    fun SwipeAction(
        onSwipe: () -> Unit,
        icon: Painter,
        background: Color,
        weight: Double = 1.0,
        isUndo: Boolean = false
    ): SwipeAction{
        return SwipeAction(
            icon = {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.padding(16.dp)
                )
            },
            background = background,
            weight = weight,
            onSwipe = onSwipe,
            isUndo = isUndo
        )
    }

}