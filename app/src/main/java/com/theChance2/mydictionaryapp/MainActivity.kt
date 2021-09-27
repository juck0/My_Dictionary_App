package com.theChance2.mydictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.theChance2.mydictionaryapp.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
           playWithFlow()
//        runOnUiThread{
//            Network.makeRequestUsingOkhttp()
//        }



    }

    private fun playWithFlow() {
        val languages = resources.getStringArray(R.array.source_lang)
        val arrayAdapterSourceLang = ArrayAdapter(this, R.layout.item_source, languages)
        binding.autoCompleteTextView.setAdapter(arrayAdapterSourceLang)
        val arrayAdapterTargetLang = ArrayAdapter(this, R.layout.item_source, languages)

        binding.autoCompleteTextView2.setAdapter(arrayAdapterTargetLang)
        val flow = flow {
            emit(UrlModifier.getUrl("hello bitch","en","fr"))
        }.flowOn(Dispatchers.IO)
        binding.clickMe.setOnClickListener { lifecycleScope.launch {
            flow.buffer().collect {
                delay(2000)
                binding.translate.text = Network.result
                Log.i("Aymn" , "$languages")
            }
        } }
    }
}