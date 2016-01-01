package info.aoisensi.android.anplorer.io

interface IFile {
    fun getName(): String
    fun getDevice(): IDrive
    fun getFileType(): FileType
    fun getFileList(): List<IFile>?
    fun isFile() = getFileType() == FileType.File
    fun isDirectory() = getFileType() == FileType.Directory
}