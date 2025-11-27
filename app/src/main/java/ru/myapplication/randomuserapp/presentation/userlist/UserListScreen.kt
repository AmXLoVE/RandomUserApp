package ru.myapplication.randomuserapp.presentation.userlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import ru.myapplication.randomuserapp.R
import ru.myapplication.randomuserapp.domain.userlist.model.UserDomain
import ru.myapplication.randomuserapp.presentation.LocalNavController
import ru.myapplication.randomuserapp.presentation.theme.DarkBlue
import ru.myapplication.randomuserapp.presentation.userlist.widget.UserListItemShimmer
import ru.myapplication.randomuserapp.presentation.userlist.widget.UserListScreenError

@Composable
internal fun UserListScreen(
    vm: UserListViewModel,
) {
    val state = vm.state.collectAsLazyPagingItems()
    val navController = LocalNavController.current

    UserListScreenChoice(
        state = state,
        onItemClick = { userId -> vm.onUserClicked(navController = navController, userId = userId) },
        onCreateUser = { navController.popBackStack() },
    )
}

@Composable
private fun UserListScreenChoice(
    state: LazyPagingItems<UserDomain>,
    onItemClick: (Long) -> Unit,
    onCreateUser: () -> Unit,
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            LazyColumn {
                items(state.itemCount) { index ->
                    UserListItemWidget(
                        firstName = state[index]?.name?.firstName ?: "",
                        lastName = state[index]?.name?.lastName ?: "",
                        phone = state[index]?.phone ?: "",
                        nat = state[index]?.nat ?: "",
                        pictureUrl = state[index]?.picture?.medium ?: "",
                        onClick = { state[index]?.id?.let { onItemClick(it) } },
                    )
                }

                state.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> items(3) { UserListItemShimmer() }

                        loadState.append is LoadState.Loading -> items(3) { UserListItemShimmer() }

                        loadState.append is LoadState.Error -> item {
                            UserListScreenError(onReloadPage = { state.refresh() })
                        }
                    }
                }
            }

            Button(
                modifier = Modifier
                    .align(alignment = Alignment.BottomEnd)
                    .padding(28.dp)
                    .size(50.dp)
                    .clip(RoundedCornerShape(25)),
                shape = RoundedCornerShape(15),
                contentPadding = PaddingValues(0.dp),
                onClick = onCreateUser,
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBlue,
                    contentColor = Color.White,
                )
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    tint = Color.White,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize()
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
private fun UserListItemWidget(
    firstName: String,
    lastName: String,
    phone: String,
    nat: String,
    pictureUrl: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .padding(horizontal = 4.dp)
                .dropShadow(
                    shape = RoundedCornerShape(12.dp),
                    shadow = Shadow(
                        spread = 4.dp,
                        radius = 6.dp,
                        color = Color.LightGray,
                    )
                )
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color.White)

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(onClick = onClick),
            ) {
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = pictureUrl,
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxHeight(),
                        contentScale = ContentScale.Crop,
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 4.dp)
                        .weight(1f),
                ) {
                    Row {
                        Text(
                            text = "$firstName $lastName",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = DarkBlue,
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row {
                        Text(
                            text = phone,
                            color = Color.Gray,
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "",
                            modifier = Modifier
                                .size(18.dp)
                        )

                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = nat,
                            color = Color.Gray,
                        )
                    }
                }

                Box(modifier = Modifier.align(alignment = Alignment.Top)) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(12.dp)
                            .size(25.dp),
                        tint = DarkBlue
                    )
                }
            }
        }
    }
}
