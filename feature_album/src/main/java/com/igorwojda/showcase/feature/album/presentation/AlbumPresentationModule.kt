package com.igorwojda.showcase.feature.album.presentation

import androidx.fragment.app.Fragment
import com.igorwojda.base.di.KotlinViewModelProvider
import com.igorwojda.showcase.feature.album.FEATURE_NAME
import com.igorwojda.showcase.feature.album.presentation.albumdetails.AlbumDetailsViewModel
import com.igorwojda.showcase.feature.album.presentation.albumlist.AlbumListViewModel
import com.igorwojda.showcase.feature.album.presentation.albumlist.recyclerview.AlbumAdapter
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

internal val presentationModule = Kodein.Module("${FEATURE_NAME}PresentationModule") {

    // AlbumList
    bind<AlbumListViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { AlbumListViewModel(instance()) }
    }

    bind() from singleton { AlbumAdapter(instance()) }

    // AlbumDetails
    bind<AlbumDetailsViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { AlbumDetailsViewModel(instance(), instance()) }
    }
}
