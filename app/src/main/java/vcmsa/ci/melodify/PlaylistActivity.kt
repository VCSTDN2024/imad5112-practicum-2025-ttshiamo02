package vcmsa.ci.melodify
// STUDENT NUMBER: [ST10473572]
// STUDENT NAME : [ TSHIAMO KATLEGO NKGE]

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


data class Song(
    val title: String,
    val artist: String,
    val rating: Int,
    val comments: String
)

class PlaylistActivity : AppCompatActivity() {

    // Immutable properties (val)
    private lateinit var tvPlaylist: TextView
    private lateinit var tvAverage: TextView
    private lateinit var btnCalculate: Button
    private lateinit var btnBack: Button

    // Mutable property (var)
    private var songs: Array<Song> = emptyArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailsactivity)
        initializeViews()
        loadSongs()
        setupUi()
    }

    private fun initializeViews() {
        tvPlaylist = findViewById(R.id.songsTextView)
        tvAverage = findViewById(R.id.resultTextView)
        btnCalculate = findViewById(R.id.calculateRatingButton)
        btnBack = findViewById(R.id.backButton)

    }

    private fun loadSongs() {
        songs = intent.getSerializableExtra("SONGS") as? Array<Song> ?: emptyArray()
    }

    private fun setupUi() {
        displayPlaylist()
        setupButtonListeners()
    }

    private fun displayPlaylist() {
        val playlistText = buildString {
            songs.forEachIndexed { index, song ->
                append("${index + 1}. ${song.title} by ${song.artist}\n")
                append("   Rating: ${song.rating}/5\n")
                append("   Comments: ${song.comments}\n\n")
            }
        }
        tvPlaylist.text = playlistText
    }

    private fun setupButtonListeners() {
        btnCalculate.setOnClickListener { calculateAverageRating() }
        btnBack.setOnClickListener { finish() }
    }

    private fun calculateAverageRating() {
        val average = if (songs.isNotEmpty()) {
            songs.map { it.rating }.average()
        } else {
            0.0
        }
        tvAverage.text = "Average Rating: %.2f/5".format(average)
    }
}
