package info.aoisensi.android.anplorer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.aoisensi.android.anplorer.io.DeviceDrive
import info.aoisensi.android.anplorer.io.IFile
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView

class ExplorerFragment : Fragment(), FileListAdapter.OnFileClickListener {
    var adapter: FileListAdapter
        get() = viewRecycler.adapter as FileListAdapter
        set(adapter) { viewRecycler.adapter = adapter }

    lateinit var viewRecycler: RecyclerView
    lateinit var viewNoPermission: View
    lateinit var viewEmpty: View
    lateinit var viewLoading: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = UI {
            frameLayout {
                viewRecycler = recyclerView {
                    this.adapter = FileListAdapter(context, this@ExplorerFragment)
                    layoutManager = LinearLayoutManager(context)
                    visibility = View.GONE
                }
                viewNoPermission = textView("no permission") {
                    visibility = View.GONE
                }
                viewEmpty = textView("empty") {
                    visibility = View.GONE
                }
                viewLoading = textView("loading") {
                    visibility = View.VISIBLE
                }
            }
        }.view
        return view
    }

    override fun onStart() {
        currentDirectory = DeviceDrive().getRootDirectory()
        super.onStart()
    }

    override fun OnFileClickListener(file: IFile) {
        currentDirectory = file
    }

    var currentDirectory: IFile = DeviceDrive().getRootDirectory()
        set(file) {
            if(file.isDirectory()) {
                val files = file.getFileList()
                if(files == null) {
                    switchView(viewNoPermission)
                    return
                }
                if(files.size == 0) {
                    switchView(viewEmpty)
                    return
                }
                adapter.files = files
                switchView(viewRecycler)
                adapter.notifyDataSetChanged()
            }
        }

    fun switchView(view: View) {
        val f = fun(v: View) = if(v == view) View.VISIBLE else View.GONE
        viewRecycler.visibility = f(viewRecycler)
        viewNoPermission.visibility = f(viewNoPermission)
        viewEmpty.visibility = f(viewEmpty)
        viewLoading.visibility = f(viewLoading)
    }
}
