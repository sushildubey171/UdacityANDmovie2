package com.SD.utils;

/**
 * This is a helper class to get urls
 */

public class TmdbUrls {

    public static String BASE_URL = "http://api.themoviedb.org/3/discover/movie?";
    public static String MOVIE_BASE_URL = "http://api.themoviedb.org/3/movie/";
    public static String API_KEY = "api_key="+"your_key";
    public static String SORT_POPULARITY = "&sort_by=popularity.desc";
    public static String SORT_R_RATED = "&certification_country=US&certification=R&sort_by=vote_average.desc&vote_count.gte=250";
    public static String YOUTUBE_URL = "http://www.youtube.com/watch?v=";
    public static String YOUTUBE_THUMB = "http://img.youtube.com/vi/";
    public static String YOUTUBE_MEDIUM_QUALITY = "/mqdefault.jpg";

}
