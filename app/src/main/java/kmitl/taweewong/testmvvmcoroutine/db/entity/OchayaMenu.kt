package kmitl.taweewong.testmvvmcoroutine.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ochayamenu")
class OchayaMenu(@ColumnInfo(name = "menu_name") var menuName: String,
                 @ColumnInfo(name = "price") var price: Float) {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}
