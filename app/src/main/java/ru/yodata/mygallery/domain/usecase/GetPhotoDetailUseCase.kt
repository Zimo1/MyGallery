package ru.yodata.mygallery.domain.usecase

import io.reactivex.Single
import ru.yodata.mygallery.domain.model.Photo
import ru.yodata.mygallery.domain.repository.PhotoRepository
import ru.yodata.mygallery.domain.usecase.base.SingleUseCase
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(private val repository: PhotoRepository)
    : SingleUseCase<Photo>() {

    private var photoId: Long? = null

    fun savePhotoId(id: Long) {
        photoId = id
    }

    override fun buildUseCaseSingle(): Single<Photo> {
        return repository.getPhotoDetail(photoId)
    }

    fun deleteAsFavorite(photo: Photo) {
        repository.deletePhoto(photo)
    }

    fun addAsFavorite(photo: Photo) {
        repository.addPhoto(photo)
    }

    fun isFavorite(photoId: Long): Boolean {
        return repository.isFavorite(photoId)
    }
}