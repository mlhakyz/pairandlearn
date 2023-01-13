package com.example.pairandlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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

    lateinit var textview: TextView

    private var kontrol2 = 0 //hangi resim olduğunu kontrol etmek için

    val images: MutableList<Int> =
        mutableListOf(cow, elephant,horse, lion, monkey, panda, cow, elephant, horse, lion, monkey, panda)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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


        val buttons = arrayOf(image1, image2, image3, image4, image5, image6, image7, image8,
            image9, image10, image11, image12)

        val cardBack = oval
        var clicked = 0
        var turnOver = false
        var lastClicked = -1

        images.shuffle()
        for(i in 0..11){
            buttons[i].setBackgroundResource(cardBack)
            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener {

                if (buttons[i].text == "cardBack" && !turnOver) {
                    Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if (clicked == 0) {
                        Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()

                        lastClicked = i
                    }
                    clicked++
                } else if (buttons[i].text !in "cardBack") {
                    Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()

                    buttons[i].setBackgroundResource(cardBack)
                    buttons[i].text = "cardBack"
                    clicked--
                }

                if (clicked == 2) {
                    Toast.makeText(this, "4" , Toast.LENGTH_SHORT).show()
                    Handler().postDelayed({buttons[12].setBackgroundResource(cardBack)},400)
                    turnOver = true
                    if (buttons[i].text == buttons[lastClicked].text) {
                        Toast.makeText(this, "5", Toast.LENGTH_SHORT).show()

                        buttons[i].isClickable = false
                        buttons[lastClicked].isClickable = false
                        turnOver = false
                        clicked = 0
                    }
                } else if (clicked == 0) {
                    Toast.makeText(this, "6", Toast.LENGTH_SHORT).show()

                    turnOver = false
                }
            }
        }
    }
    fun yenidenOyna(view: View?) {
        images.shuffle()
    }
}