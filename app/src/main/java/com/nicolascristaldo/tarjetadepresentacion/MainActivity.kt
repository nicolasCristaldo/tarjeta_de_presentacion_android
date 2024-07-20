package com.nicolascristaldo.tarjetadepresentacion

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nicolascristaldo.tarjetadepresentacion.ui.theme.TarjetaDePresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TarjetaDePresentacionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(R.color.background_app)
                ) {
                    ComposablePresentationApp()
                }
            }
        }
    }
}

@Composable
fun ComposablePresentationApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
    ) {
        ComposableProfile(
            name = stringResource(R.string.card_name),
            description = stringResource(R.string.card_description),
            imagePainter = painterResource(R.drawable.android_logo),
            textColor = colorResource(R.color.text_color)
        )
        ComposableContactCard()
    }
}

@Composable
fun ComposableProfile(
    name: String,
    description: String,
    imagePainter: Painter,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        ComposableImageContainer(imagePainter)
        Text(
            text = name,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 4.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = description,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ComposableImageContainer(
    imagePainter: Painter,
    modifier: Modifier = Modifier
    ) {
    Box(
        modifier = modifier.background(colorResource(R.color.background_image))
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = modifier.width(130.dp)
        )
    }
}

@Composable
fun ComposableContactCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ComposableContactElement(
            stringResource(R.string.email),
            painterResource(R.drawable.ic_email),
            colorResource(R.color.text_color)
            )
        ComposableContactElement(
            stringResource(R.string.share),
            painterResource(R.drawable.ic_share),
            colorResource(R.color.text_color)
        )
        ComposableContactElement(
            stringResource(R.string.phone_number),
            painterResource(R.drawable.ic_phone),
            colorResource(R.color.text_color)
        )
    }
}

@Composable
fun ComposableContactElement(
    contact: String,
    imagePainter: Painter,
    color: Color,
    modifier: Modifier = Modifier
    ) {
    Row(modifier = modifier.padding(12.dp)) {
        Icon(
            painter = imagePainter,
            contentDescription = null,
            tint = color
        )
        Text(
            text = contact,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 20.dp)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetaDePresentacionTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(R.color.background_app)
        ) {
            ComposablePresentationApp()
        }
    }
}