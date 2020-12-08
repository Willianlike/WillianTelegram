package com.williantelegram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.tv_id
import kotlinx.android.synthetic.main.activity_main.tv_name
import kotlinx.android.synthetic.main.activity_main.tv_year
import kotlinx.android.synthetic.main.activity_second.*

const val userResultCode = 23

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KK().gg()

        tv_id.text = "id_1"
        tv_name.text = "Алеша Попович"
        tv_year.text = "1342"
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val id = tv_id.text.toString()
            val name = tv_name.text.toString()
            val year = tv_year.text.toString()
            val user = UserData(id, name, year)
            intent.putExtra("user", user)
            startActivityForResult(intent, userResultCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != userResultCode) { return }
        val user = data?.extras?.getSerializable("user") as UserData

        tv_id.text = user.id
        tv_name.text = user.name
        tv_year.text = user.year
    }
}