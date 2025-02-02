package ir.mehdisekoba.infiniteautoscrollrecyclerview

import android.content.Context
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

class AutoScrollHorizontalListLayoutManager(private val context: Context, private val scrollSpeed: Float) :
    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
    private val speedPerPixel = scrollSpeed / context.resources.displayMetrics.densityDpi
    private var isScrolling = false

    override fun smoothScrollToPosition(recyclerView: RecyclerView, state: RecyclerView.State, position: Int) {
        val smoothScroller = object : LinearSmoothScroller(context) {
            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float = speedPerPixel
        }
        smoothScroller.targetPosition = position
        startSmoothScroll(smoothScroller)
    }

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
        if (!isScrolling) {
            isScrolling = true
            val itemCount = itemCount
            if (itemCount > 0) {
                val firstVisibleItemPosition = findFirstVisibleItemPosition()
                val lastVisibleItemPosition = findLastVisibleItemPosition()

                if (lastVisibleItemPosition == itemCount - 1) {
                    scrollToPosition(firstVisibleItemPosition)
                }
            }
        }
    }
}