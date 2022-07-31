package com.alexenderboot.retrofit;

import com.alexenderboot.retrofit.response.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Double v = 5.131;
        String token = "vk1.a.l-Fgr3eWyldVhzEDF4_N9kDPYR5oGGeiMSbj8r-Ls92jQBwpz2Cz5MuhED4z2r7Ys4HZ0d-YU7zmk6vHfDTG0W9HM-0E2aCgeduiWlk9k7DXBWaspJSV9h0SXfPPW0-6P3UZrgwaaRzxZRkBblZtPnr6fq4z5SYWub5ol95J-VJXNmd1OZGho9ubIbZmkeoW";

        System.out.println("Start");
        JsonVKApi api = JsonVKService.getInstance().getJSONApi();

        System.out.println("---------USERS---------");
        //ArrayList<String> response = new UserResponse.Root();
        UserResponse users = api.users(token, v, 20).execute().body();
        System.out.println(users);
        System.out.println("---------EVERY USER FOLLOWERS and SUBSCRIPTIONS---------");
        for (int i = 0; i < 20; i++) {
            System.out.println("ID: ");
            Integer userId = users.getUserId(users.getListUsers(), (Integer)i);
            System.out.println(userId);
            Boolean userIsClosed = users.getUserIsClosed(users.getListUsers(), (Integer)i);
            if (userIsClosed) {
                System.out.println("Can't get access to user's followers and subscriptions cause is_closed = true");
                continue;
            }
            Boolean userCanAccessClosed = users.getUserCanAccessClosed(users.getListUsers(), (Integer)i);
            if (!userCanAccessClosed) {
                System.out.println("Can't get access to user's followers and subscriptions cause userCanAccessClosed = false");
            }
            System.out.println("FOLLOWERS: ");
            UserFollowersResponse userFollowers = api.userFollowers(token, v, 3, userId, "online").execute().body();
            System.out.println(userFollowers.toString());
            System.out.println("SUBSCRIPTIONS: ");
            UserSubscriptionsResponse userSubscriptions = api.userSubscriptions(token, v, 5, userId, 1).execute().body();
            System.out.println(userSubscriptions.toString());
            System.out.println("\n");
        }
    }
}
