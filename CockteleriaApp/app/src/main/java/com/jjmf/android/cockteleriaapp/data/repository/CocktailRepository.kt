package com.jjmf.android.cockteleriaapp.data.repository

import com.google.firebase.firestore.CollectionReference
import com.jjmf.android.cockteleriaapp.data.module.FirebaseModule
import com.jjmf.android.cockteleriaapp.domain.model.Cocktail
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

interface CocktailRepository {
    suspend fun get(id:String) : Cocktail?
    suspend fun getListFlow() : Flow<List<Cocktail>>
    suspend fun insert(cocktail: Cocktail)
}

class CocktailRepositoryImpl @Inject constructor(
    @FirebaseModule.CocktailsCollection private val fb:CollectionReference
) : CocktailRepository{
    override suspend fun get(id: String): Cocktail? {
        return fb.document(id).get().await().toObject(Cocktail::class.java)
    }

    override suspend fun getListFlow(): Flow<List<Cocktail>> = callbackFlow{
        val listado = fb.addSnapshotListener{sna, _->
            val lista = mutableListOf<Cocktail>()
            for (i in sna!!.documents) {
                val product = i.toObject(Cocktail::class.java)
                product!!.id = i.id
                lista.add(product)
            }
            trySend(lista).isSuccess
        }
        awaitClose{listado.remove()}
    }

    override suspend fun insert(cocktail: Cocktail) {
        fb.add(cocktail).await()
    }
}