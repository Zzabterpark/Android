package com.example.zzabterpark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private var banners: List<String>) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sports_item_view_pager, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = banners[position]
        when (banners[position]) {
            "축구" -> holder.imageView.setImageResource(R.drawable.soccer_banner)
            "야구" -> holder.imageView.setImageResource(R.drawable.baseball_banner)
            "E스포츠" -> holder.imageView.setImageResource(R.drawable.esports_banner)
        }
    }

    override fun getItemCount(): Int {
        return banners.size
    }

    fun updateBanners(newBanners: List<String>) {
        this.banners = newBanners
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}
