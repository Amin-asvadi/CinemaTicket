import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.base_android.utils.Success
import com.example.designsystem.BtnComponent
import com.example.designsystem.InfoComponentItem
import com.example.designsystem.ReservationChair
import com.example.designsystem.TopBarHeader
import com.example.designsystem.theme.DarkGrey
import com.example.designsystem.theme.Orange
import com.example.ui_main_screen.BottomNavigationContent
import com.example.ui_main_screen.MainScreenAction
import com.example.ui_main_screen.MainScreenState
import com.example.ui_main_screen.MainScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val viewState by viewModel.collectAsState()
    if (viewState.chairResponseData is Success && viewState.chair.isNotEmpty()) {
        MainScreen(modifier = modifier, viewState = viewState, action = { action ->
            when (action) {
                else -> viewModel.submitAction(action)
            }
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun MainScreen(
    modifier: Modifier,
    viewState: MainScreenState,
    action: (MainScreenAction) -> Unit
) {
    Scaffold(
        topBar = { TopBarHeader(modifier = modifier) },
        modifier = modifier.fillMaxSize(),
        containerColor = Color.Black
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ReservationChair(
                leftIndex = viewState.leftChair,
                rightIndex = viewState.rightChair,
                chairList = viewState.pairChair,
                onClickEvent = { id ->
                    action(MainScreenAction.OnChairClick(id))
                }
            )
            Row {
                viewState.info.forEach { item ->
                    InfoComponentItem(modifier = modifier, title = item.second, color = item.first)
                }
            }
            BottomNavigationContent(
                modifier = modifier,
                viewState = viewState,
                buyItemClick = {
                    action(MainScreenAction.OnBuyItemClick)
                },
                onTimeClickEvent = { time ->
                    action(MainScreenAction.SelectedTimeItem(time))
                }) { day ->
                action(MainScreenAction.SelectedItem(day))
            }
        }
    }
}