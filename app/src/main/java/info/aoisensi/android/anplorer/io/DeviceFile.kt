package info.aoisensi.android.anplorer.io

import java.io.File

class DeviceFile(val file: File): IFile {
    override fun getName() = file.name
}
