package com.developers.sprintsync.tracking.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.developers.sprintsync.tracking.viewModel.useCase.GetAllTracksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrackListViewModel
    @Inject
    constructor(
        private val getAllTracksUseCase: GetAllTracksUseCase,
    ) : ViewModel() {
        val tracks = getAllTracksUseCase.tracks.asLiveData()
    }
