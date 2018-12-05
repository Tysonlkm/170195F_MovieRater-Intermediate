package movierater.it2107.sit.nyp.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlin.concurrent.schedule
import java.util.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_movie.*

class add_Movie : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.landing_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==R.id.miAdd){
            val validateMovieName = inputMovieName.text
            val validateMovieDesc = inputMovieDesc.text
            val validateReleaseDate = inputReleaseDate.text
            if (validateMovieName.isNullOrEmpty()) {
                inputMovieName.error = "Field Empty"
            }
            if(validateMovieDesc.isNullOrEmpty()) {
                inputMovieDesc.error = "Field Empty"
            }
            if (validateReleaseDate.isNullOrEmpty()) {
                inputReleaseDate.error = "Field Empty"
            }
            if (validateMovieName.isNotEmpty()&&validateMovieDesc.isNotEmpty()&& validateReleaseDate.isNotEmpty()){
                displayMovie()
            }

        }
        else if (item?.itemId==R.id.miReset){
            inputMovieName.text.clear()
            inputMovieDesc.text.clear()
            inputReleaseDate.text.clear()
            english_radiobtn.isChecked=true
            chkboxMovieRating.isChecked=false
            chkboxMovieVl.visibility = View.GONE
            chkboxMovieVl.isEnabled=false
            chkboxMovieVl.isChecked = false
            chkboxMovielangUsed.visibility = View.GONE
            chkboxMovielangUsed.isEnabled = false
            chkboxMovielangUsed.isChecked = false
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        MovieRating()
    }
    private fun MovieRating(){
        chkboxMovieRating.setOnClickListener{
            if(chkboxMovieRating.isChecked){
                chkboxMovieVl.visibility = View.VISIBLE
                chkboxMovieVl.isEnabled = true
                chkboxMovielangUsed.visibility = View.VISIBLE
                chkboxMovielangUsed.isEnabled = true
            }
            else {
                chkboxMovieVl.visibility = View.GONE
                chkboxMovieVl.isEnabled=false
                chkboxMovieVl.isChecked = false
                chkboxMovielangUsed.visibility = View.GONE
                chkboxMovielangUsed.isEnabled = false
                chkboxMovielangUsed.isChecked = false
            }
        }
    }
    private fun displayMovie(){
        var movieLang = ""
        if (english_radiobtn.isChecked){
            movieLang = english_radiobtn.text.toString()
        }
        else if(chinese_radiobtn.isChecked){
            movieLang = chinese_radiobtn.text.toString()
        }

        else if(malay_radiobtn.isChecked){
            movieLang = malay_radiobtn.text.toString()
        }
        else if (tamil_radiobtn.isChecked) {
            movieLang = tamil_radiobtn.text.toString()
        }
        else{
            movieLang = english_radiobtn.text.toString()
        }
        var movieRating=""
        if(chkboxMovieRating.isChecked){
            movieRating = "false"
        }
        else{
            movieRating="true"
        }

        var vl =" "
        if(chkboxMovieVl.isChecked){
            vl = chkboxMovieVl.text.toString()
        }
        else{
            vl = "NA"
        }

        var langUsed = ""
        if(chkboxMovielangUsed.isChecked){
            langUsed = "Foul Language"
        }
        else {
            langUsed = "NA"
        }
        var movieRecommend =""
        if (movieRating=="true"){
            movieRecommend = "Yes"
        }
        else{
            movieRecommend="No"
        }
        val movieTitle = inputMovieName.text.toString()
        val movieDesc= inputMovieDesc.text.toString()
        val movieReleaseDate = inputReleaseDate.text.toString()
        val movieIntent = Intent(applicationContext, display_movie::class.java)
        movieIntent.putExtra("movieTitle", movieTitle)
        movieIntent.putExtra("movieDesc", movieDesc)
        movieIntent.putExtra("movieReleaseDate",movieReleaseDate)
        movieIntent.putExtra("movieLang", movieLang)
        movieIntent.putExtra("movieRecommend",movieRecommend)
        startActivity(movieIntent)
    }

}