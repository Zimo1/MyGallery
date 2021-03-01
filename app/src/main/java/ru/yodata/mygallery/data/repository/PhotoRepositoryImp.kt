package ru.yodata.mygallery.data.repository

import io.reactivex.Single
import ru.yodata.mygallery.data.source.local.AppDatabase
import ru.yodata.mygallery.data.source.remote.RetrofitService
import ru.yodata.mygallery.domain.model.Photo
import ru.yodata.mygallery.domain.repository.PhotoRepository

class PhotoRepositoryImp(
    private val database: AppDatabase,
    private val retrofitService: RetrofitService
) : PhotoRepository {

    override fun isFavorite(photoId: Long): Boolean {
        val loadOneByPhotoId = database.photoDao.loadOneByPhotoId(photoId)
        return loadOneByPhotoId != null
    }

    override fun deletePhoto(photo: Photo) {
        database.photoDao.delete(photo)
    }

    override fun addPhoto(photo: Photo) {
        database.photoDao.insert(photo)
    }


    override fun getPhotoDetail(photoId: Long?): Single<Photo> {
        return retrofitService.getPhotoDetail(photoId!!)
    }

    override fun getPhotos(albumId: Long?): Single<List<Photo>> {
        return retrofitService.getPhotos(albumId!!)
    }

}