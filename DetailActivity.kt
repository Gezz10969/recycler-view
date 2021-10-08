package com.bangkit.gessel.knowyourlanguage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Here is the Detail"

        val namaLanguage= intent.getStringExtra("nama")
        val namaDeveloper = intent.getStringExtra("developer")
        val namaDesigner = intent.getStringExtra("designed")
        val namaExtension = intent.getStringExtra("extension")
        val dateRelease = intent.getStringExtra("release")
        val paradigmList = intent.getStringExtra("paradigm")
        val photo = intent.getIntExtra("photo", 0)

        val tvNama = findViewById<TextView>(R.id.nameph)
        val tvDeveloper = findViewById<TextView>(R.id.devph)
        val tvDesigner = findViewById<TextView>(R.id.desph)
        val tvExtension = findViewById<TextView>(R.id.exph)
        val tvRelease = findViewById<TextView>(R.id.releaseph)
        val tvParadigm = findViewById<TextView>(R.id.paradigmph)
        val textViewFoto = findViewById<ImageView>(R.id.img_item_photo)
        tvNama.text = namaLanguage
        tvDeveloper.text = namaDeveloper
        tvDesigner.text = namaDesigner
        tvExtension.text = namaExtension
        tvRelease.text = dateRelease
        tvParadigm.text = paradigmList
        textViewFoto.setImageResource(photo)
    }
}