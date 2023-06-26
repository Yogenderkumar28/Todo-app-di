package com.example.todoappdi.ui.todo_home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.todoappdi.data.Todo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TodoItem(
    todo: Todo,
    onEvent: (TodoListEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = todo.isDone,
                    onCheckedChange = {isChecked ->
                        onEvent(TodoListEvent.OnDoneChange(todo, isChecked))
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = todo.title.trim() ,
                    style = MaterialTheme.typography.headlineSmall,
                )
                IconButton(
                    onClick = {
                              onEvent(TodoListEvent.OnDeleteTodoClick(todo))
                    },
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.Red
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = todo.description.trim(),
                style = MaterialTheme.typography.bodySmall,
                maxLines = 4
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Last Updated",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Last Updated: ",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Gray
                )
            }
        }
    }
}

//private fun removeTrailingSpace(desc: String): String {
//    var temp : String = ""
//    var i = 0
//    var j = desc.length-1
//    while(desc[i] == ' ') {
//        i++
//    }
//    while(desc[i] == ' ') {
//        j--;
//    }
//    temp = desc.substring(i, j)
//    return temp
//}
