package com.jd.core.ui.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.jd.core.R

class ChooseItemLayout(context: Context, attributeSet: AttributeSet?) : ConstraintLayout(context, attributeSet)
{

    private val iconIV = ImageView(context)

    private val rightUpTV = TextView(context)

    private val rightBottomTV = TextView(context)

    private val density = context.resources.displayMetrics.density

    var rightUpText=""
    set(value){
        field=value
        if(!isAttachedToWindow){
            rightUpTV.text=value
        }
    }

    var rightBottomText=""
    set(value){
        field=value
        if(!isAttachedToWindow){
            rightBottomTV.text=value
        }
    }

    var iconWidth = (60 * density).toInt()
        set(value)
        {
            field = value
            if (isAttachedToWindow)
            {
                iconIV.layoutParams.width = value
            }
        }

    var iconHeight = (60 * density).toInt()
        set(value)
        {
            field = value
            if (isAttachedToWindow)
            {
                iconIV.layoutParams.height = value
            }
        }

    var iconDrawable: Drawable?=null
    set(value)
    {
        field=value
        if(isAttachedToWindow){
            iconIV.setImageDrawable(value)
        }
    }


    constructor(context: Context) : this(context, null)

    init
    {
        if (attributeSet != null)
        {
            parseAttrs(context, attributeSet)
        }
        addIconIV()
        addRightUpTV()
        addRightBottomTV()
    }

    private fun parseAttrs(context: Context, attributeSet: AttributeSet?)
    {

        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ChooseItemLayout)
        iconWidth = typedArray.getDimensionPixelOffset(R.styleable.ChooseItemLayout_iconWidth, iconWidth)
        iconHeight = typedArray.getDimensionPixelOffset(R.styleable.ChooseItemLayout_iconHeight, iconHeight)
        iconDrawable=typedArray.getDrawable(R.styleable.ChooseItemLayout_iconSrc)
        rightUpText=typedArray.getString(R.styleable.ChooseItemLayout_rightUpText)
        rightBottomText=typedArray.getString(R.styleable.ChooseItemLayout_rightBottomText)
        typedArray.recycle()
    }

    private fun addIconIV()
    {
        val layoutParams = LayoutParams(iconWidth, iconHeight)
        layoutParams.leftMargin = 15
        layoutParams.leftToLeft = LayoutParams.PARENT_ID
        layoutParams.topToTop = LayoutParams.PARENT_ID
        layoutParams.bottomToBottom = LayoutParams.PARENT_ID
        iconIV.setImageDrawable(iconDrawable)
        iconIV.id=R.id.id_chooseitem_icon
        addView(iconIV, layoutParams)
    }

    private fun addRightUpTV()
    {

        val layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        layoutParams.topToTop = iconIV.id
        layoutParams.rightToRight
        layoutParams.rightToRight = LayoutParams.PARENT_ID
        layoutParams.rightMargin = 15
        rightUpTV.text=rightUpText
        rightUpTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18.0f)
        rightUpTV.setTextColor(ContextCompat.getColor(context, R.color.C_FFFFFF))
        addView(rightUpTV, layoutParams)
    }

    private fun addRightBottomTV()
    {
        val layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        layoutParams.bottomToBottom = iconIV.id
        layoutParams.rightToRight = LayoutParams.PARENT_ID
        layoutParams.rightMargin = 15
        rightBottomTV.text=rightBottomText
        rightBottomTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16.0f)
        rightBottomTV.setTextColor(ContextCompat.getColor(context, R.color.C_FFFFFF))
        addView(rightBottomTV, layoutParams)
    }
}