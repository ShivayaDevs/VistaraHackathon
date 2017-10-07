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
import android.widget.TextView;

import java.util.ArrayList;

import crayon.airtime.R;
import crayon.airtime.cardsviewpager.CardFragmentPagerAdapter;
import crayon.airtime.cardsviewpager.CardItem;
import crayon.airtime.cardsviewpager.CardPagerAdapter;
import crayon.airtime.cardsviewpager.ShadowTransformer;

public class InterestGroupsFragment extends Fragment {

    private RecyclerView recyclerView;

    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_interest_groups, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_groups);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter = new MyAdapter();

        recyclerView.setAdapter(myAdapter);

        return rootView;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private ArrayList<String> namesList = new ArrayList<>();
        private ArrayList<Integer> numMembers = new ArrayList<>();

        MyAdapter() {
            namesList.add("Movies");
            numMembers.add(3);

            namesList.add("Movies");
            numMembers.add(3);


            namesList.add("Movies");
            numMembers.add(3);


            namesList.add("Movies");
            numMembers.add(3);
        }

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder viewHolder = new MyViewHolder(getLayoutInflater().inflate(R.layout
                    .list_item_groups, parent, false));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
            holder.groupName.setText(namesList.get(position));
            holder.membersCount.setText(numMembers.get(position) + " members");
        }

        @Override
        public int getItemCount() {
            return namesList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView groupName;
            TextView membersCount;

            MyViewHolder(View v) {
                super(v);
                groupName = v.findViewById(R.id.groupNameTv);
                membersCount = v.findViewById(R.id.membersCountTv);
            }

        }
    }

}
