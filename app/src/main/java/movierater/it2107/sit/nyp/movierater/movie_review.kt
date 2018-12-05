package movierater.it2107.sit.nyp.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_add_movie.*
import kotlinx.android.synthetic.main.activity_movie_review.*

class movie_review : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movie_review_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_review)
        val bundle: Bundle? = intent.extras
        val movieTitle = bundle!!.getString("movieNameReview")
        val movieDesc = bundle!!.getString("movieDescReview")
        val movieDate = bundle!!.getString("movieDateReview")
        val movieLan = bundle!!.getString("movieLanReview")
        val movieRecommend = bundle!!.getString("movieRecommendReview")

        reviewMovieName.text = "Enter Your review for movie: " + movieTitle + "\n"
        reviewMovieDesc.text = "Movie description: " + movieDesc + "\n"
        reviewMovieDate.text = "Movie release date: " + movieDate + "\n"
        reviewMovieLang.text = "Movie language: " + movieLan + "\n"
        reviewMovieRecommend.text = "Suitable for children below 13: " + movieRecommend
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==R.id.miSubmit){
            val bundle: Bundle? = intent.extras
            val movieTitle = bundle!!.getString("movieNameReview")
            val movieDesc = bundle!!.getString("movieDescReview")
            val movieDate = bundle!!.getString("movieDateReview")
            val movieLan = bundle!!.getString("movieLanReview")
            val movieRecommend = bundle!!.getString("movieRecommendReview")
            val user = userReview.text
            val rating = ratingBar.rating
            val movieIntent = Intent(applicationContext, display_movie::class.java)
            movieIntent.putExtra("movieTitle", movieTitle)
            movieIntent.putExtra("movieDesc", movieDesc)
            movieIntent.putExtra("movieReleaseDate",movieDate)
            movieIntent.putExtra("movieLang", movieLan)
            movieIntent.putExtra("movieRecommend",movieRecommend)
            movieIntent.putExtra("userRating", user)
            movieIntent.putExtra("rate", rating)
            startActivity(movieIntent)
        }

        return super.onOptionsItemSelected(item)
    }
}
