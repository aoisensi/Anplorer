package info.aoisensi.android.anplorer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import info.aoisensi.android.anplorer.io.IFile

class FileListAdapter(val context: Context, val listener: OnFileClickListener):
        RecyclerView.Adapter<FileListAdapter.ViewHolder>() {

    var files: List<IFile> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val view = ViewFileItemList(context)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder as ViewHolder
        val file = files[position]
        holder.view.setOnClickListener {
            listener.OnFileClickListener(files[position])
        }
        holder.bind(file)
    }

    override fun getItemCount() = files.size

    public class ViewHolder(val view: ViewFileItemList) : RecyclerView.ViewHolder(view) {
        fun bind(file: IFile) { view.file = file }
    }

    interface OnFileClickListener {
        fun OnFileClickListener(file: IFile)
    }
}