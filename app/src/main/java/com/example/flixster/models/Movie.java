package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String posterPath;
    String title;
    String overview;
    String backdropPath;

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");

    }

    //iterates through jsonarray and constructing a movie for each element in array
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
      List<Movie> movies = new ArrayList<>();
      for(int i = 0; i<movieJsonArray.length();i++){
          movies.add(new Movie((movieJsonArray.getJSONObject(i))));
      }
      return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
        //properly done by fetching all the sizes, appending to the url you get back, and then adding the relative path
    }

    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
