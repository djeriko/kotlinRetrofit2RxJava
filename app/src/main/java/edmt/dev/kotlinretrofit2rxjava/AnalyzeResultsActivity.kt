package edmt.dev.kotlinretrofit2rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import edmt.dev.kotlinretrofit2rxjava.Adapter.AnalyzeResultsAdapter
import edmt.dev.kotlinretrofit2rxjava.Model.AnalyzeResults
import edmt.dev.kotlinretrofit2rxjava.Retrofit.IMyAPI
import edmt.dev.kotlinretrofit2rxjava.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_analyze_results.*


class AnalyzeResultsActivity : AppCompatActivity() {
    internal lateinit var jsonApi: IMyAPI
    internal var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyze_results)

    //Init API

    val retrofit = RetrofitClient.instance
    jsonApi = retrofit.create(IMyAPI::
    class.java)

    //View
    recycler_analyzeResults.setHasFixedSize(true)
    recycler_analyzeResults.layoutManager = LinearLayoutManager(this)
    fetchData()
}

    private fun fetchData() {
        val idToken = "Token eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InRlc3RAdGVzdC5jb20iLCJpZCI6IjVkNDdiNTU2MjAzODQ5MDAxNzBmMjdiOSIsImV4cCI6MTU3MDI2NDYxOCwiaWF0IjoxNTY1MDgwNjE4fQ.lRrKt5PFPGwpIzy9592swJq5A1K-5HlIfhZYa4QE1lI"
        compositeDisposable.add(jsonApi.getAnalyzeResults(idToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe() { analyzeResults -> displayData(analyzeResults) }
        )
    }

    private fun displayData(analyzeResults: List<AnalyzeResults>?) {
        val adapter = AnalyzeResultsAdapter(this, analyzeResults!!)
        recycler_analyzeResults.adapter = adapter
    }

}
