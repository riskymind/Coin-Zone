package com.asterisk.cryptocurrencyapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.asterisk.cryptocurrencyapp.presentation.coin_detail.CoinDetailScreen
import com.asterisk.cryptocurrencyapp.presentation.coin_list.CoinListScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {
        composable(route = Screen.CoinListScreen.route) {
            CoinListScreen(navController = navController)
        }

        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
            CoinDetailScreen()
        }
    }

}