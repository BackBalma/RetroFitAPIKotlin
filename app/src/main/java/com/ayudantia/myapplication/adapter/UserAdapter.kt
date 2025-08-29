package com.ayudantia.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayudantia.myapplication.R
import com.ayudantia.myapplication.model.UserItem

class UserAdapter(private val users:List<UserItem>): RecyclerView.Adapter<UserAdapter.ViewHolderClass>() {
    class ViewHolderClass(itemView:View):RecyclerView.ViewHolder(itemView) {
        val userName:TextView=itemView.findViewById(R.id.userName)
        val userEmail:TextView=itemView.findViewById(R.id.userEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_layout,parent,false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItems=users[position]
        holder.userName.text=currentItems.name
        holder.userEmail.text=currentItems.email
    }
}