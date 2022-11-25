//package com.uc.week4retrofit.adapter
//
//import android.app.Activity
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
//import com.uc.week4retrofit.model.Genre
//import com.uc.week4retrofit.model.MovieDetails
//import com.uc.week4retrofit.model.ProductionCompany
//import com.uc.week4retrofit.model.Result
//import com.uc.week4retrofit.view.MovieDetail
//
//class CompanyAdapter(private val dataSet: List<ProductionCompany>) :
//    RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {
//
//    /**
//     * Provide a reference to the type of views that you are using
//     * (custom ViewHolder).
//     */
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val ivCompLogo: ImageView
//
//
//        init {
//            // Define click listener for the ViewHolder's View.
//            ivCompLogo = view.findViewById(R.id.iv_company_logo)
//        }
//    }
//
//    // Create new views (invoked by the layout manager)
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        // Create a new view, which defines the UI of the list item
//        val view = LayoutInflater.from(viewGroup.context)
//            .inflate(R.layout.card_company_logo, viewGroup, false)
//
//        return ViewHolder(view)
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//
//        // Get element from your dataset at this position and replace the
//        // contents of the view with that element
//
//        Glide.with(viewHolder.ivCompLogo.context).load(Const.IMG_URL+dataSet[position].logo_path).into(viewHolder.ivCompLogo)
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    override fun getItemCount() = dataSet.size
//
//}
