package com.alexenderboot.retrofit.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@ToString
public class UserSubscriptionsResponse {
        @SerializedName("response")
        @Expose
        private Response response;

        public List<Item> getListSubscriptions() {
            return response.getItems();
        }
        @Setter
        @Getter
        @ToString
        public static class Item {
            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("screen_name")
            @Expose
            private String screen_name;
            @SerializedName("is_closed")
            @Expose
            private Integer is_closed;
            @SerializedName("type")
            @Expose
            private String type;
            @SerializedName("is_admin")
            @Expose
            private Integer is_admin;
            @SerializedName("is_member")
            @Expose
            private Integer is_member;
            @SerializedName("is_advertiser")
            @Expose
            private Integer is_advertiser;
            @SerializedName("photo_50")
            @Expose
            private String photo_50;
            @SerializedName("photo_100")
            @Expose
            private String photo_100;
            @SerializedName("photo_200")
            @Expose
            private String photo_200;
        }
        @Setter
        @Getter
        @ToString
        public static class Response{
            public Response() {}
            @SerializedName("count")
            @Expose
            private Integer count;
            private ArrayList<Item> items = new ArrayList<>();
        }
    }
