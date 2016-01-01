package info.aoisensi.android.anplorer.io

import java.io.File

class DeviceFile(val drive: DeviceDrive, val file: File): IFile {
    override fun getFileList() =
        file.listFiles()?.map{ DeviceFile(drive, it) }

    override fun getFileType() =
        if (file.isFile) FileType.File else FileType.Directory

    override fun getDevice() = drive

    override fun getName() = file.name
}
