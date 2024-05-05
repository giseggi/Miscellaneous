package com.gsg.miscellaneous.restclient.entity;

import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {

    private int total;

    private int start;

    private int display;

    private List<Items> items;

    @Data
    public static class Items {
        private String title;

        private String link;

        private String description;
    }
}
