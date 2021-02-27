package ru.yodata.mygallery.presentation.gallery

import android.widget.ImageView
import ru.yodata.mygallery.domain.model.Album

interface OnGalleryCallback {
    fun navigateToAlbumPage(album: Album)

    fun gotoDetailPageByPhotoId(imageView: ImageView, id: Long)
}