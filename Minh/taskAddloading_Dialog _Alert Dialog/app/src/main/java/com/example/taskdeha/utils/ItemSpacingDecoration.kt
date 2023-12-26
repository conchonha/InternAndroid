package com.example.taskdeha.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemSpacingDecoration(var horizontalSpacing: Int, var verticalSpacing: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)

        outRect.left = if (position % 3 == 0) 0 else horizontalSpacing / 2
        outRect.right = if (position % 3 != 2) horizontalSpacing / 2 else 0
        if (position >= 3) {
            outRect.top = verticalSpacing
        }
    }
}