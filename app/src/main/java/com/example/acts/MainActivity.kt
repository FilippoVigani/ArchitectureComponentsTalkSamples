package com.example.acts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.acts.counter.CounterFragment

class MainActivity : AppCompatActivity() {

    private val mainFragment: CounterFragment by lazy { CounterFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.commit {
                add(R.id.mainView, mainFragment)
            }
        }

    }
}
