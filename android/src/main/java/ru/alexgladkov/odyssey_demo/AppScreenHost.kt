package ru.alexgladkov.odyssey_demo

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import ru.alexgladkov.common.compose.NavigationTree
import ru.alexgladkov.common.compose.flows.AuthFlow
import ru.alexgladkov.common.compose.flows.MainHost
import ru.alexgladkov.common.compose.screens.DialogScreen
import ru.alexgladkov.common.compose.screens.SplashScreen
import ru.alexgladkov.odyssey.compose.AndroidScreenHost
import ru.alexgladkov.odyssey.compose.extensions.observeAsState
import ru.alexgladkov.odyssey.core.destination.DestinationPoint

class AppScreenHost(composeActivity: ComponentActivity) : AndroidScreenHost(composeActivity) {

    @Composable
    override fun launchScreen(destinationPoint: DestinationPoint) {
        val state = destinationPoint.rootController.backStackObserver.observeAsState()
        state.value?.let { entry ->
            when (entry.destination.destinationName()) {
                NavigationTree.Root.Splash.toString() -> SplashScreen(entry.rootController)
                NavigationTree.Root.Auth.toString() -> AuthFlow(entry.rootController)
                NavigationTree.Root.Main.toString() -> MainHost(entry.rootController)
                NavigationTree.Root.Dialog.toString() -> DialogScreen(entry.rootController)
            }
        }
    }
}