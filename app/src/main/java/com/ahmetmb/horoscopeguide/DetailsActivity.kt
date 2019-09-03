package com.ahmetmb.horoscopeguide

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var position = intent.extras.get("clickPosition") as Int
        var allHoroscopesInformation = intent.extras.get("allHoroscopesInformation") as ArrayList<Horoscopes>

        textViewHoroscopesInformation.setText(allHoroscopesInformation.get(position).horoInform)
        header.setImageResource(allHoroscopesInformation.get(position).horoCoverImage)

        // cover image renk tonuna gore toolbar renk degistirme
        setSupportActionBar(anim_toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true) //back butonu koymak
        collapsing_toolbar.title = allHoroscopesInformation.get(position).horoNames

        var bitmap = BitmapFactory.decodeResource(resources, allHoroscopesInformation.get(position).horoCoverImage)
        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {

                var mutedColor = palette?.getVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(mutedColor!!)
                window.statusBarColor = mutedColor

            }

        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
