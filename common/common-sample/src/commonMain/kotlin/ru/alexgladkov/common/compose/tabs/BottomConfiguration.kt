package ru.alexgladkov.common.compose.tabs

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ru.alexgladkov.common.compose.theme.Odyssey
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomNavScreenConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomNavScreenConfiguration.BottomNavConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.CustomNavConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabsNavModel
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TopNavScreenConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TopNavScreenConfiguration.TopNavConfiguration

class BottomConfiguration(
    private val toolbarContent: @Composable (selectedTabIndex: Int) -> Unit = {},
) : TabsNavModel<BottomNavScreenConfiguration>() {

    override val navConfiguration: BottomNavScreenConfiguration
        @Composable
        get() {
            return BottomNavScreenConfiguration(
                bottomNavConfiguration = BottomNavConfiguration(
                    backgroundColor = Odyssey.color.secondaryBackground,
                    selectedColor = Odyssey.color.primaryText,
                    unselectedColor = Odyssey.color.controlColor,
                    elevation = 0.dp,
                ),
                toolbarContent = toolbarContent,
            )
        }
}

class TopConfiguration(
    private val toolbarContent: @Composable (selectedTabIndex: Int) -> Unit = {},
) : TabsNavModel<TopNavScreenConfiguration>() {

    override val navConfiguration: TopNavScreenConfiguration
        @Composable
        get() {
            return TopNavScreenConfiguration(
                topNavConfiguration = TopNavConfiguration(
                    backgroundColor = Odyssey.color.secondaryBackground,
                    contentColor = Odyssey.color.primaryText,
                ),
                toolbarContent = toolbarContent,
            )
        }
}

class CustomConfiguration(private val content: @Composable (params: Any?) -> Unit) :
    TabsNavModel<CustomNavConfiguration>() {

    override val navConfiguration: CustomNavConfiguration
        @Composable
        get() {
            return CustomNavConfiguration(
               content = content
            )
        }
}
