package com.developers.sprintsync.tracking.dataStorage.repository.useCase

import com.developers.sprintsync.tracking.dataStorage.repository.TrackRepository
import com.developers.sprintsync.tracking.session.model.track.Track
import javax.inject.Inject

class SaveTrackuseCase
    @Inject
    constructor(
        private val repository: TrackRepository,
    ) {
        suspend operator fun invoke(track: Track) {
            repository.saveTrack(track)
        }
    }
