package us.ak_tech.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import us.ak_tech.criminalintent.Crime


@Database(entities = [Crime::class], version = 1)
abstract class CrimeDatabase : RoomDatabase() {
}