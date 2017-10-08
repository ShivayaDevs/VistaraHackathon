package crayon.airtime.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import crayon.airtime.R;

/**
 * Created by yash on 8/10/17.
 */

public class GamesFragment extends Fragment {

    private RecyclerView recyclerView;

    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_games, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_groups);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter = new MyAdapter();

        recyclerView.setAdapter(myAdapter);

        getActivity().setTitle("Multiplayer Games");

        return rootView;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        int[] imgRes = null;

        private ArrayList<String> gameNamesList = new ArrayList<>();
        private ArrayList<Integer> numMembers = new ArrayList<>();

        MyAdapter() {

            imgRes = new int[]{R.drawable.ic_light_bulb,
                    R.drawable.ic_paint_roll,
                    R.drawable.ic_paint_brush,
                    R.drawable.ic_vector
            };

            gameNamesList.add("Think Quiz");
            numMembers.add(12);

            gameNamesList.add("Paint and Roll");
            numMembers.add(3);

            gameNamesList.add("Flowing colors");
            numMembers.add(7);

            gameNamesList.add("Pen starz");
            numMembers.add(10)
            ;
        }

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder viewHolder = new MyViewHolder(getLayoutInflater().inflate(R.layout
                    .list_item_game, parent, false));
            return viewHolder;

        }

        @Override
        public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
            holder.groupName.setText(gameNamesList.get(position));
            holder.membersCount.setText(numMembers.get(position) + " members");
            holder.imageView.setImageResource(imgRes[position]);
        }

        @Override
        public int getItemCount() {
            return gameNamesList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView groupName;
            TextView membersCount;

            MyViewHolder(View v) {
                super(v);
                imageView = v.findViewById(R.id.gameIconView);
                groupName = v.findViewById(R.id.gameNameTv);
                membersCount = v.findViewById(R.id.membersCountTv);

            }

        }
    }

}

