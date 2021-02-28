package ru.yodata.mygallery.presentation.album

import androidx.lifecycle.MutableLiveData
import ru.yodata.mygallery.domain.model.Album

class AlbumViewModel(val album: Album) {

    val albumData = MutableLiveData<Album>()

    init {
        albumData.value = album
    }

}