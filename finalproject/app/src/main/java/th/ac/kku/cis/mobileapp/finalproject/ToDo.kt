package com.example.myapplication

class ToDo {
    companion object Factory {
        fun create(): ToDo = ToDo()
    }
    var nameevent: String? = null  //โดลเก็บข็อมูล,บันทึกข้อมูล
    var nameevent2: String? = null
    var nameevent3: String? = null
    var nameevent4: String? = null

    var id : String? = null
}