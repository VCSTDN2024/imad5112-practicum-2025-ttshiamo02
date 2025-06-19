package vcmsa.ci.melodify

// Student Number: [ST10473572]
// Full Name: [TSHIAMO KATLEGO NKGE]

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Array to store songs
    private val songs = arrayOf(
        Song("Blinding Lights", "The Weeknd", 4, "Great pop song"),
        Song("Win Again", "Nicki Minaj", 5, "Best rap song"),
        Song("Poetry", "Tamia", 3, "Romantic ballad"),
        Song("Shake It Off", "Taylor Swift", 4, "Dance track")
    )

    private lateinit var etSongTitle: EditText
    private lateinit var etArtist: EditText
    private lateinit var etRating: EditText
    private lateinit var etComments: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        etSongTitle = findViewById(R.id.songTitleEditText)
        etArtist = findViewById(R.id.artistNameEditText)
        etRating = findViewById(R.id.ratingEditText)
        etComments = findViewById(R.id.commentsEditText)

        // Button click listeners
        findViewById<Button>(R.id.addButton).setOnClickListener { addSong() }
        findViewById<Button>(R.id.viewButton).setOnClickListener { viewPlaylist() }
        findViewById<Button>(R.id.exitButton).setOnClickListener { finish() }
    }

    private fun addSong() {
        try {
            val title = etSongTitle.text.toString()
            val artist = etArtist.text.toString()
            val rating = etRating.text.toString().toInt()
            val comments = etComments.text.toString()

            if (title.isEmpty() || artist.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return
            }

            if (rating !in 1..5) {
                Toast.makeText(this, "Rating must be 1-5", Toast.LENGTH_SHORT).show()
                return
            }

            // Add new song (in a real app, you'd add to a dynamic list)
            Toast.makeText(this, "Song added (demo only)", Toast.LENGTH_SHORT).show()
            clearFields()

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Invalid rating format", Toast.LENGTH_SHORT).show()
        }
    }

    private fun viewPlaylist() {
        val intent = Intent(this,PlaylistActivity::class.java).apply {
            putExtra("SONGS", songs)
        }
        startActivity(intent)
    }

    private fun clearFields() {
        etSongTitle.text.clear()
        etArtist.text.clear()
        etRating.text.clear()
        etComments.text.clear()
    }
}