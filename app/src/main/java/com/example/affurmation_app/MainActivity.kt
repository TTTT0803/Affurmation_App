package com.example.affurmation_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.affurmation_app.ui.theme.Affurmation_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Affurmation_appTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AffirmationList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AffirmationList(modifier: Modifier = Modifier) {
    val affirmations = listOf(
        "I am confident and capable.",
        "I believe in myself and my abilities.",
        "I am deserving of success and happiness.",
        "I am constantly growing and improving.",
        "I attract positivity and good energy."
    )

    // Danh sách hình ảnh
    val imageResources = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10
    )

    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(affirmations.size) { index ->
            AffirmationItem(
                affirmation = affirmations[index],
                imageResource = imageResources[index % imageResources.size] // Dùng modulo để lặp qua danh sách hình ảnh
            )
        }
    }
}
@Composable
fun AffirmationItem(affirmation: String, imageResource: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Hiển thị hình ảnh từ tài nguyên với chiều dài lớn hơn
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "Affirmation Image",
                modifier = Modifier
                    .height(200.dp) // Chỉnh chiều cao của hình ảnh
                    .fillMaxWidth() // Chiều rộng tự động theo chiều rộng của Card
                    .padding(bottom = 8.dp)
            )

            // Hiển thị câu khẳng định
            Text(
                text = affirmation,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp)) // Khoảng cách giữa câu khẳng định và note

            // Hiển thị Note phía dưới
            Text(
                text = "Keep believing in yourself!",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.secondary
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AffirmationPreview() {
    Affurmation_appTheme {
        AffirmationList()
    }
}
