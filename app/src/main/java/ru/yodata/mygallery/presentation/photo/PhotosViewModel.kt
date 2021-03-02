package ru.yodata.mygallery.presentation.photo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.yodata.mygallery.domain.model.Photo
import ru.yodata.mygallery.domain.usecase.GetPhotosUseCase

class PhotosViewModel @ViewModelInject constructor(private val getPhotosUseCase: GetPhotosUseCase) : ViewModel() {

    private val TAG = PhotosViewModel::class.java.simpleName
    val photoListReceivedLiveData = MutableLiveData<List<Photo>>()
    val isLoad = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }


    fun loadPhotos(id: Long?) {
        if (id == null) return
        getPhotosUseCase.saveAlbumId(id)
        getPhotosUseCase.execute(
                onSuccess = {
                    isLoad.value = true
                    photoListReceivedLiveData.value = it
                },
                onError = {
                    it.printStackTrace()
                }
        )
    }
}