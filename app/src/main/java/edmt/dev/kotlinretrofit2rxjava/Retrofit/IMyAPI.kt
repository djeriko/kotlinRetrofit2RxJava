package edmt.dev.kotlinretrofit2rxjava.Retrofit

import edmt.dev.kotlinretrofit2rxjava.Model.Post
import edmt.dev.kotlinretrofit2rxjava.Model.AnalyzeResults
import retrofit2.http.GET
import io.reactivex.Observable
import retrofit2.http.Header
import java.util.*

interface IMyAPI {
    @get:GET("analizeTypes")
    val posts:Observable<List<Post>>

    @get:GET("analyzeResults")
    val analyzeResults: Observable<List<AnalyzeResults>>

    @GET("analyzeResults")
    fun getAnalyzeResults(@Header("idtoken") Authorization: String): Observable<List<AnalyzeResults>>

}