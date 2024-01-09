package com.devandroid.borutoapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.devandroid.borutoapp.presentation.components.RatingWidget
import com.devandroid.borutoapp.ui.theme.LARGE_PADDING

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()
    Scaffold (
        topBar = {
            HomeTopBar(onSearchClicked = {})
        }
    ) { it ->
        Box(modifier = Modifier.padding(it)) {
            RatingWidget(
                modifier = Modifier.padding(all = 12.dp),
                rating = 4.8
            )
        }
    }
}