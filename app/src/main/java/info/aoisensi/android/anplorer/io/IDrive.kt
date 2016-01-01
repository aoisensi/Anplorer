package info.aoisensi.android.anplorer.io

interface IDrive {
    fun getFileList(path: String): List<IFile>
}