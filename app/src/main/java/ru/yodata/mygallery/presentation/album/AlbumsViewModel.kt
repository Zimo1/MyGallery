package ru.yodata.mygallery.presentation.album

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.yodata.mygallery.domain.model.Album
import ru.yodata.mygallery.domain.usecase.GetAlbumsUseCase

class AlbumsViewModel @ViewModelInject constructor(private val getAlbumListUseCase: GetAlbumsUseCase)
    : ViewModel() {

    private val TAG = AlbumsViewModel::class.java.simpleName
    val albumsReceivedLiveData = MutableLiveData<List<Album>>()
    val isLoad = MutableLiveData<Boolean>()
    val albumData = MutableLiveData<Album>()

    init {
        isLoad.value = false
    }

    val album: Album? get() = albumData.value

    fun set(album: Album) = run { albumData.value = album }

    fun loadAlbums() {
        getAlbumListUseCase.execute(
            onSuccess = {
                isLoad.value = true
                albumsReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}