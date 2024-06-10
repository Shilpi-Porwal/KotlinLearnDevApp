package com.example.kotlinlearndevapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.example.kotlinlearndevapp.Fragments.FragmentA
import com.example.kotlinlearndevapp.Fragments.FragmentB
import com.example.kotlinlearndevapp.Interface.Communicator
import com.example.kotlinlearndevapp.databinding.ActivityMainBinding
import com.example.kotlinlearndevapp.ui.theme.KotlinLearnDevAppTheme

class MainActivity : AppCompatActivity() ,Communicator{
   lateinit var binding : ActivityMainBinding
   var name1:String = "Vijay"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
       // setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext,"onCreate",Toast.LENGTH_SHORT).show()
        binding.button1.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("name",name1)
           // intent.putExtra("key",1)
            startActivity(intent);
        }

        val fragmentA = FragmentA();
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view,fragmentA)
        fragmentTransaction.commit()
        binding.button2.setOnClickListener {
           // replace(FragmentA())
        }







    }



    private fun replace(fragment: FragmentA){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view,fragment)
        fragmentTransaction.commit()
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext,"onStart",Toast.LENGTH_SHORT).show()

    }


    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext,"onResume",Toast.LENGTH_SHORT).show()

    }


    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext,"onPause",Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext,"onStop",Toast.LENGTH_SHORT).show()

    }


    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"onDestroy",Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()
       Toast.makeText(applicationContext,"onRestart",Toast.LENGTH_SHORT).show()
    }

    override fun passData(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("message",editTextInput)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentB = FragmentB()
        fragmentB.arguments = bundle
        transaction.replace(R.id.fragment_container_view,fragmentB)
        transaction.commit()
    }


}

