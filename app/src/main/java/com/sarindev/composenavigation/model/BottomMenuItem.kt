package com.sarindev.composenavigation.model

import com.sarindev.composenavigation.R

data class BottomMenuItem(
    val title: String,
    val route: String,
    val icon: Int
)


val Home = BottomMenuItem("Home","home", R.drawable.ic_home_24)
val Movies = BottomMenuItem("Movies","movies", R.drawable.ic_movie_24)
val Sports = BottomMenuItem("Sports","sports", R.drawable.ic_sports_24)