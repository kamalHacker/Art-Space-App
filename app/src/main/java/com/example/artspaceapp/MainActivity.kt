package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceAppLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceAppLayout(
    modifier: Modifier = Modifier
) {
    var currentImage by remember { mutableIntStateOf(1) }

    val imageResource = when(currentImage){
        1 -> R.drawable.the_ascension
        2 -> R.drawable.monalisa
        3 -> R.drawable.peacock_feather
        4 -> R.drawable.red_sky
        5 -> R.drawable.starry_night
        6 -> R.drawable.trees_nature
        else -> R.drawable.guernica
    }

    val imageDescription = when(currentImage){
        1 -> stringResource(R.string.image1)
        2 -> stringResource(R.string.image2)
        3 -> stringResource(R.string.image3)
        4 -> stringResource(R.string.image4)
        5 -> stringResource(R.string.image5)
        6 -> stringResource(R.string.image6)
        else -> stringResource(R.string.image7)
    }

    val artYear = when(currentImage){
        1 -> stringResource(R.string.art1_year)
        2 -> stringResource(R.string.art2_year)
        3 -> stringResource(R.string.art3_year)
        4 -> stringResource(R.string.art4_year)
        5 -> stringResource(R.string.art5_year)
        6 -> stringResource(R.string.art6_year)
        else -> stringResource(R.string.art7_year)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier
                .padding(20.dp)
                .shadow(30.dp),
            painter = painterResource(imageResource),
            contentDescription = imageDescription
        )
        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            text = imageDescription
        )
        Text(
            text = artYear,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                onClick = {
                    if (currentImage > 1) {
                        currentImage--
                    } else {
                        currentImage = 6
                    }
                }
            ){
                Text(
                    text = stringResource(R.string.previous)
                )
            }
            Button(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                onClick = {
                    if (currentImage < 7) {
                        currentImage++
                    } else {
                        currentImage = 1
                    }
                }
            ){
                Text(
                    text = stringResource(R.string.next)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceAppTheme {
        ArtSpaceAppLayout()
    }
}