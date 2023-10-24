package com.example.diffutils_in_recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutils_in_recycler.databinding.PostItemBinding

class SampleAdapter : RecyclerView.Adapter<SampleAdapter.ViewHolder>() {


    private lateinit var binding: PostItemBinding


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
        holder.setIsRecyclable(false)
    }
    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun setData(item: PostsItem) {
            binding.apply {
                tvUsername.text = item.userName
                tvPostcontent.text = item.contentTitle
                ivImagecontent.setImageResource(item.contentImage)
                ivProfile.setImageResource(item.userImage)
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<PostsItem>() {
        override fun areItemsTheSame(oldItem: PostsItem, newItem: PostsItem): Boolean {
            return oldItem.userName == newItem.userName
        }

        override fun areContentsTheSame(oldItem: PostsItem, newItem: PostsItem): Boolean {
            return oldItem == newItem
        }
    }
val differ = AsyncListDiffer(this,differCallBack)

}