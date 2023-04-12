package us.ak_tech.criminalintent.database

import androidx.room.Dao
import androidx.room.Query
import us.ak_tech.criminalintent.Crime
import java.util.UUID


@Dao
interface CrimeDao {
    @Query("SELECT * FROM Crime")
    suspend fun getCrimes(): List<Crime>

    @Query("SELECT * FROM Crime WHERE id=(:id)")
    suspend fun getCrime(id: UUID): Crime
}