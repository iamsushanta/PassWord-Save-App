package iamzen.`in`.passwordsave

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "password_table")
class PassWordTable(@ColumnInfo(name = "pass_word_owner") val name:String,val password:String) {
    @PrimaryKey(autoGenerate=true) var id = 0
}