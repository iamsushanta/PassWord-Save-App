package iamzen.`in`.passwordsave

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PassWordDao {



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(passWord:PassWordTable)

    @Delete
    suspend fun delete(password:PassWordTable)


    @Query("Select * from password_table order by id asc")
    fun getAllData():LiveData<List<PassWordTable>>
}