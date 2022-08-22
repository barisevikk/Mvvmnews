package com.example.firestoremvvm.Di

import com.example.firestoremvvm.viewmodel.Bviewmodel

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

class Appmodule {


    @Module
    @InstallIn(SingletonComponent::class)
    class AppModule {
        @Provides
        @Singleton
        fun provideKisilerDaoRepository(refKisiler: CollectionReference): Bviewmodel {
            return Bviewmodel(refKisiler)
        }

        @Provides
        @Singleton

        fun bilimrepository(): CollectionReference {

            val db = FirebaseFirestore.getInstance()
            return db.collection("News")

        }

    }
}





