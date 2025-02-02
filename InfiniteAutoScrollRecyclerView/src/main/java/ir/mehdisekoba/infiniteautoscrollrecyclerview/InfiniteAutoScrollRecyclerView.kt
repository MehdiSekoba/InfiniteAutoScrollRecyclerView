package ir.mehdisekoba.infiniteautoscrollrecyclerview

import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

const val DEFAULT_ITEM_MARGIN = 0
const val DEFAULT_SCROLL_SPEED = 35000f
class InfiniteAutoScrollRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private var itemMargin = 0 // Combined margin
    private lateinit var internalAdapter: Adapter<*>
    private var scrollSpeed = DEFAULT_SCROLL_SPEED
    private var scrollLayoutType = ScrollLayoutType.LIST
    private var scrollOrientation = HORIZONTAL

    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        attrs?.let {
            val attributes = context.obtainStyledAttributes(it, R.styleable.InfiniteAutoScrollRecyclerView)
            scrollOrientation = attributes.getInt(R.styleable.InfiniteAutoScrollRecyclerView_scrollOrientation, HORIZONTAL)
            scrollLayoutType = attributes.getInt(R.styleable.InfiniteAutoScrollRecyclerView_scrollLayoutType, ScrollLayoutType.GRID)
            itemMargin = attributes.getDimensionPixelSize(R.styleable.InfiniteAutoScrollRecyclerView_itemMargin, DEFAULT_ITEM_MARGIN)
            scrollSpeed = attributes.getFloat(R.styleable.InfiniteAutoScrollRecyclerView_scrollSpeed, DEFAULT_SCROLL_SPEED)

            layoutManager = createLayoutManager(scrollLayoutType)
            addItemDecoration(createItemDecoration(scrollLayoutType, scrollOrientation))
            attributes.recycle()
        }
    }

    private fun createLayoutManager(scrollLayoutType: Int) = when (scrollLayoutType) {
        ScrollLayoutType.LIST -> AutoScrollHorizontalListLayoutManager(context, scrollSpeed)
        ScrollLayoutType.GRID -> AutoScrollHorizontalGridLayoutManager(context, scrollSpeed)
        else -> throw IllegalArgumentException("Illegal Scroll Type")
    }

    private fun createItemDecoration(scrollLayoutType: Int, scrollOrientation: Int) = when (scrollLayoutType) {
        ScrollLayoutType.LIST -> context.getListHorizontalMarginDecoration(itemMargin)
        ScrollLayoutType.GRID -> context.getGridHorizontalMarginDecoration()
        else -> context.getGridHorizontalMarginDecoration()
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        if (adapter != null) {
            internalAdapter = adapter
            super.setAdapter(adapter)
        } else {
            super.setAdapter(null)
        }
    }


    fun startScrolling() {
        post {
            val startPosition = when (scrollLayoutType) {
                ScrollLayoutType.LIST -> 1000 // Start from a reasonable position
                ScrollLayoutType.GRID -> 1000 // Start from a reasonable position
                else -> 0
            }
            smoothScrollToPosition(startPosition)
        }
    }

    object ScrollLayoutType {
        const val LIST = 1
        const val GRID = 2
    }

}