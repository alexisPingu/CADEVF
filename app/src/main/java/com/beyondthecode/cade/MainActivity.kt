package com.beyondthecode.cade


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.beyondthecode.cade.fragments.FragmentCalificacion
import com.beyondthecode.cade.fragments.FragmentCarga
import com.beyondthecode.cade.fragments.FragmentInformacion
import com.beyondthecode.cade.fragments.FragmentNotificacion
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toogle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Layout de Navigation Drawer
        drawerLayout=findViewById(R.id.drawerLayout)
        //El Navigation Drawer
        val navView: NavigationView =findViewById(R.id.nav_view)

        toogle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            it.isChecked=true
            when(it.itemId){
                R.id.item_informacion->{ remplaceFragment(FragmentInformacion(),it.title.toString()) }
                R.id.item_calificacion->{ remplaceFragment(FragmentCalificacion(),it.title.toString()) }
                R.id.item_carga->{ remplaceFragment(FragmentCarga(),it.title.toString()) }
                R.id.item_notificacion->{ remplaceFragment(FragmentNotificacion(),it.title.toString()) }
                R.id.item_cerrar->{finish()}
            }
            true
        }
    }
    private fun remplaceFragment(fragment: Fragment, title:String){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}