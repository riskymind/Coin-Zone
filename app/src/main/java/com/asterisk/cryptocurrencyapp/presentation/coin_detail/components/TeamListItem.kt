package com.asterisk.cryptocurrencyapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asterisk.cryptocurrencyapp.data.remote.dto.Team

@Composable
fun TeamListItem(
    team: Team,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = team.name,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = team.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }


}


@Preview(showBackground = true)
@Composable
fun TeamListItemPreview() {
    TeamListItem(Team("1", "kelechi", "developer"))
}