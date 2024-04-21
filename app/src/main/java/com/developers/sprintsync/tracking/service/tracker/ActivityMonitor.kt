package com.developers.sprintsync.tracking.service.tracker

import com.developers.sprintsync.tracking.model.PaceAnalysisResult
import com.developers.sprintsync.tracking.model.Segment
import com.developers.sprintsync.tracking.model.UserActivityState
import com.developers.sprintsync.tracking.service.PaceAnalyzer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ActivityMonitor
    @Inject
    constructor(private val debouncer: Debouncer) {
        private val _userActivityState: MutableStateFlow<UserActivityState> =
            MutableStateFlow(UserActivityState.Running)
        val userActivityState = _userActivityState.asStateFlow()

        fun updateState(segments: List<Segment>) {
            if (isPaceSlowedDown(segments)) {
                updateState(UserActivityState.Running)
            } else {
                updateState(UserActivityState.HasSlowedDown)
            }
        }

        fun startMonitoringInactivity() {
            debouncer.debounce {
                updateState(UserActivityState.HasStopped)
            }
        }

        fun isStopped(): Boolean {
            return userActivityState.value is UserActivityState.HasStopped
        }

        fun stopMonitoringInactivity() {
            debouncer.cancel()
        }

        private fun updateState(userActivityState: UserActivityState) {
            _userActivityState.value = userActivityState
        }

        private fun isPaceSlowedDown(segments: List<Segment>): Boolean {
            return (PaceAnalyzer.analyzePaceChange(segments) == PaceAnalysisResult.PaceSlowedDown)
        }
    }
