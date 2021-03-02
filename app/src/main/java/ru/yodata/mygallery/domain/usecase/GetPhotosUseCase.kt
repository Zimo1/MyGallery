package ru.yodata.mygallery.domain.usecase

import io.reactivex.Single
import ru.yodata.mygallery.domain.model.Photo
import ru.yodata.mygallery.domain.repository.PhotoRepository
import ru.yodata.mygallery.domain.usecase.base.SingleUseCase
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(private val repository: PhotoRepository) : SingleUseCase<List<Photo>>() {

    private var albumId: Long? = null

    fun saveAlbumId(id: Long) {
        albumId = id
    }

    override fun buildUseCaseSingle(): Single<List<Photo>> {
        return repository.getPhotos(albumId)
    }
}