package com.shipa.route.data.cache

import android.content.Context
import java.io.*

/**
 * Created by hvngoc on 7/29/22
 */
class FileServicesImpl(private val context: Context) : FileServices {

    companion object {
        const val BUFFER_SIZE = 8192
        const val TIME_OUT = 1000 * 60 * 30
    }

    override fun saveData(fileName: String, data: String) {
        try {
            val cacheDir = context.cacheDir
            val file = File(cacheDir, fileName)
            val fos = FileOutputStream(file)
            fos.write(data.toByteArray())
            fos.close()
        } catch (e: Exception) {
        }
    }

    override fun getData(fileName: String): String? {
        try {
            val cacheDir = context.cacheDir
            val file = File(cacheDir, fileName)
            if (file.lastModified() < System.currentTimeMillis() - TIME_OUT) {
                return null
            }
            val fis = FileInputStream(file)
            return readStream(fis)
        } catch (e: Exception) {
        }
        return null
    }

    private fun readStream(`in`: InputStream): String? {
        val bytes = ByteArray(BUFFER_SIZE)
        val result = StringBuilder()
        try {
            while (true) {
                val count = `in`.read(bytes)
                if (count == -1) {
                    break
                }
                result.append(String(bytes, 0, count))
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                `in`.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return result.toString()
    }
}