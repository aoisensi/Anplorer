package info.aoisensi.android.anplorer

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.aoisensi.android.anplorer.io.DeviceDrive

class ExplorerActivityFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = RecyclerView(context)
        view.adapter = FileListAdapter(context, DeviceDrive().getFileList("/"))
        view.layoutManager = LinearLayoutManager(context)
        return view
    }

    fun getRecyclerView(): RecyclerView {
        return view as RecyclerView
    }


}
