package com.example.days

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import java.time.Instant
import java.util.Date

/**
 * Implementation of App Widget functionality.
 */
class NewAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val alcohol: Date = Date.from(Instant.parse("2024-05-12T18:35:24.00Z"))
    val video: Date = Date.from(Instant.parse("2024-05-01T18:35:24.00Z"))
    val now: Date = Date.from(Instant.now())
    val alcoholDays = (now.time - alcohol.time) / (1000*60*60*24)
    val videoDays = (now.time - video.time) / (1000*60*60*24)

    val views = RemoteViews(context.packageName, R.layout.new_app_widget)
    views.setTextViewText(R.id.alcoholTextView, alcoholDays.toString())
    views.setTextViewText(R.id.videoTextView, videoDays.toString())

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}