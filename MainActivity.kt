package com.bangkit.gessel.knowyourlanguage

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.GridLanguageAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvLanguage: RecyclerView
    private var list: ArrayList<Language> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Know Your Language"

        val listArrange : ImageView = findViewById(R.id.listview)
        val gridArrange : ImageView = findViewById(R.id.gridview)

        rvLanguage = findViewById(R.id.rv_kyl)
        rvLanguage.setHasFixedSize(true)

        list.addAll(LanguageListData.listData)
        listArrange.setOnClickListener(this)
        gridArrange.setOnClickListener(this)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                        this.startActivity(intent)
            }
        }
    }

    private fun showRecyclerList() {
        rvLanguage.layoutManager = LinearLayoutManager(this)
        val listLanguageAdapter = ListLanguageAdapter(list)
        rvLanguage.adapter = listLanguageAdapter

        listLanguageAdapter.setOnItemClickCallback(object : ListLanguageAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Language) {
                showSelectedLanguage(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvLanguage.layoutManager = GridLayoutManager(this, 2)
        val gridLanguageAdapter = GridLanguageAdapter(list)
        rvLanguage.adapter = gridLanguageAdapter

        gridLanguageAdapter.setOnItemClickCallback(object : GridLanguageAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Language) {
                showSelectedLanguage(data)
            }
        })
    }

    private fun showSelectedLanguage(lang: Language) {
        Toast.makeText(this, "Kamu memilih " + lang.name, Toast.LENGTH_SHORT).show()
        val Intent = Intent(this, DetailActivity::class.java)
        Intent.putExtra("nama", lang.name)
        Intent.putExtra("designed", lang.designed)
        Intent.putExtra("developer", lang.developer)
        Intent.putExtra("extension", lang.extension)
        Intent.putExtra("release", lang.release)
        Intent.putExtra("paradigm", lang.paradigm)
        Intent.putExtra("photo", lang.photo)
        startActivity(Intent)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.listview -> {
                showRecyclerList()
            }
            R.id.gridview -> {
                showRecyclerGrid()
            }
        }
    }
}