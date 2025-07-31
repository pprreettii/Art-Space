package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                FinalSpace()

            }
        }
    }
}


@Composable
fun FinalSpace( modifier: Modifier = Modifier) {
    var imageIndex by remember { mutableIntStateOf(1) }

    ImageAndText(result = imageIndex,
        prevClicked = {
            imageIndex = if(imageIndex > 1) imageIndex - 1 else 9},
        nextClicked = {
            imageIndex = if(imageIndex < 9) imageIndex+1 else 1}
    )
}

@Composable
fun ImageAndText(result : Int,prevClicked : () -> Unit,nextClicked : () -> Unit) {
    val imageResource = when (result) {

        1 -> R.drawable.pic_1
        2 -> R.drawable.pic_2
        3 -> R.drawable.pic_3
        4 -> R.drawable.pic_4
        5 -> R.drawable.pic_5
        6 -> R.drawable.pic_6
        7 -> R.drawable.pic_7
        8 -> R.drawable.pic_8
        else -> R.drawable.pic_9

    }
    val textResource1 = when (result) {

        1 -> R.string.desc_2
        2 -> R.string.desc_3
        3 -> R.string.desc_4
        4 -> R.string.desc_5
        5 -> R.string.desc_6
        6 -> R.string.desc_7
        7 -> R.string.desc_8
        8 -> R.string.desc_9
        else -> R.string.desc_10
    }

    val textResource2 = when (result) {

        1 -> R.string.name_2
        2 -> R.string.name_3
        3 -> R.string.name_4
        4 -> R.string.name_5
        5 -> R.string.name_6
        6 -> R.string.name_7
        7 -> R.string.name_8
        8 -> R.string.name_9
        else -> R.string.name_10
    }
    Column(
        modifier = Modifier.fillMaxSize()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier.size(500.dp).padding(start = 30.dp,end = 30.dp,top = 70.dp),
            color = Color(0xFFEAEFEF),
            shadowElevation = 8.dp,

        ) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = stringResource(id = textResource1) + " " + stringResource(id = textResource2),
                    modifier = Modifier.padding(30.dp).size(400.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier.padding(start = 30.dp,end = 30.dp,top = 30.dp).background(Color(0xFFB8CFCE)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
                    ) {
            Text(
                text = stringResource(textResource1),
                fontSize = 26.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp,end = 30.dp,top = 30.dp, bottom = 4.dp)
            )
            Text(
                text = stringResource(textResource2),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp,end = 30.dp, bottom = 30.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = prevClicked,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333446)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.weight(1f)
                        .padding(30.dp)
                ) {
                    Text(

                        text = "Previous",
                        fontSize = 15.sp,
                        color =Color.White,

                    )
                }

                Button(
                    onClick = nextClicked,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333446)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.weight(1f)
                        .padding(30.dp)
                ) {
                    Text(
                        text = "Next",
                        fontSize = 15.sp,
                        color =Color.White
                    )
                }
            }
        }

}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        FinalSpace()
    }
}