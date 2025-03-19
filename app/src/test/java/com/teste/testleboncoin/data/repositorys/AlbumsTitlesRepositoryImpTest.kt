package com.teste.testleboncoin.data.repositorys

import com.teste.testleboncoin.data.models.AlbumTitleResponse
import com.teste.testleboncoin.data.models.AlbumTitleResponseItem
import com.teste.testleboncoin.data.network.AlbumTitlesApi
import com.teste.testleboncoin.extentions.toAlbumTitleList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import retrofit2.Response
import kotlin.test.assertFailsWith


@ExperimentalCoroutinesApi
class AlbumsTitlesRepositoryImpTest {

    private lateinit var repository: AlbumsTitlesRepositoryImp
    private val mockApi: AlbumTitlesApi = mock()

    @Before
    fun setup() {
        repository = AlbumsTitlesRepositoryImp(mockApi)
    }

    @Test
    fun `getAlbumTitles should return transformed album list when API call is successful`() =
        runTest {
            val apiResponse = AlbumTitleResponse().apply {
                add(AlbumTitleResponseItem(1, 1, "thumb1.jpg", "Album One", "image1.jpg"))
                add(AlbumTitleResponseItem(2, 2, "thumb2.jpg", "Album Two", "image2.jpg"))
            }

            `when`(mockApi.getAlbumTitles()).thenReturn(Response.success(apiResponse))

            val result = repository.getAlbumTitles().first()

            assertEquals(apiResponse.toAlbumTitleList(), result)
            verify(mockApi).getAlbumTitles()
        }

    @Test
    fun `getAlbumTitles should throw exception when API call fails`() = runTest {
        `when`(mockApi.getAlbumTitles()).thenReturn(
            Response.error(500, "{}".toResponseBody("application/json".toMediaTypeOrNull()))
        )

        assertFailsWith<Exception> {
            repository.getAlbumTitles().first()
        }
        verify(mockApi).getAlbumTitles()
    }
}
