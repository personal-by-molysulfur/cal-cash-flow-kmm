package com.molysulfur.app.calcashflow.android.widget

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import com.molysulfur.app.calcashflow.android.R
import com.molysulfur.app.calcashflow.android.widget.common.BaseViewGroup
import kotlinx.android.synthetic.main.calcashflow_widget_card_pile.view.*

class PileCardView : BaseViewGroup {

    private var iconRes: Int = 0
    private var label: String? = null
    private var labelRes: Int = 0
    private var percent: Int = 0
    private var money: Float = 0f

    override fun setup() {
        updateIcon()
        updateLabel()
        updatePercentValue()
        updateMoney()
    }

    fun setIcon(res: Int) {
        this.iconRes = res
        updateIcon()
    }

    private fun updateIcon() {
        if (iconRes > 0) {
            calcashflow_card_plie_img_icon.setImageResource(iconRes)
        }
    }

    fun setLabel(label: String?) {
        this.label = label
        updateLabel()
    }

    fun setLabel(labelRes: Int) {
        this.labelRes = labelRes
        updateLabel()
    }

    private fun updateLabel() {
        when {
            label != null -> calcashflow_card_plie_text_label.text = label
            labelRes > 0 -> calcashflow_card_plie_text_label.setText(labelRes)
        }
    }

    fun setPercentValue(percent: Int) {
        this.percent = percent
        updatePercentValue()
    }


    @SuppressLint("SetTextI18n")
    private fun updatePercentValue() {
        calcashflow_card_plie_text_percent.text = "${percent}%"
    }

    fun setMoney(money: Float) {
        this.money = money
        updateMoney()
    }

    @SuppressLint("SetTextI18n")
    private fun updateMoney() {
        calcashflow_card_plie_text_money.text = "${money}$"
    }

    override fun getLayoutResource(): Int = R.layout.calcashflow_widget_card_pile

    override fun setupStyleables(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PileCardView)
        iconRes = typedArray.getResourceId(R.styleable.PileCardView_pile_card_setIcon, 0)
        label = typedArray.getString(R.styleable.PileCardView_pile_card_setLabel)
        percent = typedArray.getInt(R.styleable.PileCardView_pile_card_setPercent, 0)
        money = typedArray.getFloat(R.styleable.PileCardView_pile_card_setMoney, 0f)
        typedArray.recycle()
    }

    override fun saveInstanceState(state: Parcelable): Parcelable {
        val ss: SavedState = onSaveInstanceChildState(SavedState(state)) as SavedState
        ss.iconRes = iconRes
        ss.label = label
        ss.labelRes = labelRes
        ss.percent = percent
        ss.money = money
        return ss
    }

    override fun restoreInstanceState(state: Parcelable) {
        val ss = state as SavedState
        iconRes = ss.iconRes
        label = ss.label
        labelRes = ss.labelRes
        percent = ss.percent
        money = ss.money
        updateIcon()
        updateLabel()
        updatePercentValue()
        updateMoney()
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)


    private class SavedState : ChildSavedState {

        var iconRes: Int = 0
        var label: String? = null
        var labelRes: Int = 0
        var percent: Int = 0
        var money: Float = 0f

        constructor(superState: Parcelable) : super(superState)

        constructor(parcel: Parcel, classLoader: ClassLoader) : super(parcel, classLoader) {
            iconRes = parcel.readInt()
            label = parcel.readString()
            labelRes = parcel.readInt()
            percent = parcel.readInt()
            percent = parcel.readInt()
            money = parcel.readFloat()
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeInt(iconRes)
            out.writeString(label)
            out.writeInt(labelRes)
            out.writeInt(percent)
            out.writeFloat(money)
        }

        companion object {
            @JvmField
            val CREATOR: Parcelable.ClassLoaderCreator<SavedState> =
                object : Parcelable.ClassLoaderCreator<SavedState> {
                    override fun createFromParcel(source: Parcel, loader: ClassLoader): SavedState {
                        return SavedState(source, loader)
                    }

                    override fun createFromParcel(`in`: Parcel): SavedState? {
                        return null
                    }

                    override fun newArray(size: Int): Array<SavedState?> {
                        return arrayOfNulls(size)
                    }
                }
        }
    }
}