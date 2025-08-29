package com.ayudantia.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayudantia.myapplication.adapter.UserAdapter
import com.ayudantia.myapplication.service.UserService
import com.ayudantia.myapplication.service.UserServiceFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    //Creamos las variables
    private lateinit var recyclerView: RecyclerView
    private lateinit var userService: UserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declaramos las variables con sus significados
        recyclerView=findViewById(R.id.listaUsuarios)
        recyclerView.layoutManager=LinearLayoutManager(this)
        userService=UserServiceFactory.makeUserService()

        //Bloque de codigo para funciones async
        lifecycleScope.launch {
            println(userService.getAllUsers())
            rellenarDatosApi()
        }
    }

    //Funcion "Async"
    private suspend fun rellenarDatosApi(){
        recyclerView.adapter=UserAdapter(userService.getAllUsers())
    }
}