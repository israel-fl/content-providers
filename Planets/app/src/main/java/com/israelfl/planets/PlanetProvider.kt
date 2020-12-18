package com.israelfl.planets

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.util.Log
import com.israelfl.R

class PlanetProvider : ContentProvider() {
    override fun onCreate(): Boolean {
        return true
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor {
        Log.d(PlanetProvider::class.java.simpleName, uri.toString())

        // Create a Cursor with one column
        val matrixCursor = MatrixCursor(arrayOf("planets"))

        // Read file from resources
        val text = context?.resources?.openRawResource(R.raw.planets)?.bufferedReader()?.use { it.readText() }

        // Create one row in the column containing all text in the JSON file
        matrixCursor.addRow(arrayOf(text))

        return matrixCursor
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun getType(uri: Uri): String? {
        return null
    }
}
