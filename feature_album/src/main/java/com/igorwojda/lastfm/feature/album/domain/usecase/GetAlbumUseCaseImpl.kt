package com.igorwojda.lastfm.feature.album.domain.usecase

import com.igorwojda.lastfm.feature.album.domain.model.OldAlbumDomainModel
import com.igorwojda.lastfm.feature.album.domain.repository.AlbumRepository

interface GetAlbumUseCase {
    suspend fun execute(id: String): OldAlbumDomainModel?
}

class GetAlbumUseCaseImpl(
    private val albumRepository: AlbumRepository
) : GetAlbumUseCase {
    override suspend fun execute(id: String): OldAlbumDomainModel? = albumRepository.getAlbum(id)
}
