package movierater.it2107.sit.nyp.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display_movie.*
import android.content.Intent
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View

class display_movie : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movie_details_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==R.id.miCancel){
           val main = Intent(applicationContext, landing_page::class.java)
            finish()
            startActivity(main)
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_movie)
        registerForContextMenu(DisplayReviewDesc)
        val bundle: Bundle? = intent.extras
        val movieTitle = bundle!!.getString("movieTitle")
        val movieDesc = bundle!!.getString("movieDesc")
        val movieDate = bundle!!.getString("movieReleaseDate")
        val movieLan = bundle!!.getString("movieLang")
        val movieRecommend = bundle!!.getString("movieRecommend")
        DisplayMovieName.text = movieTitle + "\n"
        DisplayMovieDesc.text = movieDesc + "\n"
        DisplayMovieLang.text = movieLan +"\n"
        DisplayMovieRelease.text = movieDate +"\n"
        DisplaySuitableAge.text = movieRecommend +"\n"
    }

    override fun onResume() {
        super.onResume()
        val bundle: Bundle? = intent.extras
        ratingBar.visibility == View.VISIBLE
        val movieReviewTitle = bundle!!.getString("movieTitle")
        val movieReviewDesc = bundle!!.getString("movieDesc")
        val movieReviewDate = bundle!!.getString("movieReleaseDate")
        val movieReviewLan = bundle!!.getString("movieLang")
        val movieReviewRecommend = bundle!!.getString("movieRecommend")
        val user = bundle!!.getString("userRating")
        val rating = bundle!!.getFloat("rate")
        DisplayMovieName.text = movieReviewTitle + "\n"
        DisplayMovieDesc.text = movieReviewDesc + "\n"
        DisplayReviewDesc.text = user + "\n"
        DisplayMovieLang.text = movieReviewLan +"\n"
        DisplayMovieRelease.text = movieReviewDate +"\n"
        DisplaySuitableAge.text = movieReviewRecommend +"\n"
        ratingBar.rating = rating

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        if(v?.id ==R.id.DisplayReviewDesc) {
            menu?.add(1, 1001, 1, "Add Review")
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId== 1001){
            val bundle: Bundle? = intent.extras
            val movieTitle = bundle!!.getString("movieTitle")
            val movieDesc = bundle!!.getString("movieDesc")
            val movieDate = bundle!!.getString("movieReleaseDate")
            val movieLan = bundle!!.getString("movieLang")
            val movieRecommend = bundle!!.getString("movieRecommend")
            val movieReview = Intent(applicationContext,movie_review::class.java)
            movieReview.putExtra("movieNameReview",movieTitle)
            movieReview.putExtra("movieDescReview", movieDesc)
            movieReview.putExtra("movieDateReview", movieDate)
            movieReview.putExtra("movieLanReview", movieLan)
            movieReview.putExtra("movieRecommendReview", movieRecommend)
            finish()
            startActivity(movieReview)
        }
        return super.onContextItemSelected(item)
    }
}


