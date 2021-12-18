package iamzen.`in`.passwordsave

import androidx.lifecycle.LiveData

class PassWordRepository(private val passwordDao:PassWordDao) {
    val allPasswords: LiveData<List<PassWordTable>> = passwordDao.getAllData()
    
    suspend fun insert(passwordsTable: PassWordTable){
        passwordDao.insert(passwordsTable)
    }

    suspend fun delete(password:PassWordTable){
        passwordDao.delete(password)
    }
}