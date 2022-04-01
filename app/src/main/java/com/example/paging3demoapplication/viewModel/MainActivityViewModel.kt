package com.example.paging3demoapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging3demoapplication.model.data.CharacterData
import com.example.paging3demoapplication.model.network.RetroInstance
import com.example.paging3demoapplication.model.network.RetroService
import com.example.paging3demoapplication.model.repository.CharacterPagingSource
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel: ViewModel() {

    var retroService: RetroService = RetroInstance.getRetroInstance().create(RetroService::class.java)

    fun getListData(): Flow<PagingData<CharacterData>> {
        return Pager (config = PagingConfig(pageSize = 20, maxSize = 200),
            pagingSourceFactory = { CharacterPagingSource(retroService) }).flow.cachedIn(viewModelScope)
    }
}