package iamzen.`in`.passwordsave

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PassWordViewModel(application: Application) : AndroidViewModel(application) {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allWords: LiveData<List<PassWordTable>>

    val repository:PassWordRepository

    init {
        val dao = PassWordDataBase.getDatabase(application).passWordDao()
         repository = PassWordRepository(dao)
        allWords = repository.allPasswords
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insertNote(passWordTable:PassWordTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(passWordTable)
    }

    fun deletePassWord(passWord:PassWordTable) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(passWord)
    }
}


