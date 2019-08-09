package edmt.dev.kotlinretrofit2rxjava.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edmt.dev.kotlinretrofit2rxjava.Model.AnalyzeResults
import edmt.dev.kotlinretrofit2rxjava.R
import java.lang.StringBuilder

class AnalyzeResultsAdapter(internal var context: Context, internal var analyzeResultsList: List<AnalyzeResults>)
    : RecyclerView.Adapter<AnalyzeResultsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalyzeResultsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.analyze_results_layout, parent, false)
        return AnalyzeResultsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return analyzeResultsList.size
    }

    override fun onBindViewHolder(holder: AnalyzeResultsViewHolder, position: Int) {

        holder.txt_patientId.text = StringBuilder(analyzeResultsList[position].patientId)
        holder.txt_doctorId.text = StringBuilder(analyzeResultsList[position].doctorId)
        holder.txt_resultValue.text = StringBuilder(analyzeResultsList[position].resultValue)
        holder.txt_id.text = StringBuilder(analyzeResultsList[position]._id)
    }

}
