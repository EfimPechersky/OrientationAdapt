package com.example.orientationadaptation

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var adapter: ArrayAdapter<CharSequence>
    var pict=R.drawable.car1;
    var start=0;
    val pictures= intArrayOf(R.drawable.car1,R.drawable.car2,R.drawable.car3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        adapter = ArrayAdapter.createFromResource(this, R.array.pictures, R.layout.item)
        val spinner = findViewById<Spinner>(R.id.pictures_list)

        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
        val iv = findViewById<ImageView>(R.id.picture)
        iv.setImageResource(pict)
    }
    fun onChangePictureClick(v: View) {
        val iv = findViewById<ImageView>(R.id.picture)

        // TODO: картинку менять по очереди на следущую
        iv.setImageResource(pict)

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "выбран элемент $position", Toast.LENGTH_SHORT ).show()
        // TODO: заменить картинку в зависимости от выбора пользовател
        pict=pictures[position]
        if (start==0){
            val iv = findViewById<ImageView>(R.id.picture)
            iv.setImageResource(pict)
            start=1;
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "не выбран элемент", Toast.LENGTH_SHORT ).show()
        pict=R.drawable.squarecat
    }

}