package com.developers.sprintsync.user.ui.userProfile.chart.interaction

import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.listener.OnChartGestureListener

/**
 * A class to handle and configure user interactions with a chart.
 *
 * @param chart The chart to manage interactions for.
 */
class ChartInteractionHandler(
    private val chart: CombinedChart,
) {
    /**
     * TODO create a configuration
     *
     * Configures the interaction settings for the chart, including enabling touch and disabling
     * dragging, scaling, and pinch zoom. Optionally sets a custom gesture listener.
     *
     * @param onGestureListener An optional custom gesture listener to handle chart gestures.
     */

    fun configureInteraction(onGestureListener: OnChartGestureListener? = null) {
        chart.apply {
            setTouchEnabled(true)
            isDragEnabled = false
            setScaleEnabled(false)
            setPinchZoom(false)
            onGestureListener?.let { onChartGestureListener = it }
        }
    }
}
