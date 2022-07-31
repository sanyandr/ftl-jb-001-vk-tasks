package com.alexenderboot.retrofit.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.List;

    @Getter
    @Setter
    @ToString
    public class UserResponse {
        @SerializedName("response")
        private Response response;

        public List<Item> getListUsers() {
            return response.getItems();
        }

        public Integer getCount() {
            return response.getCount();
        }

        public Integer getUserId(List<Item> list, Integer i) {
            return list.get(i).getId();
        }
        public Boolean getUserIsClosed(List<Item> list, Integer i) {
            return list.get(i).getIs_closed();
        }
        public Boolean getUserCanAccessClosed(List<Item> list, Integer i) {
            return list.get(i).getCan_access_closed();
        }
        @Getter
        @Setter
        @ToString
        public static class Item {
            @Expose
            @SerializedName("id")
            private Integer id;
            @Expose
            @SerializedName("track_code")
            private String track_code;
            @Expose
            @SerializedName("first_name")
            private String first_name;
            @Expose
            @SerializedName("last_name")
            private String last_name;
            @Expose
            @SerializedName("can_access_closed")
            private Boolean can_access_closed;
            @Expose
            @SerializedName("is_closed")
            private Boolean is_closed;

        }
        @Getter
        @Setter
        @ToString
        public static class Response {
            public Response() {}
            @SerializedName("count")
            @Expose
            private Integer count;
            private ArrayList<Item> items = new ArrayList<>(100);
        }
}
