package com.dka.routines;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/**
 * @author Dmitry.Kalyuzhnyi 15.10.2015.
 */
public class CircleViewTagLayout extends FrameLayout {

    public CircleViewTagLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupPaddings(context, attrs);
    }

    public CircleViewTagLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupPaddings(context, attrs);
    }

    private void setupPaddings(Context context, AttributeSet attrs) {
        int diameter = 0;
        TypedArray attrArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.FabLayout,
                0, 0);
        try {
            diameter = attrArray.getInteger(R.styleable.FabLayout_anchor_diameter, 0);
        } finally {
            attrArray.recycle();
        }

        int padding = (int) Math.round((double) diameter * (1d - 1d / (Math.sqrt(2d)))); // in dips
        int paddingPx = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, padding, getResources().getDisplayMetrics()));

        String xmlAnchorGravity = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "layout_anchorGravity");
        int gravity = Integer.parseInt(xmlAnchorGravity.substring(2), 16);

        int top = ((gravity & 0x30) == 0x30) ? 1 : 0;
        int bottom = ((gravity & 0x50) == 0x50) ? 1 : 0;
        int left = ((gravity & 0x03) == 0x03) ? 1 : 0;
        int right = ((gravity & 0x05) == 0x05) ? 1 : 0;

        setPadding(left * paddingPx,
                top * paddingPx,
                right * paddingPx,
                bottom * paddingPx);
    }
}
