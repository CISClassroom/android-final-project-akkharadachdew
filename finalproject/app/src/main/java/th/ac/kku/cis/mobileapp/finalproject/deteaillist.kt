package th.ac.kku.cis.mobileapp.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_deteaillist.*
import kotlinx.android.synthetic.main.activity_home.*

class deteaillist : AppCompatActivity() {

    lateinit var mDatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deteaillist)
        mDatabase = FirebaseDatabase.getInstance().reference

        var email = getIntent().getStringExtra("email") //รับemail
        textView8.text = email.toString()

        var nameevent = getIntent().getStringExtra("nameevent")  //รับข้อมูลจากที่ส่งมา
        var nameevent2 = getIntent().getStringExtra("nameevent2")
        var nameevent3 = getIntent().getStringExtra("nameevent3")
        var nameevent4 = getIntent().getStringExtra("nameevent4")

        show1.text = nameevent
        show2.text = nameevent2  //แสดง
        show3.text = nameevent3
        show4.text = nameevent4


//
//        Btndelect.setOnClickListener{
//            mDatabase.child("BookingGym").child(id).removeValue()
//            Toast.makeText(this,"Delect Successful",Toast.LENGTH_SHORT).show()
//            val intent = Intent(this@deteaillist,end::class.java)
//            intent.putExtra("email",email.toString())
//            startActivity(intent)
//            finish()
        }
    }

