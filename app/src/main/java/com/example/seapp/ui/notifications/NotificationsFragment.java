package com.example.seapp.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seapp.MainActivity;
import com.example.seapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private TextView title;
    public FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mRef;
    public ArrayList<String> arrayList=new ArrayList<>();
    private RecyclerView recycleView;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Set title name in actionbar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.title_notifications));
        notificationsViewModel = ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        recycleView = (RecyclerView) root.findViewById(R.id.recycleView);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        mRef=database.getInstance().getReference("post").child("111").child("comments");

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycleView.setLayoutManager(layoutManager);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map =(Map)dataSnapshot.getValue();
                String value =String.valueOf(map.get("username"));
                String values =String.valueOf(map.get("comment"));

                adapterclass adapter = new adapterclass(value,values);
                recycleView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
















        return root;
    }/*
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        TextView descTextView;

        public class RecycleViewAdapter extends RecyclerView.Adapter<ViewHolder>{

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.username);
            descTextView = (TextView) itemView.findViewById(R.id.message);
        }
    }
*/

}
/*   public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        TextView descTextView;

        public class RecycleViewAdapter extends RecyclerView.Adapter<ViewHolder>{

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.username);
            descTextView = (TextView) itemView.findViewById(R.id.message);
        }
    }*/