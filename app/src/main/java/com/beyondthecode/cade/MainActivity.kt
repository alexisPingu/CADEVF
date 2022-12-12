package com.beyondthecode.cade


import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.beyondthecode.cade.api.modelos.AlumnoDto
import com.beyondthecode.cade.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toogle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    var alumnoDto: AlumnoDto? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Layout de Navigation Drawer
        drawerLayout = findViewById(R.id.drawerLayout)
        //El Navigation Drawer
        val navView: NavigationView = binding.navView
        //recibe datos
        val extras = intent.extras
        if (extras != null) {
            alumnoDto = intent.extras!!.getSerializable("serial") as AlumnoDto?
            Toast.makeText(applicationContext, "" + alumnoDto?.nombreAlumno, Toast.LENGTH_SHORT)
                .show()
            val headNom = navView.getHeaderView(0).findViewById<TextView>(R.id.nameid)
            headNom.text = alumnoDto?.nombreAlumno

            val headStatus = navView.getHeaderView(0).findViewById<TextView>(R.id.user_name)
            headStatus.text = "status: activo"

            val headMatricula = navView.getHeaderView(0).findViewById<TextView>(R.id.user_matricula)
            headMatricula.text = "matricula: ${alumnoDto?.id}"

            val headCarrera = navView.getHeaderView(0).findViewById<TextView>(R.id.user_carrera)
            headCarrera.text = "carrera: ${alumnoDto?.claveCarreraFk}"
        }

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        val drawerLayout: DrawerLayout = binding.drawerLayout

        val navController = findNavController(R.id.frame)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        setupActionBarWithNavController(navController)
        navView.setupWithNavController(navController)
    }
    private fun remplaceFragment(fragment: Fragment, title:String){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
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