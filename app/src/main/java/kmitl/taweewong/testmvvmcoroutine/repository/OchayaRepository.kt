package kmitl.taweewong.testmvvmcoroutine.repository

import kmitl.taweewong.testmvvmcoroutine.db.AppDatabase
import kmitl.taweewong.testmvvmcoroutine.db.entity.OchayaMenu
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.withContext

object OchayaRepository {
    private val ochayaMenuDao = AppDatabase.getInstance().ochayaMenuDao()

    suspend fun getAllOchayaMenu(): List<OchayaMenu> {
        return withContext(DefaultDispatcher) { ochayaMenuDao.getAllOchayaMenu() }
    }
}