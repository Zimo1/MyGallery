package ru.yodata.mygallery.presentation.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.yodata.mygallery.domain.model.Photo

class PhotoViewModel(val photo: Photo) : ViewModel() {

    private val TAG = PhotoViewModel::class.java.name
    val photoData = MutableLiveData<Photo>()

    init {
        photoData.value = photo
    }

}