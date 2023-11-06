import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.example.base_android.utils.BaseViewModel
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.DrawScope
fun <T> MutableState<T>.reduce(reducer: T.() -> T) {
    value = reducer.invoke(value)
}



fun <A : BaseViewModel<B, *>, B, C> withState(viewModel: A, block: (B) -> C) =
    block(viewModel.state)

@Composable
@ReadOnlyComposable
fun ssp(@DimenRes id: Int): TextUnit {
    return dimensionResource(id).value.sp
}

/**
 * Creates a Compose State variable that will emit new values whenever this ViewModel's state changes.
 * Prefer the overload with a state property reference to ensure that your composable only recomposes when the properties it uses changes.
 */
@Composable
fun <VM : BaseViewModel<S, *>, S> VM.collectAsState(
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): State<S> {
    return remember(stateFlow, lifecycle) {
        stateFlow.flowWithLifecycle(
            lifecycle = lifecycle,
            minActiveState = minActiveState
        )
    }.collectAsState(initial = withState(this) { it })
}


fun ContentDrawScope.drawMyCustomShape() {
    val path = Path().apply {
        val yRatio = 0.35f
        moveTo(0f, size.height * yRatio)
        lineTo(0f, size.height)
        quadraticBezierTo(
            size.width / 2,
            size.height * 0.6f,
            size.width,
            size.height
        )
        lineTo(size.width, size.height * yRatio)
        quadraticBezierTo(
            size.width / 2,
            0f,
            0f,
            size.height * yRatio
        )
    }
    clipPath(path = path) {
        // Draw your custom content here
        clipPath(path = path) {
            this@drawMyCustomShape.drawContent()
        }
    }
}
