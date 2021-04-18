package com.hfad.ad4assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.ad4assignment2.databinding.ActivityMainBinding
import com.hfad.ad4assignment2.extensions.loadImage
import com.hfad.ad4assignment2.extensions.showMessage

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding
    private var arrayUrl = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arrayUrl.add("https://thaipbs-world.s3.ap-southeast-1.amazonaws.com/thaipbsworld/wp-content/uploads/2019/11/27123605/hanuman.jpg")
        arrayUrl.add("https://upload.wikimedia.org/wikipedia/commons/d/d0/Fsb_alpha_group.jpg")
        arrayUrl.add("https://lastday.club/wp-content/uploads/2015/12/SAS-Cpetsnaz-vooruzhyonnyh-sil-Velikobritanii-Last-Day-Club.jpg")
        arrayUrl.add("https://static.dw.com/image/42146765_101.jpg")
        arrayUrl.add("https://upload.wikimedia.org/wikipedia/commons/6/6d/GIGN_HK416.jpg")

        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
        

        ui.submit.setOnClickListener {
            if (!ui.editText.editText?.text.isNullOrBlank()) {
                arrayUrl.add(ui.editText.editText?.text.toString())
                showMessage(ui.editText.editText?.text.toString())
            }
        }

        ui.btnRandom.setOnClickListener {
            if (!arrayUrl.isNullOrEmpty()) {
                val url = arrayUrl.random()
                ui.imageView.loadImage(this, url)
            }
        }
    }
}