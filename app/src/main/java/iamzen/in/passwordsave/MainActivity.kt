package iamzen.`in`.passwordsave

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), PassWordDelete {

    private val mAdapter = PassWordTableAdapter(this,this)
    private val viewModel:PassWordViewModel by lazy { ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))[PassWordViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter
        viewModel.allWords.observe(this,{list ->
            list?.let{
                mAdapter.update(it)
            }
        })

        fab.setOnClickListener{
            Log.d(TAG,"fab is clicked")
            val intent = Intent(this,SubmitPassWord::class.java)
            startActivity(intent)

        }

    }

    override fun deleteButton(passWord: PassWordTable) {
        viewModel.deletePassWord(passWord)
    }

}