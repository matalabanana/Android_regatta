package com.example.regatta

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.regatta.dao.AppDatabase
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    fun createBDD()
    {
        var context = InstrumentationRegistry.getInstrumentation().targetContext
        var db:AppDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
        var dao = db.personneDao()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}