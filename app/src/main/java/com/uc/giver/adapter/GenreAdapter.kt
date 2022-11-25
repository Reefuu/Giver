//package com.uc.week4retrofit.adapter
//
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.cardview.widget.CardView
//import androidx.recyclerview.widget.RecyclerView
//import com.uc.week4retrofit.R
//import com.uc.week4retrofit.model.Genre
//import com.uc.week4retrofit.model.MovieDetails
//import com.uc.week4retrofit.model.Result
//import com.uc.week4retrofit.view.MovieDetail
//
//class GenreAdapter(private val dataSet: List<Genre>) :
//    RecyclerView.Adapter<GenreAdapter.ViewHolder>() {
//
//    /**
//     * Provide a reference to the type of views that you are using
//     * (custom ViewHolder).
//     */
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val tvGenre: TextView
//
//
//        init {
//            // Define click listener for the ViewHolder's View.
//            tvGenre = view.findViewById(R.id.tv_genre_movie_details)
//        }
//    }
//
//    // Create new views (invoked by the layout manager)
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        // Create a new view, which defines the UI of the list item
//        val view = LayoutInflater.from(viewGroup.context)
//            .inflate(R.layout.card_genre_list_movie_details, viewGroup, false)
//
//        return ViewHolder(view)
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//
//        // Get element from your dataset at this position and replace the
//        // contents of the view with that element
//        viewHolder.tvGenre.text = dataSet[position].name
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    override fun getItemCount() = dataSet.size
//
//}
