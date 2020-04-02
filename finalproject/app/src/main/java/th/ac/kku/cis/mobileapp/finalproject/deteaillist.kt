package th.ac.kku.cis.mobileapp.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_deteaillist.*

class deteaillist : AppCompatActivity() {

    lateinit var mDatabase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deteaillist)
        mDatabase = FirebaseDatabase.getInstance().reference

        var nameevent = getIntent().getStringExtra("nameevent")
        var nameevent2 = getIntent().getStringExtra("nameevent2")
        var nameevent3 = getIntent().getStringExtra("nameevent3")
        var nameevent4 = getIntent().getStringExtra("nameevent4")

        nameeventshow.text = nameevent
        dateeventshow.text = nameevent2
        timebookingshow.text = nameevent3
        whoarebooking.text = nameevent4


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

