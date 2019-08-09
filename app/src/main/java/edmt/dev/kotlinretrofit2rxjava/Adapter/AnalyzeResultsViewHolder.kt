package edmt.dev.kotlinretrofit2rxjava.Adapter


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.analyze_results_layout.view.*

class AnalyzeResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val txt_patientId = itemView.txt_patientId
    val txt_doctorId = itemView.txt_doctorId
    val txt_resultValue = itemView.txt_resultValue
    val txt_id = itemView.txt_id
}