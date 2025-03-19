package com.teste.testleboncoin.domain.usecases

import com.teste.testleboncoin.data.database.daos.AlbumTitleDao
import com.teste.testleboncoin.data.database.database.AlbumTitlesDatabase
import com.teste.testleboncoin.domain.models.AlbumTitle
import com.teste.testleboncoin.domain.repositorys.AlbumTitlesRepository
import com.teste.testleboncoin.extentions.toAlbumTitlesEntityList
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class GetAlbumsUseCaseTest {

    private lateinit var getAlbumsUseCase: GetAlbumsUseCase
    private val mockRepository: AlbumTitlesRepository = mock()
    private val mockDatabase: AlbumTitlesDatabase = mock()
    private val mockDao: AlbumTitleDao = mock()

    @Before
    fun setup() {
        `when`(mockDatabase.albumTitleDao()).thenReturn(mockDao)
        getAlbumsUseCase = GetAlbumsUseCase(mockRepository, mockDatabase)
    }

    @Test
    fun `should fetch albums from repository and insert into database`() = runTest {
        val remoteAlbums = listOf(
            AlbumTitle(1, "Album One", "image1.jpg", "thumb1.jpg"),
            AlbumTitle(2, "Album Two", "image2.jpg", "thumb2.jpg")
        )

        `when`(mockRepository.getAlbumTitles()).thenReturn(flowOf(remoteAlbums))
        `when`(mockDao.getAllAlbumTitles()).thenReturn(flowOf(remoteAlbums.toAlbumTitlesEntityList()))

        val result = getAlbumsUseCase().toList()

        assertEquals(remoteAlbums, result.first())
        verify(mockRepository).getAlbumTitles()
        verify(mockDao).insertAlbumTitles(any())
        verify(mockDao).getAllAlbumTitles()
    }
}
