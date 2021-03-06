package com.igorwojda.showcase.feature.album.domain.usecase

import com.igorwojda.showcase.feature.album.domain.model.Album
import com.igorwojda.showcase.feature.album.domain.repository.AlbumRepository
import java.io.IOException

internal class GetAlbumUseCase(
    private val albumRepository: AlbumRepository
) {

    sealed interface Result {
        data class Success(val data: Album) : Result
        data class Error(val e: Throwable) : Result
    }

    suspend fun execute(
        artistName: String,
        albumName: String,
        mbId: String?
    ): Result = try {
        albumRepository.getAlbumInfo(artistName, albumName, mbId)?.let {
            Result.Success(it)
        } ?: Result.Error(RuntimeException("No data"))
    } catch (e: IOException) {
        Result.Error(e)
    }
}
