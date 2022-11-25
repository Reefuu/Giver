//package com.uc.week4retrofit.adapter
//
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.cardview.widget.CardView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.uc.week4retrofit.R
//import com.uc.week4retrofit.helper.Const
//import com.uc.week4retrofit.model.Result
//import com.uc.week4retrofit.view.MovieDetail
//
//class NowPlayingAdapter(private val dataSet: ArrayList<Result>) :
//    RecyclerView.Adapter<NowPlayingAdapter.ViewHolder>() {
//
//    /**
//     * Provide a reference to the type of views that you are using
//     * (custom ViewHolder).
//     */
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val tvTitleNow: TextView
//        val tvReleased: TextView
//        val cvNowPlaying: CardView
//        val ivPoster: ImageView
//
//
//        init {
//            // Define click listener for the ViewHolder's View.
//            tvTitleNow = view.findViewById(R.id.tv_title_now_playing)
//            tvReleased = view.findViewById(R.id.tv_released_now_playing)
//            cvNowPlaying = view.findViewById(R.id.cv_now_playing)
//            ivPoster = view.findViewById(R.id.iv_poster_now_playing)
//        }
//    }
//
//    // Create new views (invoked by the layout manager)
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        // Create a new view, which defines the UI of the list item
//        val view = LayoutInflater.from(viewGroup.context)
//            .inflate(R.layout.card_now_playing, viewGroup, false)
//
//        return ViewHolder(view)
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//
//        // Get element from your dataset at this position and replace the
//        // contents of the view with that element
//        viewHolder.tvTitleNow.text = dataSet[position].title
//        viewHolder.tvReleased.text = dataSet[position].release_date
//        viewHolder.cvNowPlaying.setOnClickListener{
//            val intent = Intent(it.context, MovieDetail::class.java)
//            intent.putExtra("movie_id", dataSet[position].id)
//            it.context.startActivity(intent)
//        }
//        Glide.with(viewHolder.ivPoster.context).load(Const.IMG_URL+dataSet[position].poster_path).into(viewHolder.ivPoster)
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    override fun getItemCount() = dataSet.size
//
//}
