package com.alexenderboot.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class UserFollowersResponse {
    @SerializedName("response")
    @Expose
    private Response response;

    public List<Item> getListFollowers() {
        return response.getItems();
    }

    @Setter
    @Getter
    @ToString
    public static class Item {
        @SerializedName("deactivated")
        @Expose
        private String deactivated;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("track_code")
        @Expose
        private String track_code;
        @SerializedName("first_name")
        @Expose
        private String first_name;
        @SerializedName("last_name")
        @Expose
        private String last_name;
        @SerializedName("can_access_closed")
        @Expose
        private Boolean can_access_closed;
        @SerializedName("is_closed")
        @Expose
        private Boolean is_closed;
        @SerializedName("online")
        @Expose
        private Integer online;

    }
    @Setter
    @Getter
    @ToString
    public static class Response{
        public Response() {}
        @SerializedName("count")
        @Expose
        private Integer count;
        @SerializedName("friends_count")
        @Expose
        private Integer friends_count;
        private ArrayList<Item> items = new ArrayList<>();
    }
}
