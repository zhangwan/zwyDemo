package com.tiger.zwy.utils

import android.content.Context
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

/**
 * Created By HuiT
 * On 2019/2/15
 */
object FileUtil {
    /**
     * 将输入流写入文件
     *
     * @param inputString
     * @param file
     */
    @Throws(Exception::class)
    fun writeFile(inputString: InputStream, file: File) {

        val fos = FileOutputStream(file)
        val b = ByteArray(1024)
        var len: Int = inputString.read(b)
        while (len != -1) {
            fos.write(b, 0, len)
            len = inputString.read(b)
        }
        inputString.close()
        fos.close()
    }

    fun getCachePath(context: Context): String {
        return context.externalCacheDir.toString() + File.separator + "loanMarket" + File.separator + "apk"
    }

    fun getDownLoadPath(context: Context): String {
        return context.getExternalFilesDir("loanMarket").toString() + File.separator + "apk"
    }

    fun createFile(file: File) {
        if (file.exists()) {
            file.delete()
        }
        if (!file.parentFile.exists()) {
            file.parentFile.mkdirs()
        }
        file.createNewFile()
    }
}
