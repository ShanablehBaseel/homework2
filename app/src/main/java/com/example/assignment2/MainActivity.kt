package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NextPage = findViewById<Button>(R.id.NextPage)
        val SayHi = findViewById<Button>(R.id.SayHi)
        val SayHiAgain = findViewById<Button>(R.id.SayHiAgain)
        val DisplayName = findViewById<Button>(R.id.button4)
        val Name: TextView = findViewById(R.id.textView3)
        val TheName: EditText = findViewById(R.id.editTextName)


        val favoriteDrink = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        val Result: TextView = findViewById(R.id.textView2)

        val spinnerVal: Spinner = findViewById(R.id.spinner)
        spinnerVal.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, favoriteDrink)
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Result.text = favoriteDrink[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        NextPage.setOnClickListener {
            startActivity(Intent(this@MainActivity,MainActivity2::class.java))
        }

        SayHi.setOnClickListener {
            Toast.makeText(this,"Hi",Toast.LENGTH_SHORT).show()
        }

        SayHiAgain.setOnClickListener {
            Toast.makeText(this,"Hi again!!",Toast.LENGTH_SHORT).show()
        }

        DisplayName.setOnClickListener {
            Name.text = TheName.text.toString();
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.firstChoice -> Toast.makeText(this,"the plane option was selected",Toast.LENGTH_SHORT).show()
            R.id.forthChoice -> Toast.makeText(this,"the android option was selected",Toast.LENGTH_SHORT).show()
            R.id.secondChoice -> Toast.makeText(this,"Choice 2 was selected",Toast.LENGTH_SHORT).show()
            R.id.thirdChoice -> Toast.makeText(this,"Choice 3 was selected",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}