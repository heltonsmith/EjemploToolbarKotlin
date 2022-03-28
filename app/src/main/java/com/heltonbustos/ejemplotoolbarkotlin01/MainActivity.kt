package com.heltonbustos.ejemplotoolbarkotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.heltonbustos.ejemplotoolbarkotlin01.fragmentos.FragmentoCorreo
import com.heltonbustos.ejemplotoolbarkotlin01.fragmentos.FragmentoNotificacion

class MainActivity : AppCompatActivity() {

    val f1:FragmentoCorreo = FragmentoCorreo()
    val f2:FragmentoNotificacion = FragmentoNotificacion()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        cargarFragmento(f1)
    }

    fun cargarFragmento(f:Fragment){
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.myFrame, f)
        ft.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itCorreo -> {
                cargarFragmento(f1)
            }
            R.id.itNotificacion -> {
                cargarFragmento(f2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(applicationContext, "Click en botón atrás...", Toast.LENGTH_SHORT).show()
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}