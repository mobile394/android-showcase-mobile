package com.igorwojda.showcase.feature.album.data.usecase

import com.igorwojda.showcase.feature.album.data.enum.AlbumDataImageSize
import com.igorwojda.showcase.feature.album.data.model.AlbumDataModel
import com.igorwojda.showcase.feature.album.data.model.AlbumImageDataModel
import com.igorwojda.showcase.feature.album.data.model.AlbumWikiDataModel

object ModelFixtures {

    internal fun getAlbum(
        mbId: String? = "mbId",
        name: String = "albumName",
        artist: String = "artistName",
        wiki: AlbumWikiDataModel? = getAlbumWikiDataModel(),
        images: List<AlbumImageDataModel>? = listOf(getAlbumImage())
    ): AlbumDataModel = AlbumDataModel(mbId, name, artist, wiki, images)

    internal fun getMinimalAlbum(): AlbumDataModel =
        getAlbum(name = "name", artist = "artist", mbId = null, wiki = null, images = null)

    private fun getAlbumImage(
        url: String = "url_${AlbumDataImageSize.EXTRA_LARGE}",
        size: AlbumDataImageSize = AlbumDataImageSize.EXTRA_LARGE
    ) = AlbumImageDataModel(url, size)

    private fun getAlbumWikiDataModel(
        published: String = "published",
        summary: String = "summary"
    ) = AlbumWikiDataModel(published, summary)
}
