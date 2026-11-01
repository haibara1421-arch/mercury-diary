package me.rerere.rikkahub.ui.pages.chat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.rerere.rikkahub.data.datastore.DisplaySetting

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeautySettingsSheet(
    displaySetting: DisplaySetting,
    onUpdateDisplaySetting: (DisplaySetting) -> Unit,
    onDismiss: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = "沉浸模式",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 4.dp),
            )

            // 沉浸模式开关
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("启用沉浸模式", style = MaterialTheme.typography.bodyMedium)
                Switch(
                    checked = displaySetting.immersiveChatMode,
                    onCheckedChange = {
                        onUpdateDisplaySetting(displaySetting.copy(immersiveChatMode = it))
                    }
                )
            }

            AnimatedVisibility(visible = displaySetting.immersiveChatMode) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    // 气泡不透明度
                    Text(
                        text = "气泡不透明度: ${(displaySetting.bubbleOpacity * 100).toInt()}%",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Slider(
                        value = displaySetting.bubbleOpacity,
                        onValueChange = {
                            onUpdateDisplaySetting(displaySetting.copy(bubbleOpacity = it))
                        },
                        valueRange = 0.1f..1f,
                    )

                    // 自动回复等待时间（0=关闭）
                    Text(
                        text = if (displaySetting.immersiveAutoReplyDelay > 0)
                            "自动回复: ${displaySetting.immersiveAutoReplyDelay}秒"
                        else
                            "自动回复: 关闭",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Slider(
                        value = displaySetting.immersiveAutoReplyDelay.toFloat(),
                        onValueChange = {
                            onUpdateDisplaySetting(displaySetting.copy(immersiveAutoReplyDelay = it.toInt()))
                        },
                        valueRange = 0f..15f,
                        steps = 14,
                    )
                }
            }
        }
    }
}
