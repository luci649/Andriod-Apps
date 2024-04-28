package com.example.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
