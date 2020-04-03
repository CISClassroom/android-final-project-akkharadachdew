package th.ac.kku.cis.mobileapp.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDatabase = FirebaseDatabase.getInstance().reference

        this.login1.setOnClickListener{
            val email = mUsernameTextview.text.toString()
            val password = mPasswordTextview.text.toString()

            mDatabase.child("user").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                   //ดึงข้อมูล
                    val user = dataSnapshot.children.iterator()
                    if(user.hasNext()){
                        while (user.hasNext()){
                            val user = user.next().getValue() as HashMap<String, Any>
//เช็คดาต้าเบส
                            if (user.get("email")as String == email && user.get("password")as String == password ){
                                val intent = Intent(this@MainActivity,sadasda::class.java)
                                intent.putExtra("email",email.toString())
                                startActivity(intent)
                            }
                        }
                    }
                }
                override fun onCancelled(databaseError: DatabaseError) {

                }
            })
        }
    }
}