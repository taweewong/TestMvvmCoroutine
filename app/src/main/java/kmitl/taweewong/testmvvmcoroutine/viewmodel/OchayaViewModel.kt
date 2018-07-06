package kmitl.taweewong.testmvvmcoroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kmitl.taweewong.testmvvmcoroutine.db.entity.OchayaMenu
import kmitl.taweewong.testmvvmcoroutine.repository.OchayaRepository
import kotlinx.coroutines.experimental.runBlocking

class OchayaViewModel: ViewModel() {
    val observableAllOchayaMenu = MutableLiveData<List<OchayaMenu>>()

    init {
        observableAllOchayaMenu.value = emptyList()
    }

    fun loadAllOchayaMenu() {
        runBlocking {
            observableAllOchayaMenu.value = OchayaRepository.getAllOchayaMenu()
        }
    }
}