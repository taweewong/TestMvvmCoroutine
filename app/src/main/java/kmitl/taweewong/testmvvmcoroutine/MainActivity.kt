package kmitl.taweewong.testmvvmcoroutine

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kmitl.taweewong.testmvvmcoroutine.db.AppDatabase
import kmitl.taweewong.testmvvmcoroutine.db.entity.OchayaMenu
import kmitl.taweewong.testmvvmcoroutine.viewmodel.OchayaViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {
    private lateinit var ochayaViewModel: OchayaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppDatabase.init(this@MainActivity)

//        launch {
//            loge("inserting cha")
//            val menus = listOf(OchayaMenu("cha thai", 30f),
//                    OchayaMenu("cha english", 30f),
//                    OchayaMenu("cha french", 30f),
//                    OchayaMenu("cha argentina", 30f),
//                    OchayaMenu("cha brazil", 30f))
//            AppDatabase.getInstance().ochayaMenuDao().insertOchayaMenuList(menus)
//        }

        setupViewModelSubsctiption()
        setupOnClick()
    }

    private fun setupViewModelSubsctiption() {
        ochayaViewModel = ViewModelProviders.of(this).get(OchayaViewModel::class.java)
        ochayaViewModel.loadAllOchayaMenu()

        ochayaViewModel.observableAllOchayaMenu.observe(this, Observer {
            it.forEach { ochayaMenu -> loge("${ochayaMenu.id} : ${ochayaMenu.menuName}") }
        })
    }

    private fun setupOnClick() {
        mainButton.setOnClickListener {
            startActivity<Main2Activity> { toast("Hello KTX") }
        }
        randomChaButton.setOnClickListener {
            ochayaViewModel.loadAllOchayaMenu()
        }
    }

    private fun Context.toast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(this, text, duration).apply { show() }
    }

    private fun loge(text: String) {
        Log.e("OAT_DEBUG", text)
    }

    private inline fun <reified T : Activity> Activity.startActivity(body: () -> Unit) {
        body()
        val intent = Intent(this, T::class.java)
        startActivity(intent)
    }
}
