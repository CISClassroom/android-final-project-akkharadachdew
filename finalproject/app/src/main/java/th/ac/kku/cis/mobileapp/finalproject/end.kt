package th.ac.kku.cis.mobileapp.finalproject

    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Log
    import android.view.View
    import android.widget.ListView
    import android.widget.Toast
    import com.example.myapplication.ToDo
    import com.google.firebase.database.*

    import kotlinx.android.synthetic.main.activity_home.*
    import kotlinx.android.synthetic.main.end.*



class end : AppCompatActivity() {


        lateinit var mDatabase: DatabaseReference
        var toDoItemList: MutableList<ToDo>? = null
        lateinit var adapter: ToDoItemAdapter
        private var listViewItems: ListView? = null


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.end)


            var email = getIntent().getStringExtra("email")


            //เซ็ตข้อมูลก่อนส่ง
            mDatabase = FirebaseDatabase.getInstance().reference
            listViewItems = findViewById<View>(R.id.listshow) as ListView
            toDoItemList = mutableListOf<ToDo>()
            adapter = ToDoItemAdapter(this, toDoItemList!!)
            listViewItems!!.setAdapter(adapter)
            mDatabase.orderByKey().addListenerForSingleValueEvent(itemListener)

            //รายการที่คลิกเข้าไปดู
            listshow.setOnItemClickListener{ parent, view, position, id ->
                val intent = Intent(this,deteaillist::class.java)
                val selectedItem = parent.getItemAtPosition(position) as ToDo
                intent.putExtra("nameevent",selectedItem.nameevent.toString())
                intent.putExtra("nameevent3",selectedItem.nameevent3.toString())
                intent.putExtra("nameevent2",selectedItem.nameevent2.toString())
                intent.putExtra("nameevent4",selectedItem.nameevent4.toString())
                intent.putExtra("email",email.toString())
                startActivity(intent)
                startActivity(intent)







            }
//            Btnback.setOnClickListener{
//                val intent = Intent(this@Listdata,Home::class.java)
//                intent.putExtra("email",email.toString())
//                startActivity(intent)
//                finish()
//            }
        }


        var itemListener: ValueEventListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                addDataToList(dataSnapshot.child("dew"))
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("MainActivity", "loadItem:onCancelled", databaseError.toException())
            }


            private fun addDataToList(dataSnapshot: DataSnapshot) {
                val items = dataSnapshot.children.iterator()

                // Check if current database contains any collection
                if (items.hasNext()) {

                    // check if the collection has any to do items or not
                    while (items.hasNext()) {
                        // get current item
                        val currentItem = items.next()
                        val map = currentItem.getValue() as HashMap<String,Any>
                        // add data to object
//                        if (map.get("email") == email){
                            val todoItem = ToDo.create()
                            todoItem.nameevent = map.get("nameevent") as String
                        todoItem.nameevent2 = map.get("nameevent2") as String
                        todoItem.nameevent3 = map.get("nameevent3") as String
                        todoItem.nameevent4 = map.get("nameevent4") as String



                            toDoItemList!!.add(todoItem);
//                        }
                    }

                    adapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@end,"ไม่มีข้อมูล",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


