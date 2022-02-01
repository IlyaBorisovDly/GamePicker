package com.example.gamepicker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Status
import com.example.domain.entity.item.Item
import com.example.domain.usecase.*
import kotlinx.coroutines.launch

class SharedViewModel(
    private val getItemsUseCase: GetItemsUseCase
) : ViewModel() {

    private val _items = MutableLiveData<Status<List<Item>>>()
    val items: LiveData<Status<List<Item>>> = _items

    init {
        viewModelScope.launch {
            _items.value = loadItems()
        }
    }

    private suspend fun loadItems(): Status<List<Item>> = getItemsUseCase()

}