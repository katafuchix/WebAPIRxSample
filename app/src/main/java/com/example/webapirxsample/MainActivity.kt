package com.example.webapirxsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.webapirxsample.view.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.detailContainer, MainFragment.createInstance() )
            transaction.commit()
        }
    }
}
