package com.example.newsfresh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*This adapter extends a viewholder class as all the small-small
  items are views which are passed to recycler view through
  viewholder;
  adapter requires data which it gets by activity;
  listener is instance of interface*/

class NewsListAdapter(private val items:ArrayList<String>, private val listener:newsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {

    /*gets called when we are creating each viewholder on the screen
      jitne views utni baar call hoga
      layoutInfalter converts xml to views
      parent – The ViewGroup into which the new View will be added after it is bound to an adapter position.
      viewType – The view type of the new View. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)

        /*viewHolder instance made here as we require position of item which is
          provided by viewholder*/
        val viewHolder = NewsViewHolder(view)


        //handling each view's listening
        /*responsibility of whatever we want on clicking should be of
          activity not adapter so to let activity know that
          something is clicked we need a callback so for these
          callbacks simple method is interfaces*/
        view.setOnClickListener {
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    /*going to bind data with viewholder
      this function takes item one-by-one then fills the data
      corresponding to that item, basically performs binding

      position tells which position item to bind*/
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text=currentItem
    }

    /*only gets called first time and tells about how many items will
      be there in this list*/
    override fun getItemCount(): Int {
        return items.size
    }

}

/*this itemview will have all the small small items which we want
  to inflate/have in our recycler view to be repeated so for those items we made item_news
  file where these items are made
  itemView is the whole item_news constraint layout i.e that xml file*/
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val titleView:TextView=itemView.findViewById(R.id.title1)
}

interface newsItemClicked{
    fun onItemClicked(item:String)
}
