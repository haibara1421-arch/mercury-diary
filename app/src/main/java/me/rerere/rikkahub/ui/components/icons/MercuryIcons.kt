package me.rerere.rikkahub.ui.components.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

/**
 * 水星记自定义图标集
 * 统一风格：1.5dp 描边、Round cap/join、24x24 画布
 */
object MercuryIcons {

    /** 四角星 + 小加号，用于 AI 回复按钮 */
    val AiStar: ImageVector by lazy {
        ImageVector.Builder(
            name = "AiStar",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f,
        ).apply {
            // 四角星（中心偏左下，给右上角加号留空间）
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(10f, 2f)
                quadTo(10f, 13f, 20f, 13f)
                quadTo(10f, 13f, 10f, 22f)
                quadTo(10f, 13f, 2f, 13f)
                quadTo(10f, 13f, 10f, 2f)
                close()
            }
            // 小加号 — 竖线
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
            ) {
                moveTo(19f, 2.5f)
                lineTo(19f, 7.5f)
            }
            // 小加号 — 横线
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
            ) {
                moveTo(16.5f, 5f)
                lineTo(21.5f, 5f)
            }
        }.build()
    }

    /** 圆圈加号，用于附件/加号按钮 */
    val CirclePlus: ImageVector by lazy {
        ImageVector.Builder(
            name = "CirclePlus",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f,
        ).apply {
            // 外圆（圆心 12,12 半径 9）
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
            ) {
                moveTo(21f, 12f)
                arcTo(9f, 9f, 0f, isMoreThanHalf = true, isPositiveArc = true, x1 = 3f, y1 = 12f)
                arcTo(9f, 9f, 0f, isMoreThanHalf = true, isPositiveArc = true, x1 = 21f, y1 = 12f)
                close()
            }
            // 加号竖线
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
            ) {
                moveTo(12f, 8f)
                lineTo(12f, 16f)
            }
            // 加号横线
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
            ) {
                moveTo(8f, 12f)
                lineTo(16f, 12f)
            }
        }.build()
    }

    /** 纸飞机，用于发送按钮 */
    val PaperPlane: ImageVector by lazy {
        ImageVector.Builder(
            name = "PaperPlane",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f,
        ).apply {
            // 纸飞机轮廓
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(22f, 2f)
                lineTo(15f, 22f)
                lineTo(11f, 13f)
                lineTo(2f, 9f)
                close()
            }
            // 折痕线
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
            ) {
                moveTo(22f, 2f)
                lineTo(11f, 13f)
            }
        }.build()
    }

    /** 公文包/工具箱，用于顶栏工具箱按钮 */
    val Toolbox: ImageVector by lazy {
        ImageVector.Builder(
            name = "Toolbox",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f,
        ).apply {
            // 箱体（圆角矩形）
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(4f, 7f)
                lineTo(20f, 7f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, x1 = 22f, y1 = 9f)
                lineTo(22f, 18f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, x1 = 20f, y1 = 20f)
                lineTo(4f, 20f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, x1 = 2f, y1 = 18f)
                lineTo(2f, 9f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, x1 = 4f, y1 = 7f)
                close()
            }
            // 提手
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
            ) {
                moveTo(8f, 7f)
                lineTo(8f, 5f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, x1 = 10f, y1 = 3f)
                lineTo(14f, 3f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, x1 = 16f, y1 = 5f)
                lineTo(16f, 7f)
            }
            // 中间横线（扣带）
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 1.5f,
            ) {
                moveTo(2f, 13f)
                lineTo(22f, 13f)
            }
        }.build()
    }
}
