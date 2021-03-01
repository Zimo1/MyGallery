package ru.yodata.mygallery.data.source.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.yodata.mygallery.domain.model.Album
import ru.yodata.mygallery.domain.model.Photo

interface RetrofitService {

    @GET("albums/")
    fun getAlbums(): Single<List<Album>>

    @GET("albums/{id}/photos")
    fun getPhotos(@Path("id") id: Long): Single<List<Photo>>

    @GET("photos/{id}")
    fun getPhotoDetail(@Path("id") id: Long): Single<Photo>
}