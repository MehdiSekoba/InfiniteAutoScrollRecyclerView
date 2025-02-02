package ir.mehdisekoba.infiniteautoscrollrecyclerview

import android.content.Context
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView
import com.rubensousa.decorator.ColumnProvider
import com.rubensousa.decorator.GridMarginDecoration
import com.rubensousa.decorator.LinearMarginDecoration

// Extension functions (using dimension resources directly)
fun Context.getGridHorizontalMarginDecoration() = GridMarginDecoration(
    horizontalMargin = resources.getDimensionPixelSize(R.dimen.grid_horizontal_margin), // Use dimension resource
    verticalMargin = resources.getDimensionPixelSize(R.dimen.grid_vertical_margin),   // Use dimension resource
    columnProvider = object : ColumnProvider {
        override fun getNumberOfColumns(): Int = 4
    },
    orientation = RecyclerView.HORIZONTAL
)

fun Context.getListHorizontalMarginDecoration(@Px margin: Int) = LinearMarginDecoration(
    leftMargin = margin,
    topMargin = margin,
    rightMargin = margin,
    bottomMargin = margin,
    orientation = RecyclerView.HORIZONTAL
)