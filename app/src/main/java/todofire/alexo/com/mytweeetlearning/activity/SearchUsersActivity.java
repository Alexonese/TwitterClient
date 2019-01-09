package todofire.alexo.com.mytweeetlearning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.Collection;

import todofire.alexo.com.mytweeetlearning.R;
import todofire.alexo.com.mytweeetlearning.adapter.UsersAdapter;
import todofire.alexo.com.mytweeetlearning.pojo.User;

public class SearchUsersActivity extends AppCompatActivity {

    private RecyclerView usersRecyclerView;
    private UsersAdapter usersAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_users);
        initRecyclerView();
        searchUsers();
    }


    private void initRecyclerView(){
        usersRecyclerView =  findViewById(R.id.users_recycler_view);
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        UsersAdapter.OnUserClickListener OnUserClickListener = new UsersAdapter.OnUserClickListener() {
            @Override
            public void OnUserClick(User user) {
                Intent intent = new Intent(SearchUsersActivity.this, UserInfoActivity.class);
                        intent.putExtra(UserInfoActivity.USER_ID, user.getId());
                startActivity(intent);
            }
        };
        usersAdapter = new UsersAdapter(OnUserClickListener);
        usersRecyclerView.setAdapter(usersAdapter);

    }

    private void searchUsers() {
        Collection<User> users = getUsers();
        usersAdapter.setItems(users);
    }
    private Collection<User> getUsers() {
        return Arrays.asList(
                new User(
                        929257819349700608L,
                        "http://i.imgur.com/DvpvklR.png",
                        "Alexonese",
                        "@alexonese",
                        "Sample description",
                        "Ukraine",
                        42,
                        42
                ),

                new User(
                        44196397L,
                        "https://pbs.twimg.com/profile_images/782474226020200448/zDo-gAo0_400x400.jpg",
                        "Elon Musk",
                        "@elonmusk",
                        "Hat Salesman",
                        "Boring",
                        14,
                        13
                )
        );
    }



}
