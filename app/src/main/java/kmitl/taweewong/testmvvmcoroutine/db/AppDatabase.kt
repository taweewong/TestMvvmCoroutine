package kmitl.taweewong.testmvvmcoroutine.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kmitl.taweewong.testmvvmcoroutine.db.entity.OchayaMenu

@Database(entities = [(OchayaMenu::class)], version = 4)
abstract class AppDatabase: RoomDatabase() {
    abstract fun ochayaMenuDao(): OchayaMenuDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(): AppDatabase {
            return instance!!
        }

        fun init(context: Context) {
            instance = Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java, "OchayaDatabase")
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
}