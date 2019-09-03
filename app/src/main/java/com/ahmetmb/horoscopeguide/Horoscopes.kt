package com.ahmetmb.horoscopeguide

import java.io.Serializable

data class Horoscopes(var horoNames: String, var horoDates: String, var horoImages: Int, var horoCoverImage: Int, var horoInform: String): Serializable {
}