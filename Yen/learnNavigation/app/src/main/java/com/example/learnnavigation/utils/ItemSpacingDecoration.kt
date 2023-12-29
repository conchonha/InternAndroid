package com.example.learnnavigation.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemSpacingDecoration(var horizontalSpacing: Float, var verticalSpacing: Float) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)

        outRect.left = if (position % 3 == 0) (dpFromPx(view, horizontalSpacing)).toInt() else (dpFromPx(view, horizontalSpacing)  / 2).toInt()
        outRect.right = if (position % 3 != 2) (dpFromPx(view, horizontalSpacing) / 2).toInt() else (dpFromPx(view, horizontalSpacing)).toInt()
        if (position >= 3) {
            outRect.top = (dpFromPx(view, verticalSpacing).toInt())
        }
    }
    fun dpFromPx(view:View, px: Float): Float {
        val scale = view.resources.displayMetrics.density
        return (px * scale + 0.5f)
    }

}