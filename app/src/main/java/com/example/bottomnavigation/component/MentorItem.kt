package com.example.bottomnavigation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.bottomnavigation.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bottomnavigation.model.Mentor
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme

@Composable
fun MentorItem(
    mentor: Mentor,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(mentor.id)
        }
    ) {
        Image(
            painter = painterResource(id = mentor.photo),
            contentDescription = mentor.name, modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Text(
            text = mentor.name,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp),
            maxLines = 1

        )
        Text(
            text = mentor.role,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun MentorItemHorizontalPreview(){
    BottomNavigationTheme{
        MentorItem(
            mentor = Mentor(1, "Aditya Putranto", "Adit", "Technical Mobile", R.drawable.founder),
            onItemClicked = { mentorId ->
                println("Mentor Id : $mentorId")
            }

        )
    }
}
