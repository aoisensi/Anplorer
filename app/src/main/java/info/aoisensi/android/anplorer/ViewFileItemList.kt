package info.aoisensi.android.anplorer

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import info.aoisensi.android.anplorer.io.IFile
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.dip
import org.jetbrains.anko.textView

public class ViewFileItemList: LinearLayout {

    private lateinit var name: TextView
    var file: IFile?
        set(file: IFile?) {
            name.text = file?.getName()
        }
        get() = file

    constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0):
            super(context, attrs, defStyleAttr, defStyleRes) {
        AnkoContext.createDelegate(this).apply {
            name = textView {
                height = dip(48)
            }
        }
    }
}