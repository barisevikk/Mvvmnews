package com.example.firestoremvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firestoremvvm.data.Anasayfamodell

import com.google.firebase.firestore.CollectionReference
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Bviewmodel @Inject constructor(var Databasereferance: CollectionReference):ViewModel() {
    var bilimlist=MutableLiveData<List<Anasayfamodell>>()









    fun bilimlerservice(){

        Databasereferance.addSnapshotListener { snapshot, exception ->
            if (exception != null) {


            } else {


                if (snapshot != null) {
                    if (!snapshot.isEmpty) {
                        var Listt = ArrayList<Anasayfamodell>()

                        val documents = snapshot.documents
                        for (document in documents) {
                            var baslik=document.get("baslik") as String

                            val icerik = document.get("icerik") as String
                            val image=document.get("image") as String
                            Listt.add(Anasayfamodell(baslik,icerik,image))
                            bilimlist.value = Listt
                        }
                    }
                }
            }
        }
    }


}