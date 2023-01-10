@file:OptIn(ExperimentalMaterial3Api::class)

package com.uryonym.ynymportal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uryonym.ynymportal.ui.theme.YnymportalTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YnymportalTheme {
                // A surface container using the 'background' color from the theme
                navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    NavigationComposable(navController = navController)
                }
            }
        }
    }
}

@Composable
fun TaskIndexScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "index")
        })
    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
        ) {
            Text(text = "task index page")
            Button(onClick = { navController.navigate("taskDetail") }) {
                Text(text = "Detailへ")
            }
        }
    }
}

@Composable
fun TaskDetailScreen(navController: NavHostController) {
    Column {
        Text(text = "task detail page")
        Button(onClick = { navController.navigateUp() }) {
            Text(text = "Indexへ")
        }
    }
}

@Composable
fun NavigationComposable(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = "taskIndex") {
        composable("taskIndex") {
            TaskIndexScreen(navController = navController)
        }

        composable("taskDetail") {
            TaskDetailScreen(navController = navController)
        }
    }
}
