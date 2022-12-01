package com.beyondthecode.cade.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beyondthecode.cade.R
import com.beyondthecode.cade.clases.MyToolBar

class Matricula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matricula)
        MyToolBar().showATool(this, "", true)
    }
}