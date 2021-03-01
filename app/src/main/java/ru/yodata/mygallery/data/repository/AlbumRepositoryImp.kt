package ru.yodata.mygallery.data.repository

import io.reactivex.Single
import ru.yodata.mygallery.data.source.remote.RetrofitService
import ru.yodata.mygallery.domain.model.Album
import ru.yodata.mygallery.domain.repository.AlbumRepository

class AlbumRepositoryImp(
    private val retrofitService: RetrofitService
) :
    AlbumRepository {

    override fun getAlbums(): Single<List<Album>> {
        return retrofitService.getAlbums()
    }


}