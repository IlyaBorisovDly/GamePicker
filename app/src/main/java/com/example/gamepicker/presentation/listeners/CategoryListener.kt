package com.example.gamepicker.presentation.listeners

import com.example.domain.entities.enums.Category

interface CategoryListener {

    fun onCategoryClicked(category: Category)

}