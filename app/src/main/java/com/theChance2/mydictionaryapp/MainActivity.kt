package com.theChance2.mydictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        runOnUiThread{
            Network.makeRequestUsingOkhttp()
        }
        playWithFlow()
    }
    private fun playWithFlow() {
        val flow = flow {
            emit(UrlModifier.getUrl("hello bitch","en","fr"))
        }.flowOn(Dispatchers.IO)
        binding.clickMe.setOnClickListener { lifecycleScope.launch {
            flow.buffer().collect {
                delay(2000)
                binding.translate.text = Network.result
            }
        } }
    }
}