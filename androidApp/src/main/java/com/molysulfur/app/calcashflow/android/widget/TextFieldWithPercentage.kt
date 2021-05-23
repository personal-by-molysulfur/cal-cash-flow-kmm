package com.molysulfur.app.calcashflow.android.widget

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import androidx.core.widget.doAfterTextChanged
import com.molysulfur.app.calcashflow.android.R
import com.molysulfur.app.calcashflow.android.widget.common.BaseViewGroup
import java.lang.NumberFormatException
import kotlinx.android.synthetic.main.calcashflow_widget_text_field_with_percentage.view.calcashflow_card_plie_text_input_price as editTextPrice
import kotlinx.android.synthetic.main.calcashflow_widget_text_field_with_percentage.view.calcashflow_card_plie_text_input_percentage as editTextPercent

class TextFieldWithPercentage : BaseViewGroup {

    private var hintPrice: String? = null
    private var hintPriceRes: Int = 0
    private var hintPercentage: String? = null
    private var hintPercentageRes: Int = 0
    private var price: Float = 0f
    private var percent: Int = 0


    var onPriceChange: ((Float) -> Unit)? = null
    var onPercentageChange: ((Int) -> Unit)? = null


    override fun setup() {
        updateHintPrice()
        updateHintPercentage()
        updatePercent()
        updatePrice()
        editTextPrice.editText?.doAfterTextChanged { editText ->
            try {
                val text: String? = editText?.toString()
                if (!text.isNullOrBlank())
                    onPriceChange?.invoke(text.toFloat())
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
        }
        editTextPercent.editText?.doAfterTextChanged { editText ->
            try {
                val text: String? = editText?.toString()
                if (!text.isNullOrBlank())
                    onPercentageChange?.invoke(text.toInt())
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
        }
    }

    override fun getLayoutResource(): Int = R.layout.calcashflow_widget_text_field_with_percentage

    override fun setupStyleables(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextFieldWithPercentage)
        hintPrice = typedArray.getString(R.styleable.TextFieldWithPercentage_text_field_with_percentage_setHintPrice)
        hintPercentage = typedArray.getString(R.styleable.TextFieldWithPercentage_text_field_with_percentage_setHintPercentage)
        price = typedArray.getFloat(R.styleable.TextFieldWithPercentage_text_field_with_percentage_setDefaultPrice, 0f)
        percent = typedArray.getInt(R.styleable.TextFieldWithPercentage_text_field_with_percentage_setDefaultPercentage, 0)
        typedArray.recycle()
    }

    fun setPercent(percent: Int) {
        this.percent = percent
        updatePercent()
    }

    private fun updatePercent() {
        when {
            percent >= 0 -> editTextPercent.editText?.apply {
                this.setText("$percent")
            }
        }
    }

    fun setPrice(price: Float) {
        this.price = price
        updatePrice()
    }

    private fun updatePrice() {
        when {
            price >= 0f -> editTextPrice.editText?.apply {
                this.setText("$price")
            }
        }
    }

    fun setHintPercentage(hint: String?) {
        this.hintPercentage = hint
        updateHintPercentage()
    }

    fun setHintPercentage(hintRes: Int) {
        this.hintPercentageRes = hintRes
        updateHintPercentage()
    }

    private fun updateHintPercentage() {
        when {
            hintPercentage != null -> editTextPercent.hint = hintPercentage
            hintPercentageRes > 0 -> editTextPercent.setHint(hintPercentageRes)
        }
    }

    fun setHintPrice(hint: String?) {
        this.hintPrice = hint
        updateHintPrice()
    }

    fun setHintPrice(hintRes: Int) {
        this.hintPriceRes = hintRes
        updateHintPrice()
    }

    private fun updateHintPrice() {
        when {
            hintPrice != null -> editTextPrice.hint = hintPrice
            hintPriceRes > 0 -> editTextPrice.setHint(hintPriceRes)
        }
    }


    override fun saveInstanceState(state: Parcelable): Parcelable {
        val ss: SavedState = onSaveInstanceChildState(SavedState(state)) as SavedState
        ss.hintPercentage = hintPercentage
        ss.hintPercentageRes = hintPercentageRes
        ss.hintPrice = hintPrice
        ss.hintPriceRes = hintPriceRes
        ss.price = price
        ss.percent = percent
        return ss
    }

    override fun restoreInstanceState(state: Parcelable) {
        val ss: SavedState = state as SavedState
        hintPercentage = ss.hintPercentage
        hintPercentageRes = ss.hintPercentageRes
        hintPrice = ss.hintPrice
        hintPriceRes = ss.hintPriceRes
        price = ss.price
        percent = ss.percent
        updateHintPrice()
        updateHintPercentage()
        updatePercent()
        updatePrice()
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private class SavedState : ChildSavedState {

        var hintPrice: String? = null
        var hintPriceRes: Int = 0
        var hintPercentage: String? = null
        var hintPercentageRes: Int = 0
        var price: Float = 0f
        var percent: Int = 0

        constructor(superState: Parcelable) : super(superState)

        constructor(parcel: Parcel, classLoader: ClassLoader) : super(parcel, classLoader) {
            hintPrice = parcel.readString()
            hintPriceRes = parcel.readInt()
            hintPercentage = parcel.readString()
            hintPercentageRes = parcel.readInt()
            price = parcel.readFloat()
            percent = parcel.readInt()
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeString(hintPrice)
            out.writeInt(hintPriceRes)
            out.writeString(hintPercentage)
            out.writeInt(hintPercentageRes)
            out.writeFloat(price)
            out.writeInt(percent)
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