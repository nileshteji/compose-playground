package com.practice.composeplayground


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.composeplayground.ui.theme.ComposePlaygroundTheme
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme(darkTheme = false) {
                Column {
                    CheckingTheStateOfCompose()
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                    )
                    CheckingTheStateOfCompose()
                    Spacer(
                        Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                    )
                    CheckingTheStateOfCompose()
                }
            }
        }
    }
}


@Preview
@Composable
fun CheckingTheStateOfCompose() {
    var stateCounter by remember { mutableStateOf(0) }
    StateLessComposable(stateCounter = stateCounter, increment = {
        stateCounter = it
    })

}


@Composable
fun StateLessComposable(stateCounter: Int, increment: (Int) -> Unit) {
    Column {
        Text(text = "Nilesh  $stateCounter")
        Button(onClick = { increment(stateCounter + 1) }) {
            Text(text = "Click")
        }
    }
}

@Composable
fun PreviewFunction(data: List<String>) {
    LazyColumn(modifier = Modifier.padding(16.dp), content = {
        itemsIndexed(items = data) { index, item ->
            CircularRoundImage(index % 2 == 0, item.split(" "))
            Spacer(modifier = Modifier.size(16.dp))
        }
    })
}


@Composable
fun CircularRoundImage(changeColor: Boolean, data: List<String>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        backgroundColor = if (changeColor) Color.Black else Color.Blue
    ) {

        Box {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                null,
                modifier = Modifier
                    .fillMaxSize()

            )

            Text(
                text = data[0],
                fontWeight = FontWeight.Bold,
                color = Color.Cyan,
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.TopCenter)
            )

            Text(
                text = data[1],
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.BottomCenter)
            )
        }
    }
}