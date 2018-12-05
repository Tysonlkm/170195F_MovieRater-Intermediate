package movierater.it2107.sit.nyp.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.content.Intent
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_landing_page.*

class landing_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        tvMain.text="You have not added a movie" + "\n" + "Long press me to add a movie"
        registerForContextMenu(tvMain)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        if(v?.id ==R.id.tvMain) {
         menu?.add(1, 1001, 1, "Add")
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId== 1001){
            val movieAdd= Intent(applicationContext,add_Movie::class.java)
            startActivity(movieAdd)
        }
        return super.onContextItemSelected(item)
    }
}
