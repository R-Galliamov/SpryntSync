package com.developers.sprintsync.statistics.presentation.util.formatter

import com.developers.sprintsync.statistics.presentation.model.WeeklyStatistics
import com.developers.sprintsync.statistics.components.TracksStatsCalculator
import com.developers.sprintsync.core.components.track.presentation.indicator_formatters.CaloriesFormatter
import com.developers.sprintsync.core.components.track.presentation.indicator_formatters.DistanceFormatter
import com.developers.sprintsync.core.components.track.presentation.indicator_formatters.DurationFormatter
import com.developers.sprintsync.core.components.track.presentation.indicator_formatters.PaceFormatter
import com.developers.sprintsync.core.components.track.data.model.Track

class WeeklyStatisticsFormatter {
    fun formatWeeklyStatistics(tracks: List<Track>): WeeklyStatistics {
        if (tracks.isEmpty()) return WeeklyStatistics.EMPTY
        val calculator = TracksStatsCalculator(tracks)

        val workouts = calculator.numberOfWorkouts
        val workoutDaysFormatted = WORKOUT_DAYS_FORMAT.format(calculator.workoutDays)
        val totalDistance = calculator.totalDistanceMeters
        val totalDuration = calculator.totalDurationMillis
        val bestDistance = calculator.longestDistanceMeters
        val bestDuration = calculator.longestDurationMillis
        val avgPace = calculator.averagePace
        val bestPace = calculator.bestPace
        val totalCalories = calculator.totalCaloriesBurned

        return WeeklyStatistics(
            workouts = workouts.toString(),
            workoutDays = workoutDaysFormatted,
            totalDistance = DistanceFormatter.metersToPresentableKilometers(totalDistance, true),
            totalDuration = DurationFormatter.formatToHhMmSs(totalDuration),
            bestDistance = DistanceFormatter.metersToPresentableKilometers(bestDistance, true),
            bestDuration = DurationFormatter.formatToHhMmSs(bestDuration),
            avgPace = PaceFormatter.formatPaceWithTwoDecimals(avgPace),
            bestPace = PaceFormatter.formatPaceWithTwoDecimals(bestPace),
            totalCalories = CaloriesFormatter.formatCalories(totalCalories, false),
        )
    }

    companion object {
        private const val WORKOUT_DAYS_FORMAT = "%1\$d/7"
    }
}
