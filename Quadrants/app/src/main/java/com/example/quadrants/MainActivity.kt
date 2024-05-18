package com.example.quadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrants.ui.theme.QuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth()) {
        Row (Modifier.weight(1f)){
            Quadrant(
                title = stringResource(R.string.first_title),
                description = stringResource(R.string.first_description),
                background = colorResource(R.color.quadrant_1_bg),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                background = colorResource(R.color.quadrant_2_bg),
                modifier = Modifier.weight(1f)
            )
        }
        Row (Modifier.weight(1f)){
            Quadrant(
                title = stringResource(R.string.third_title),
                description = stringResource(R.string.third_description),
                background = colorResource(R.color.quadrant_3_bg),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description),
                background = colorResource(R.color.quadrant_4_bg),
                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Composable
fun Quadrant(
    title: String,
    description: String,
    background: androidx.compose.ui.graphics.Color,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .background(background)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = title,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 16.dp, top = 120.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(bottom = 55.dp
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun QuadrantsPreview() {
    QuadrantsTheme {
        MainPage()
    }
}