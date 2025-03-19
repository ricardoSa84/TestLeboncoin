package com.teste.testleboncoin.presentation.viewmodels

import app.cash.turbine.test
import com.teste.testleboncoin.domain.models.AlbumTitle
import com.teste.testleboncoin.domain.usecases.GetAlbumsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class AlbumTitlesViewModelTest {

 @Mock
 private lateinit var getAlbumsUseCase: GetAlbumsUseCase
@InjectMocks
 private lateinit var viewModel: AlbumTitlesViewModel

 @Before
 fun setup() {
  MockitoAnnotations.openMocks(this)
 }

 @Test
 fun `should update albums state when use case returns data`() = runTest {

  val expectedAlbums = listOf(
   AlbumTitle(1, "Album One", "image1.jpg", "thumb1.jpg"),
   AlbumTitle(2, "Album Two", "image2.jpg", "thumb2.jpg")
  )

  val albumFlow = MutableStateFlow(expectedAlbums)
  `when`(getAlbumsUseCase.invoke()).thenReturn(albumFlow)

  viewModel = AlbumTitlesViewModel(getAlbumsUseCase)

  viewModel.albums.test {
   assertEquals(expectedAlbums, awaitItem())
   cancelAndConsumeRemainingEvents()
  }
 }
}
