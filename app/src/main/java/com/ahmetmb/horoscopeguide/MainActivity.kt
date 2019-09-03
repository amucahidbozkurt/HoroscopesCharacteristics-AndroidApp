package com.ahmetmb.horoscopeguide 

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var allHoroscopesInfo: ArrayList<Horoscopes>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorNotificationBar));

        dataResourcePrepare()

        // BASE ADAPTER
        var adapHoros = HoroscopesBaseAdapter(this, allHoroscopesInfo)
        listHoroscopes.adapter = adapHoros
        
        listHoroscopes.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra("clickPosition", position)
            intent.putExtra("allHoroscopesInformation", allHoroscopesInfo)
            startActivity(intent)

        }

    }

    private fun dataResourcePrepare() {

        allHoroscopesInfo = ArrayList<Horoscopes>(12)

        var horoscopes = resources.getStringArray(R.array.horoscopes)
        var horoscopesDates = resources.getStringArray(R.array.horoscopesDate)
        var horoscopesImages = arrayOf(R.drawable.aries, R.drawable.taurus, R.drawable.gemini, R.drawable.cancer, R.drawable.leo, R.drawable.virgo,
            R.drawable.libra, R.drawable.scorpio, R.drawable.sagittarius, R.drawable.capricorn, R.drawable.aquarius, R.drawable.pisces)
        var horoscopesCoverImage = arrayOf(R.drawable.ariescover, R.drawable.tauruscover, R.drawable.geminicover, R.drawable.cancercover,
            R.drawable.leocover, R.drawable.virgocover, R.drawable.libracover, R.drawable.scorpiocover, R.drawable.sagittariuscover,
            R.drawable.capricorncover, R.drawable.aquariuscover, R.drawable.piscescover)
        var horoscopesInfo = resources.getStringArray(R.array.horoscopesInformation)

        for (i in 0..11) {

            var arrayListAddHoroscopes = Horoscopes(horoscopes[i], horoscopesDates[i], horoscopesImages[i], horoscopesCoverImage[i], horoscopesInfo[i])
            allHoroscopesInfo.add(arrayListAddHoroscopes)

        }
    }
}
