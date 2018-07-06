package kmitl.taweewong.testmvvmcoroutine.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kmitl.taweewong.testmvvmcoroutine.db.entity.OchayaMenu

@Dao
interface OchayaMenuDao {
    @Query("SELECT * FROM ochayamenu WHERE id == :targetId")
    fun getRandomOchayaMenu(targetId: Int): OchayaMenu

    @Query("SELECT * FROM ochayamenu")
    fun getAllOchayaMenu(): List<OchayaMenu>

    @Insert
    fun insertOchayaMenuList(ochayaMenuList: List<OchayaMenu>)
}