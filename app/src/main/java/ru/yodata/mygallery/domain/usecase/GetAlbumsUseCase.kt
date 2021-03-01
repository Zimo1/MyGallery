package ru.yodata.mygallery.domain.usecase

import io.reactivex.Single
import ru.yodata.mygallery.domain.model.Album
import ru.yodata.mygallery.domain.repository.AlbumRepository
import ru.yodata.mygallery.domain.usecase.base.SingleUseCase
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(private val repository: AlbumRepository)
    : SingleUseCase<List<Album>>() {

    override fun buildUseCaseSingle(): Single<List<Album>> {
        return repository.getAlbums()
    }
}