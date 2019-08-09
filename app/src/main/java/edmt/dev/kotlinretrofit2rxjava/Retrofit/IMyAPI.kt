package edmt.dev.kotlinretrofit2rxjava.Retrofit

import edmt.dev.kotlinretrofit2rxjava.Model.Post
import retrofit2.http.GET
import io.reactivex.Observable
import java.util.*

interface IMyAPI {
    @get:GET("analizeTypes")
    val posts:Observable<List<Post>>
}