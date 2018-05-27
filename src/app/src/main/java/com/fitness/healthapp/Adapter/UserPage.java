package com.fitness.healthapp.Adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitness.healthapp.R;
import com.fitness.healthapp.model.User;

import java.util.List;

public class UserPage extends RecyclerView.Adapter<UserPage.UserViewHolder> {


    private List<User> listUsers;

    public UserPage(List<User> listUsers) {
        this.listUsers = listUsers;
    }





    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.list_user, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textViewName.setText(listUsers.get(position).getName());
        holder.textViewEmail.setText(listUsers.get(position).getEmail());
        holder.textViewPassword.setText(listUsers.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        Log.v(UserPage.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewPassword;
        public AppCompatTextView textViewConfirmPassword;

        public UserViewHolder(View view) {
            super(view);
            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
            textViewPassword = (AppCompatTextView) view.findViewById(R.id.textViewPassword);
            textViewConfirmPassword = (AppCompatTextView)view.findViewById( R.id.textViewConfirmPassword );
        }
    }




}
