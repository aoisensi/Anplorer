package info.aoisensi.android.anplorer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import info.aoisensi.android.anplorer.io.IFile

class FileListAdapter(val context: Context, val files: List<IFile>): RecyclerView.Adapter<FileListAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
        ViewHolder(layoutInflater.inflate(R.layout.item_explorer_file, parent, false))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder as ViewHolder
        val file = files[position]
        holder.name.text = file.getName()
    }

    override fun getItemCount() = files.size

    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById(R.id.name) as TextView
    }
}