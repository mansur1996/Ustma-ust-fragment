package com.example.fragment_ustmaust.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragment_ustmaust.R
import com.example.fragment_ustmaust.fragment.FirstFragment
import com.example.fragment_ustmaust.fragment.SecondFragment
import com.example.fragment_ustmaust.fragment.ThirdFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews(){
        findViewById<Button>(R.id.btn_first).setOnClickListener(View.OnClickListener { replaceFragment(FirstFragment()) })
        findViewById<Button>(R.id.btn_second).setOnClickListener(View.OnClickListener { replaceFragment(SecondFragment()) })
        findViewById<Button>(R.id.btn_third).setOnClickListener(View.OnClickListener { replaceFragment(ThirdFragment()) })
    }

    private fun replaceFragment(fragment: Fragment){
        val backStateName = fragment.javaClass.name
        val manager = supportFragmentManager
        val fragmentPopped = manager.popBackStackImmediate(backStateName,0)

        if(!fragmentPopped){
            //fragment not in back stack, create it.
            val ft = manager.beginTransaction().replace(R.id.frL_main,fragment)
            ft.addToBackStack(backStateName).commit()
        }

    }
}