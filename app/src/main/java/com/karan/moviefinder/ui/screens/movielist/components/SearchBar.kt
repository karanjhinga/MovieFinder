package com.karan.moviefinder.ui.screens.movielist.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.karan.moviefinder.R
import com.karan.moviefinder.ui.theme.MovieFinderTheme
import com.karan.moviefinder.ui.theme.spacing

@Composable
fun SearchBar(text: String, onTextChange: (String) -> Unit, modifier: Modifier = Modifier) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.outline
            )
        },
        value = text,
        onValueChange = onTextChange,
        modifier = modifier
            .padding(MaterialTheme.spacing.l)
            .fillMaxWidth(),
        placeholder = {
            Text(
                text = stringResource(R.string.search_placeholder),
                color = MaterialTheme.colorScheme.outline
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                println("onSearch")
                focusManager.clearFocus()
            }
        ))
}


@Composable
@Preview(showBackground = true)
fun SearchBarEmptyPreview() {
    MovieFinderTheme {
        SearchBar(text = "", onTextChange = {
            TODO("preview")
        })
    }
}

@Composable
@Preview(showBackground = true)
fun SearchBarPreview() {
    MovieFinderTheme {
        SearchBar(text = "Strange", onTextChange = {
            TODO("preview")
        })
    }
}