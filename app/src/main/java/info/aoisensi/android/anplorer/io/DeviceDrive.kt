package info.aoisensi.android.anplorer.io

import java.io.File
import kotlin.collections.map

class DeviceDrive(): IDrive {
    override fun getFileList(path: String) =
        File(path).listFiles().map { DeviceFile(it) }
}
