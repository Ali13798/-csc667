package us.ak_tech.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CrimeListViewModel : ViewModel() {
    private val crimes = mutableListOf<Crime>()
    private val crimeRepository = CrimeRepository.get()

    init {
        viewModelScope.launch {
            crimes += loadCrimes()
        }
    }

    suspend fun loadCrimes(): List<Crime> {
        return crimeRepository.getCrimes()
    }
}