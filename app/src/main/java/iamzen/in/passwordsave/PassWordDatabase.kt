package iamzen.`in`.passwordsave

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PassWordTable::class), version = 1, exportSchema = false)
abstract class PassWordDataBase : RoomDatabase() {

    abstract fun passWordDao(): PassWordDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PassWordDataBase? = null

        fun getDatabase(context: Context): PassWordDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PassWordDataBase::class.java,
                    "password_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}