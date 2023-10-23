package com.example.amazonprimevideo

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home() {
    Scaffold() {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1B3C56))){

            Column {
                TopCompose()
                Spacer(modifier = Modifier.height(12.dp))
                AmazonOriginal()
                Spacer(modifier = Modifier.height(24.dp))
                ForYou()
            }
            Box(
                modifier = Modifier

                    .align(Alignment.BottomCenter)

            ) { BottomNav()}

        }
    }
}

@Composable
fun BottomNav() {

        Column {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(color = Color(0xFF00AAE4))
                .fillMaxWidth(0.9f)
                .height(45.dp),){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .padding(vertical = 6.dp, ).fillMaxWidth()

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "",
                        modifier = Modifier.size(33.dp)
                    )
                    //Spacer(modifier = Modifier.width(15.dp))
                    Image(
                        painter = painterResource(id = R.drawable.bookmark),
                        contentDescription = "",
                        modifier = Modifier.size(33.dp)
                    )
                    // Spacer(modifier = Modifier.width(15.dp))
                    Image(
                        painter = painterResource(id = R.drawable.activity),
                        contentDescription = "",
                        modifier = Modifier.size(33.dp)
                    )
                    // Spacer(modifier = Modifier.width(15.dp))
                    Image(
                        painter = painterResource(id = R.drawable.time_circle),
                        contentDescription = "",
                        modifier = Modifier.size(33.dp)
                    )


                }
            }

            Spacer(modifier = Modifier
                .height(18.dp),)

        }

}

@Composable
fun TopCompose() {
    var searchText by remember {
        mutableStateOf("Search Movie, Series, Documentry")
    }
    Box(

        modifier = Modifier
            .height(268.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp))
            .background(color = Color(0xFF00AAE4)),

        //shape = RoundedCornerShape(bottomEnd = 100.dp, bottomStart = 100.dp),
        //elevation = 10.dp
    ) {
        Image(painter = painterResource(id = R.drawable.homebg), contentDescription = "",contentScale = ContentScale.Crop,)
        Column(modifier = Modifier
            .padding(horizontal = 22.dp,)
            .padding(top = 22.dp)
            .fillMaxSize(),) {
           Row(
               modifier = Modifier
                   .fillMaxWidth(),
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.SpaceBetween,
           ) {
               Image(
                   painter = painterResource(id = R.drawable.menu), contentDescription = "",
                   modifier = Modifier.size(35.dp)
               )
               Text(text = "video", style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold))
               Image(
                   painter = painterResource(R.drawable.glory),
                   contentDescription = "avatar",
                   contentScale = ContentScale.Crop,            // crop the image if it's not a square
                   modifier = Modifier
                       .size(40.dp)
                       .clip(CircleShape)                       // clip to the circle shape
                          // add a border (optional)
               )
           }
            Spacer(modifier = Modifier.height(27.dp))
            Text(text = "Hello,",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Text(text = "What will you Watch?", style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(37.dp))
            Box(modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(color = Color(0xFF162B3C))){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF808080))
                    Spacer(modifier = Modifier.width(15.dp))
                    BasicTextField(value = searchText,
                        textStyle = TextStyle(color = Color(0xFF808080)),
                        onValueChange = {
                                        searchText = it
                    }, )
                }
            }
        }
    }

}

@Composable
fun AmazonOriginal() {
    Column() {
        Row(
            modifier = Modifier.padding(start = 22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Amazon Original", style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.width(3.dp))
            Image(
                painter = painterResource(id = R.drawable.shield), contentDescription = "",
                modifier = Modifier.size(18.dp)
            )

        }
        Spacer(modifier = Modifier.height(13.dp))
        HorizontalScrollScreen(isPrime = true)
    }

}

@Composable
fun ForYou() {
    Column() {
        Row(
            modifier = Modifier.padding(start = 22.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "For You", style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.width(3.dp))
            Image(
                painter = painterResource(id = R.drawable.heart), contentDescription = "",
                modifier = Modifier.size(18.dp)
            )

        }
        Spacer(modifier = Modifier.height(13.dp))
        HorizontalScrollScreen(isPrime = false)
    }

}

@Composable
fun AmazonOriginalCard(
    painter: Painter,
    contentDescription: String,

    isPrime: Boolean
){

    Box (
        modifier = Modifier.padding(end = 16.dp)
    ){
        Column {
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.height(200.dp)
            ) {
                Image(painter = painter, contentDescription = contentDescription)
            }
            Row (

                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Image(
                    painter = painterResource(id = R.drawable.stars), contentDescription = "",
                    modifier = Modifier
                        .width(74.dp)
                        .height(14.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))
                if(!isPrime){
                    Image(
                        painter = painterResource(id = R.drawable.universal), contentDescription = "",
                        modifier = Modifier.size(18.dp)
                    )
                }else{
                    Text(text = "prime", fontWeight = FontWeight.SemiBold, fontSize = 12.sp, color = Color(0xFF00AAE4))
                }
            }
        }
    }
}

@Composable
fun HorizontalScrollScreen(isPrime: Boolean) {
    val film1 = painterResource(id = R.drawable.takedown)

    // a wrapper to fill the entire screen
    Box {
        // BowWithConstraints will provide the maxWidth used below
        BoxWithConstraints(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 22.dp)) {
            // LazyRow to display your items horizontally
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState()
            ) {
                items(10) {
                    AmazonOriginalCard(painter = film1, contentDescription = "", isPrime = isPrime)
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true, widthDp = 350, heightDp = 900)
@Composable
fun FilmHomePreview() {
    Home()
}