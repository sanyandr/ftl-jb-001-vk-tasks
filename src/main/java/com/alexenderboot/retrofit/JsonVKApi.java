package com.alexenderboot.retrofit;

import com.alexenderboot.retrofit.response.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface JsonVKApi {
    @GET("method/users.search")
    Call<UserResponse> users(@Query ("access_token") String access_token, @Query ("v") Double version, @Query ("count") Integer count);

    @GET("method/users.getFollowers")
    Call<UserFollowersResponse> userFollowers(@Query ("access_token") String access_token, @Query ("v") Double version, @Query ("count") Integer count, @Query ("user_id") Integer userId, @Query ("fields") String fields);

    @GET("method/users.getSubscriptions")
    Call<UserSubscriptionsResponse> userSubscriptions(@Query ("access_token") String access_token, @Query ("v") Double version, @Query ("count") Integer count, @Query ("user_id") Integer userId, @Query ("extended") Integer extended);
}
