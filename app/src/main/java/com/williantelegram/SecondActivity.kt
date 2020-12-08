package com.williantelegram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.button
import kotlinx.android.synthetic.main.activity_second.tv_id
import kotlinx.android.synthetic.main.activity_second.tv_name
import kotlinx.android.synthetic.main.activity_second.tv_year

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val user = intent.extras?.getSerializable("user") as UserData

        tv_id.setText(user.id)
        tv_name.setText(user.name)
        tv_year.setText(user.year)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val id = tv_id.text.toString()
            val name = tv_name.text.toString()
            val year = tv_year.text.toString()
            val user = UserData(id, name, year)
            intent.putExtra("user", user)
            setResult(userResultCode, intent)
            finish()
        }
    }
}