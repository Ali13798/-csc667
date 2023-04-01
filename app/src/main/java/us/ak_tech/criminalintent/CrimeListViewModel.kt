package us.ak_tech.criminalintent

import androidx.lifecycle.ViewModel
import java.util.*

class CrimeListViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0..99) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime $i",
                date = Date(),
                isSolved = false
            )
            crimes += crime
        }
    }

}