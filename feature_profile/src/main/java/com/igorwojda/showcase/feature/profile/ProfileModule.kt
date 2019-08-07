package com.igorwojda.showcase.feature.profile

import com.igorwojda.showcase.feature.profile.data.dataModule
import com.igorwojda.showcase.feature.profile.domain.domainModule
import com.igorwojda.showcase.feature.profile.presentation.presentationModule
import org.kodein.di.Kodein

internal const val FEATURE_NAME = "Profile"

val profileModule = Kodein.Module("${FEATURE_NAME}Module") {
    import(presentationModule)
    import(domainModule)
    import(dataModule)
}
