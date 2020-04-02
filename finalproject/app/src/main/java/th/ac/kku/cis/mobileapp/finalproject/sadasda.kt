package th.ac.kku.cis.mobileapp.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sadasda.*

class sadasda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sadasda)

        var email = getIntent().getStringExtra("email")
        name.text = email.toString()


        button.setOnClickListener {
            val intent = Intent(this@sadasda, home::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this@sadasda,end::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}
