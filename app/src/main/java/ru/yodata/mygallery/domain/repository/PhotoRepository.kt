package ru.yodata.mygallery.domain.repository

import io.reactivex.Single
import ru.yodata.mygallery.domain.model.Photo

interface PhotoRepository {

    fun getPhotos(albumId: Long?): Single<List<Photo>>

    fun getPhotoDetail(photoId: Long?): Single<Photo>

    fun deletePhoto(photo: Photo)

    fun addPhoto(photo: Photo)

    fun isFavorite(photoId: Long): Boolean
}