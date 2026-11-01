{
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
  "message": "Not Found",
  "documentation_url": "https://docs.github.com/rest/repos/contents#get-repository-content",
  "status": "404"
}

            // 自动回复开关
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("自动回复", style = MaterialTheme.typography.bodyMedium)
                Switch(
                    checked = displaySetting.immersiveAutoReply,
                    onCheckedChange = {
                        onUpdateDisplaySetting(displaySetting.copy(immersiveAutoReply = it))
                    }
                )
            }

            // 自动回复等待时间（开关打开时显示）
            androidx.compose.animation.AnimatedVisibility(visible = displaySetting.immersiveAutoReply) {
                Column {
                    Text(
                        text = "等待 ${displaySetting.immersiveAutoReplyDelay}秒",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Slider(
                        value = displaySetting.immersiveAutoReplyDelay.toFloat(),
                        onValueChange = {
                            onUpdateDisplaySetting(displaySetting.copy(immersiveAutoReplyDelay = it.toInt()))
                        },
                        valueRange = 1f..15f,
                        steps = 13,
                    )
                }
            }
