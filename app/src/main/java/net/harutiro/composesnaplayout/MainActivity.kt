package net.harutiro.composesnaplayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import net.harutiro.composesnaplayout.ui.theme.ComposeSnapLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSnapLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent(placeholderItems = mutableListOf("hoge","hoge","huga"))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSnapperApi::class)
@Composable
fun MainContent(
    placeholderItems: MutableList<String>
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = "Example Horizontal LazyRow"
        )

        val lazyListState: LazyListState = rememberLazyListState()

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            state = lazyListState,
            flingBehavior = rememberSnapperFlingBehavior(lazyListState),
            contentPadding = PaddingValues(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(items = placeholderItems) { itemMessage: String ->
                Card(
                    modifier = Modifier
                        .width(350.dp)
                        .height(350.dp)
                        .padding(16.dp)
                ) {
                    //Put text or whatever here

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSnapLayoutTheme {
        MainContent(placeholderItems = mutableListOf("hoge","hoge","huga"))
    }
}