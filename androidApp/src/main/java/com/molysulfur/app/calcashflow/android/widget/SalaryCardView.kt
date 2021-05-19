package com.molysulfur.app.calcashflow.android.widget

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import com.molysulfur.app.calcashflow.android.R
import com.molysulfur.app.calcashflow.android.widget.common.BaseViewGroup
import kotlinx.android.synthetic.main.calcashflow_widget_card_salary.view.*

class SalaryCardView : BaseViewGroup {

    private var iconRes: Int = 0
    private var title: String? = null
    private var titleRes: Int = 0
    private var name: String? = null
    private var nameRes: Int = 0
    private var salary: Float = 0f

    var onSettingClick: (() -> Unit)? = null
    override fun setup() {
        updateIcon()
        updateTitle()
        updateName()
        updateSalary()
        calcashflow_salary_card_img_setting.setOnClickListener {
            onSettingClick?.invoke()
        }
    }

    fun setSalary(salary: Float) {
        this.salary = salary
        updateSalary()
    }

    @SuppressLint("SetTextI18n")
    private fun updateSalary() {
        calcashflow_salary_card_text_salary.text = "$salary B"
    }


    fun setName(name: String?) {
        this.name = name
        updateName()
    }

    fun setName(nameRes: Int) {
        this.nameRes = nameRes
        updateName()
    }

    private fun updateName() {
        when {
            name != null -> calcashflow_salary_card_text_name.text = name
            nameRes > 0 -> calcashflow_salary_card_text_name.setText(nameRes)
        }
    }


    fun setTitle(title: String?) {
        this.title = title
        updateTitle()
    }

    fun setTitle(titleRes: Int) {
        this.titleRes = titleRes
        updateTitle()
    }

    private fun updateTitle() {
        when {
            title != null -> calcashflow_salary_card_text_title.text = title
            titleRes > 0 -> calcashflow_salary_card_text_title.setText(titleRes)
        }
    }

    fun setIcon(res: Int) {
        this.iconRes = res
        updateIcon()
    }

    private fun updateIcon() {
        if (iconRes > 0) {
            calcashflow_salary_card_img_icon.setImageResource(iconRes)
        }
    }

    override fun getLayoutResource(): Int = R.layout.calcashflow_widget_card_salary

    override fun setupStyleables(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SalaryCardView)
        iconRes = typedArray.getResourceId(R.styleable.SalaryCardView_salary_card_setIcon, 0)
        title = typedArray.getString(R.styleable.SalaryCardView_salary_card_setTitle)
        name = typedArray.getString(R.styleable.SalaryCardView_salary_card_setName)
        salary = typedArray.getFloat(R.styleable.SalaryCardView_salary_card_setSalary, 0f)
        typedArray.recycle()
    }

    override fun saveInstanceState(state: Parcelable): Parcelable {
        val ss: SavedState = onSaveInstanceChildState(SavedState(state)) as SavedState
        ss.iconRes = iconRes
        ss.title = title
        ss.titleRes = titleRes
        ss.name = name
        ss.nameRes = nameRes
        ss.salary = salary
        return ss
    }

    override fun restoreInstanceState(state: Parcelable) {
        val ss = state as SavedState
        iconRes = ss.iconRes
        title = ss.title
        titleRes = ss.titleRes
        name = ss.name
        nameRes = ss.nameRes
        salary = ss.salary
        updateIcon()
        updateTitle()
        updateName()
        updateSalary()
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private class SavedState : ChildSavedState {

        var iconRes: Int = 0
        var title: String? = null
        var titleRes: Int = 0
        var name: String? = null
        var nameRes: Int = 0
        var salary: Float = 0f

        constructor(superState: Parcelable) : super(superState)

        constructor(parcel: Parcel, classLoader: ClassLoader) : super(parcel, classLoader) {
            iconRes = parcel.readInt()
            title = parcel.readString()
            titleRes = parcel.readInt()
            name = parcel.readString()
            nameRes = parcel.readInt()
            salary = parcel.readFloat()
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeInt(iconRes)
            out.writeString(title)
            out.writeInt(titleRes)
            out.writeString(name)
            out.writeInt(nameRes)
            out.writeFloat(salary)
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