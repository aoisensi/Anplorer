package info.aoisensi.android.anplorer.io

import java.io.File

class DeviceDrive(): IDrive {
    override fun getRootDirectory() =
        DeviceFile(this, File("/"))

}
