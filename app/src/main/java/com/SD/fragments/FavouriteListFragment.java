package com.SD.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.SD.MovieWorld.R;
import com.SD.adapters.FavouriteListAdapter;
import com.SD.models.Movie;
import com.SD.utils.ContentProviderHelperMethods;

import java.util.ArrayList;



public class FavouriteListFragment extends Fragment {

    private ArrayList<Movie> mMovieList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private GridLayoutManager mGridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_popular_list, container, false);
        mAdapter = new FavouriteListAdapter(mMovieList, getActivity());
        mGridLayoutManager = new GridLayoutManager(getActivity(), 3);

        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if ((position + 1) % 4 == 0)
                    return 3;
                else
                    return 1;
            }
        });

        getMovieList();
        setupRecyclerView(mRecyclerView);
        return mRecyclerView;
    }

    private void getMovieList() {

        ArrayList<Movie> list = new ArrayList<>(ContentProviderHelperMethods
                .getMovieListFromDatabase(getActivity()));
        mMovieList.clear();
        for (Movie movie : list) {
            mMovieList.add(movie);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getMovieList();
        mAdapter.notifyDataSetChanged();
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setLayoutManager(mGridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);
    }

}
