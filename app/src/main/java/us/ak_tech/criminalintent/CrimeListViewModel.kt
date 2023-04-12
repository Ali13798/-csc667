package us.ak_tech.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class CrimeListViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()

    init {
        viewModelScope.launch {
            crimes += loadCrimes()
        }
    }

    suspend fun loadCrimes(): List<Crime> {
        // delay(2000)
        val result = mutableListOf<Crime>()
        for (i in 0..99) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime $i",
                date = Date(),
                isSolved = false
            )
            result += crime
        }
        return result
    }
}