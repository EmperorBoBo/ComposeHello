package com.symbol.composehello.ui

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.symbol.composehello.R
import kotlinx.coroutines.launch


/**
 * ??????
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "1. ????????????",
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Black,

            modifier = Modifier.padding(vertical = 4.dp)
        )
        Text(
            text = "FontWeight.Light",
            color = Color.LightGray,
            fontWeight = FontWeight.Light
        )

        Text(
            text = "FontWeight.Black",
            fontWeight = FontWeight.Black
        )
        Text(
            text = "FontWeight.ExtraBold",
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "FontWeight.SemiBold",
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "FontWeight.Medium",
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "FontWeight.Thin",
            fontWeight = FontWeight.Thin
        )
        Text(
            text = "FontWeight.w100",
            fontWeight = FontWeight.W100
        )
        Text(
            text = "FontWeight.w900",
            fontWeight = FontWeight.W900
        )

        Text(
            text = "FontFamily.Cursive",
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = "FontFamily.Monospace",
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = stringResource(id = R.string.app_name),
            textDecoration = TextDecoration.LineThrough + TextDecoration.Underline
        )
        Text(
            text = """
            ??????????????????
            ??????????????????
            ??????????????????
            ??????????????????
        """.trimMargin(),
            maxLines = 2
        )
        Text(
            text = "?????????????????????????????????".repeat(6),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            text = "TextOverflow".repeat(6),
            overflow = TextOverflow.Clip,
            maxLines = 1
        )

        Text(
            text = "?????? shape",
            Modifier
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                )
                .padding(horizontal = 12.dp, vertical = 6.dp),
            color = Color.Cyan
        )

        Box(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
            Text(
                text = "???????????? Text",
                Modifier
                    .clickable {
                        Log.e("Symbol", "click")
                        Toast
                            .makeText(context, "I'm a toast", Toast.LENGTH_LONG)
                            .show()
                    }
                    .background(
                        color = Color.LightGray, shape = RoundedCornerShape(
                            8
                        )
                    )
                    .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
            )
        }

        SelectionContainer(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .background(color = Color.LightGray)
        ) {
            Text(text = "???????????????", modifier = Modifier.padding(12.dp))
        }

        val annotatedText = buildAnnotatedString {
            append("??????????????????")
            append("?????????")
            pushStringAnnotation(tag = "tag", annotation = "?????????")
            withStyle(
                style = SpanStyle(
                    color = Color.Cyan,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("????????????")
            }
            pop()
        }

        ClickableText(text = annotatedText,
            onClick = {
                annotatedText.getStringAnnotations(tag = "tag", start = it, end = it)
                    .firstOrNull()?.let { aString ->
                        Toast.makeText(context, aString.item, Toast.LENGTH_LONG).show()
                    }
            })

        val ss = buildAnnotatedString {
            append("???????????????")
            withStyle(SpanStyle(fontSize = 14.sp, color = Color.Cyan)) {
                append("???????????????")
            }
            withStyle(SpanStyle(fontSize = 12.sp, color = Color.Red)) {
                append("???????????????")
            }
        }
        Text(text = ss)

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "2.TextFiled ??????",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        var inputText = remember {
            mutableStateOf("")
        }
        TextField(
            value = inputText.value,
            onValueChange = {
                inputText.value = it
            },
            placeholder = {
                Text(text = "???????????????")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            OutlinedTextField(
                value = inputText.value,
                onValueChange = {
                    inputText.value = it
                },
                label = {
                    Text(text = "outlineTextField")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search, contentDescription = "???"
                    )
                },
                trailingIcon = {
                    Text(text = "@gmail.com")
                }
            )
        }

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "3.Icon ??????",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }


        Icon(
            bitmap = ImageBitmap.imageResource(id = R.mipmap.b1aa0c85f414485bc77a122592eea150),
            contentDescription = "bitmap"
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "imageVector"
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "painter"
        )

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "4.Image??????",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Image(painter = painterResource(id = R.mipmap.a), contentDescription = "??????")

        Surface(
            shape = CircleShape,
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Image(painter = painterResource(id = R.mipmap.b), contentDescription = "circleImage")
        }
        Image(
            painter = painterResource(id = R.mipmap.b1aa0c85f414485bc77a122592eea150),
            contentDescription = "??????",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(120.dp)
        )


        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "5. Card??????",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            border = BorderStroke(width = 2.dp, color = Color.Gray),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Text(
                text = "??????", fontSize = 16.sp, fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 12.dp)
            )
            Text(
                text = "????????????????????????", fontSize = 14.sp, fontWeight = FontWeight.Light,
                modifier = Modifier.padding(bottom = 12.dp, start = 12.dp, end = 12.dp)
            )
        }

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "6. FloatingActionButton ??? Dialog??????",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        val showD = remember {
            mutableStateOf(false)
        }
        FloatingActionButton(
            onClick = {
            },
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp)
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "??????")
        }


        FloatingActionButton(
            onClick = {
                showD.value = !showD.value
            },
            shape = CircleShape,
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "??????")
        }

//        if (!showD.value) {
//
//            AlertDialog(
//                onDismissRequest = {
//                    showD.value = false
//                },
//                title = {
//                    Text(text = "?????????")
//                },
//                confirmButton = {
//                    Button(onClick = { showD.value = false }) {
//                        Text(text = "??????")
//                    }
//                },
//                dismissButton = {
//                    Button(onClick = { showD.value = false }) {
//                        Text(text = "??????")
//                    }
//                },
//                text = {
//                    Text(text = "??????????????? FloatingActionButton")
//                },
//                shape = RoundedCornerShape(4.dp),
//                tonalElevation = 4.dp
//            )
//
//        }

        Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "7. Box??????",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Box(
            modifier = Modifier
                .padding(12.dp)
                .background(color = Color.Yellow)
                .size(120.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .background(color = Color.Green)
                    .size(100.dp)
            ) {
                Text(text = "?????????", modifier = Modifier.align(alignment = Alignment.Center))
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .background(color = Color.LightGray)
        )

        val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
        val bottomScope = rememberCoroutineScope()

        ModalBottomSheetLayout(
            sheetState = bottomState,
            sheetBackgroundColor = Color.White,
            sheetElevation = 4.dp,
            scrimColor = Color.Gray,
            sheetShape = RoundedCornerShape(4.dp),
            sheetContentColor = Color.Green,
            sheetContent = {
                Column {
                    Text(text = "?????????")
                    Text(text = "?????????")
                }
            }
        ) {

        }


        TextButton(onClick = { bottomScope.launch { bottomState.show() } }) {
            Text(text = "??????ModalBottomSheetDialog")
        }


        BackHandler(
            enabled = bottomState.currentValue == ModalBottomSheetValue.Expanded ||
                    bottomState.currentValue == ModalBottomSheetValue.HalfExpanded,
            onBack = {
                bottomScope.launch { bottomState.hide() }
            }
        )

    }

}