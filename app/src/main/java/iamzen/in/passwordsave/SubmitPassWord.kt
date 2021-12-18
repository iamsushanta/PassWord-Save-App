package iamzen.`in`.passwordsave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

class SubmitPassWord : AppCompatActivity() {


    val viewModel:PassWordViewModel by lazy { ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application)).get(PassWordViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_pass_word)
        val inputName = findViewById<EditText>(R.id.enterName)
        val inputPassWord = findViewById<EditText>(R.id.enterPassWord)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            if(inputName.text.isNotEmpty() && inputPassWord.text.isNotEmpty()){
                viewModel.insertNote(PassWordTable(inputName.text.toString(),inputPassWord.text.toString()))
            }

            startActivity(intent)
        }

    }
}