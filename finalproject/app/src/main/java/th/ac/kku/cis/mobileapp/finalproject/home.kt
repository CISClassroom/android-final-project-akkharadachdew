package th.ac.kku.cis.mobileapp.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.myapplication.ToDo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {
    lateinit var mDatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var email = getIntent().getStringExtra("email")
        name.text = email.toString()
        mDatabase = FirebaseDatabase.getInstance().reference

        val spinner: Spinner = findViewById(R.id.spinner)
        val arrayList: ArrayList<String> = ArrayList()
        arrayList.add("มกราคม")
        arrayList.add("กุมภาพันธ์")
        arrayList.add("เมษายน")
        arrayList.add("พฤษภาคม")
        arrayList.add("มิถุนายน")
        arrayList.add("กรกฎาคม")
        arrayList.add("สิงหาคม")
        arrayList.add("กันยายน")
        arrayList.add("ตุลาคม")
        arrayList.add("ตพฤศจิกายน")
        arrayList.add("ธันวาคม")
        val arrayAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList)
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter

        button2.setOnClickListener{
            savedata()
            //startActivity(Intent(this@home,sadasda::class.java))
        }
    }
    private fun savedata() {
        var nameevent = editText4.text.toString().trim()
        var nameevent2 = editText6.text.toString().trim()
        var nameevent3 = spinner.selectedItem.toString().trim()
        var nameevent4 = editText7.text.toString().trim()

        var todoItem = ToDo.create()
        val newItem = mDatabase.child("dew").push()
        todoItem.id = newItem.key
        todoItem.nameevent = nameevent
        todoItem.nameevent2 = nameevent2
        todoItem.nameevent3 = nameevent3
        todoItem.nameevent4 = nameevent4

        newItem.setValue(todoItem)
//        finish()
    }

}