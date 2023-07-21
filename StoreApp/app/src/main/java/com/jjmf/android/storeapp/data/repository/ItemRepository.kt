package com.jjmf.android.storeapp.data.repository

import com.jjmf.android.storeapp.data.server.interfaces.ApiInterface
import javax.inject.Inject

interface ItemRepository {

}

class ItemRepositoryImpl @Inject constructor(
    private val api:ApiInterface
) : ItemRepository{

}