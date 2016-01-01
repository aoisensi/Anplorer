package info.aoisensi.android.anplorer

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.content_explorer.*
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.floatingActionButton

class ExplorerActivity : AppCompatActivity() {

    val fragmentId = View.generateViewId()
    lateinit var viewFab: FloatingActionButton
    lateinit var viewToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = UI {
            coordinatorLayout {
                appBarLayout {
                    viewToolbar = toolbar {
                        popupTheme = R.style.AppTheme_PopupOverlay
                        backgroundColor = R.color.colorPrimary
                    }.lparams(width = matchParent, height = dip(56))
                }.lparams(width = matchParent, height = wrapContent) {  }

                frameLayout {
                    id = fragmentId
                }.lparams(width = matchParent, height = matchParent)

                viewFab = floatingActionButton {
                    imageResource = android.R.drawable.ic_dialog_email
                    onClick { view ->
                        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
                    }
                }.lparams(width = wrapContent, height = wrapContent) {
                    gravity = Gravity.END or Gravity.BOTTOM
                    margin = dip(16)
                }
            }
        }.view

        setContentView(view)
        setSupportActionBar(viewToolbar)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(fragmentId, ExplorerFragment())
                commit()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_explorer, menu)
        menu.add("Up").apply{
            setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
            setOnMenuItemClickListener {
                Snackbar.make(viewFab, "Go to Up!!", Snackbar.LENGTH_LONG).setAction("Action", null).show()
                true
            }
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
