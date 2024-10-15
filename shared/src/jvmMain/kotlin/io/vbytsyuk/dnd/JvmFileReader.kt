package io.vbytsyuk.dnd

import okio.IOException
import okio.buffer
import okio.source
import java.io.File
import java.io.FileNotFoundException

actual fun readFileAsString(filePath: String): String {
    val file = File(filePath)
    return try {
        val source = file.source().buffer()
        val jsonString = source.readUtf8()
        source.close()
        jsonString
    } catch (e: FileNotFoundException) {
        throw (e)
    } catch (e: IOException) {
        throw (e)
    }
}
