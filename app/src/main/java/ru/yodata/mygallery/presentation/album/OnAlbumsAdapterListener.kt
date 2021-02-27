package ru.yodata.mygallery.presentation.album

import ru.yodata.mygallery.domain.model.Album

interface OnAlbumsAdapterListener {

    fun showPhotos(album: Album)

}