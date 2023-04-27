package us.ak_tech.criminalintent

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import us.ak_tech.criminalintent.database.CrimeDatabase
import java.util.*


private const val DB_NAME = "crime-database"

class CrimeRepository private constructor(
    context: Context,
    private val coroutineScope: CoroutineScope = GlobalScope
) {
    private val db: CrimeDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            CrimeDatabase::class.java,
            DB_NAME
        )
        .build()

    suspend fun getCrimes(): List<Crime> = db.crimeDao().getCrimes()
    suspend fun getCrime(id: UUID): Crime = db.crimeDao().getCrime(id)

    fun updateCrime(crime: Crime) {
        coroutineScope.launch {
            db.crimeDao().updateCrime(crime)
        }
    }

    suspend fun addCrime(crime: Crime) {
        db.crimeDao().addCrime(crime)
    }

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE ?: throw IllegalStateException("crimeRepository must be initialized.")
        }
    }
}