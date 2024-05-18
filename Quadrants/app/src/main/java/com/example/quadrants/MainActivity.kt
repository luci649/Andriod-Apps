package com.example.quadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
fun MainPage() {
    Column(Modifier.fillMaxWidth()) {
        Row (Modifier.weight(1f)){
            Quadrant(
                flag = painterResource(R.drawable.belgium_country_flag),
                title = stringResource(R.string.belgium_flag_title),
                background = colorResource(R.color.quadrant_1_bg),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                flag = painterResource(R.drawable.flag_turkey),
                title = stringResource(R.string.turkey_flag_title),
                background = colorResource(R.color.quadrant_2_bg),
                modifier = Modifier.weight(1f)
            )
        }
        Row (Modifier.weight(1f)){
            Quadrant(
                flag = painterResource(R.drawable.download__2_),
                title = stringResource(R.string.tanzania_flag_title),
                background = colorResource(R.color.quadrant_3_bg),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                flag = painterResource(R.drawable.download__1_),
                title = stringResource(R.string.Peru_flag_title),
                background = colorResource(R.color.quadrant_4_bg),
                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Composable
fun Quadrant(
    flag: Painter,
    title: String,
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
        Image(
            painter = flag,
            contentDescription = title,
            contentScale = ContentScale.Fit,
            modifier = modifier.padding(top = 50.dp)
        )
        Text(
            text = title,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 16.dp, top = 16.dp)
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