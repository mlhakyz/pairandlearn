package com.example.pairandlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.pairandlearn.R.drawable.*
class MainActivity : AppCompatActivity() {

    lateinit var image1: Button
    lateinit var image2: Button
    lateinit var image3: Button
    lateinit var image4: Button
    lateinit var image5: Button
    lateinit var image6: Button
    lateinit var image7: Button
    lateinit var image8: Button
    lateinit var image9: Button
    lateinit var image10: Button
    lateinit var image11: Button
    lateinit var image12: Button
    lateinit var yenidenOyna: Button

    lateinit var puan: TextView
    var _number : Int = 0

    private var kontrol2 = 0 //hangi resim olduğunu kontrol etmek için



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oyun()



        }

    private fun oyun() {
        val images: MutableList<Int> =
            mutableListOf(cow, elephant,horse, lion, monkey, panda, cow, elephant, horse, lion, monkey, panda)

        image1 = findViewById(R.id.imageView)
        image2 = findViewById(R.id.imageView2)
        image3 = findViewById(R.id.imageView3)
        image4 = findViewById(R.id.imageView4)
        image5 = findViewById(R.id.imageView5)
        image6 = findViewById(R.id.imageView6)
        image7 = findViewById(R.id.imageView7)
        image8 = findViewById(R.id.imageView8)
        image9 = findViewById(R.id.imageView9)
        image10 = findViewById(R.id.imageView10)
        image11 = findViewById(R.id.imageView11)
        image12 = findViewById(R.id.imageView12)
        yenidenOyna = findViewById(R.id.button3)
        puan = findViewById(R.id.textView4)

        val buttons = arrayOf(image1, image2, image3, image4, image5, image6, image7, image8,
            image9, image10, image11, image12)

        val cardBack = oval
        var clicked = 0
        var turnOver = false
        var lastClicked = -1
        images.shuffle()
        for (i in 0..11) {
            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener {
                println("seton"+i)
                println("turnover" +turnOver)
                if (buttons[i].text == "cardBack" && !turnOver) {
                    Toast.makeText(applicationContext, "cardback", Toast.LENGTH_SHORT).show()
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if (clicked == 0) {
                        Toast.makeText(applicationContext, "clicked 0", Toast.LENGTH_SHORT).show()
                        lastClicked = i
                    }
                    clicked++
                }
                val _number = lastClicked;

                println("ilk baştaki:" + _number )

                if (clicked == 2) {
                    println("ikinci: " +i)
                    Toast.makeText(applicationContext, "clicked 2 ise", Toast.LENGTH_SHORT).show()
                    turnOver = true
                    if (buttons[i].text == buttons[lastClicked].text) {
                        Toast.makeText(applicationContext, "lastclicked", Toast.LENGTH_SHORT).show()
                        buttons[i].isClickable = false
                        buttons[lastClicked].isClickable = false
                        turnOver = false
                        clicked = 0
                    }
                    else
                    {
                        Handler(Looper.getMainLooper()).postDelayed({
                            println("Handler: " +_number)
                            buttons[_number].setBackgroundResource(cardBack)
                            buttons[_number].text = "cardBack"
                            clicked--
                            buttons[i].setBackgroundResource(cardBack)
                            buttons[i].text = "cardBack"
                            clicked--
                            turnOver = false

                        }, 400)
                    }

                } else if (clicked == 0) {
                    Toast.makeText(applicationContext, "clicked 0", Toast.LENGTH_SHORT).show()
                    turnOver = false
                }
            }
    }



        yenidenOyna.setOnClickListener {
            for (y in 0..11){
                buttons[y].setBackgroundResource(cardBack)
                buttons[y].text = "cardBack"

            }
            oyun()
        }

    }


}