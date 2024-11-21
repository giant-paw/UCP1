package com.example.pecco

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)

@Composable
fun Layout(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        TampilanHeader()

        Input()
    }
}

@Composable
fun TampilanHeader(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(4.dp)
    ){
        Column (modifier = Modifier

        ) {
            Image(painter = painterResource(R.drawable.orang),
                contentDescription = null,
                modifier
                    .size(130.dp)
                    .clip(shape = CircleShape)
            )

            Column (modifier = Modifier){

                Text(text = "Giant Prakoso",
                    color = Color.White,
                )

                Spacer(modifier = Modifier.padding(7.dp))
                Text(text = "Kabupaten Klaten",
                    color = Color.White,
                )

            }

        }
    }
}

@Composable
fun Input(modifier: Modifier = Modifier) {

    var origin by remember { mutableStateOf("") }
    var derparture by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }

    var dataTransport = listOf("Bus", "Ship", "Train", "Plane")
    var transport by remember { mutableStateOf("") }

    var konfirmOrigin by remember { mutableStateOf("") }
    var konfirmDerparture by remember { mutableStateOf("") }
    var konfirmArrival by remember { mutableStateOf("") }
    var konfirmtransport by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Text(
            text = "Plan Your Adventure",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp),
        )
        Text(
            text = "Lets Plan an Exquisite adventure",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 5.dp)
        )

        OutlinedTextField(
            value = origin,
            onValueChange = { origin = it },
            label = { Text(text = "Origin") },
            shape = CircleShape,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Row (
        ){
            OutlinedTextField(
                value = derparture,
                onValueChange = { derparture = it },
                label = { Text(text = "Derparture") },
                shape = CircleShape
            )

            OutlinedTextField(
                value = arrival,
                onValueChange = { arrival = it },
                label = { Text(text = "Arrival") },
                shape = CircleShape,
            )
        }

        Spacer(modifier = Modifier.padding(4.dp))

        Column (modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
        ) {
            Text(
                text = "Choose transportation : ",
                color = Color.White,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                dataTransport.forEach {selectedTransport->
                    Row (verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.background(Color.LightGray)
                            .padding(6.dp)
                    ) {
                        RadioButton(
                            selected = transport == selectedTransport,
                            onClick = {transport = selectedTransport}
                        )
                        Text(text = selectedTransport
                            )
                    }
                }
            }
        }


        Button(
            onClick = {
                konfirmOrigin = origin
                konfirmDerparture = derparture
                konfirmArrival = arrival
                konfirmtransport = transport
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .height(48.dp),
            shape = RoundedCornerShape(46.dp)
        ) {
            Text(text = "Submit")
        }

        Column (modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
        ) {
            tampilHasil(
                param = "Origin",
                argu = konfirmOrigin
            )

            tampilHasil(
                param = "Derparture",
                argu = konfirmDerparture
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Column (modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
        ) {
            tampilHasil(
                param = "Arrival",
                argu = konfirmArrival
            )

            tampilHasil(
                param = "Transport",
                argu = konfirmtransport
            )
        }

    }
}


@Composable
fun tampilHasil(
    param: String, argu:String
){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = param, modifier = Modifier.weight(0.8f), color = Color.White,)
            Text(text = ": ", modifier = Modifier.weight(0.2f), color = Color.White,)
            Text(text = argu, modifier = Modifier.weight(2f), color = Color.White,)
        }
    }
}