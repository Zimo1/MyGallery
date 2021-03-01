package ru.yodata.mygallery.domain.repository

import dagger.Provides
import io.reactivex.Single
import ru.yodata.mygallery.domain.model.Album

interface AlbumRepository {

    fun getAlbums(): Single<List<Album>>
}