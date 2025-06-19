MELODIFY OVERVIEW

ST10473572
TSHIAMO KATLEGO NKGE

INTRODUCTION
Melodify is an Android app that helps users organize songs with ratings and comments. Built with Kotlin, it demonstrates core Android development concepts like arrays, loops, and multi-activity navigation. Users can add songs, view their playlist, and calculate average ratings. The app features input validation and clean UI design. Perfect for learning fundamental Android programming patterns.

FEATURES
- Add songs with title, artist (1-5 rating), and comments
- View scrollable playlist
- Calculate average song rating
- Input validation and error handling
- Clean two-activity navigation

SCREENSHOTS AND CODE EXAMPLES

1. Main Screen
![Main Activity]
![image](https://github.com/user-attachments/assets/71c62818-a122-431d-94b8-f3fabdbe2f2e)

In the main activity, the app initializes by setting up the main screen layout and loading sample song data into four parallel arrays (song titles, artists, ratings, and comments) when created.
 It configures click listeners for three buttons: "Add to Playlist" validates user input (ensuring non-empty fields and ratings between 1-5) before adding the new song details to the arrays and clearing the form; "View Playlist" bundles the arrays into an Intent and launches the PlaylistActivity to display the data; and "Exit" simply closes the app.
 The activity includes error handling for invalid inputs through try-catch blocks and Toast messages, while maintaining clean, commented code that follows Kotlin best practices for readability and maintenance.
   

 3. Playlist Screen 
![Playlist Activity]
![image](https://github.com/user-attachments/assets/0a8436d6-3be4-4d22-ad93-5ee04ff69a19)

 
In the PlaylistScreen , users can view and analyze their music playlist. When opened, the screen retrieves the song data (titles, artists, ratings, and comments) passed from the MainActivity. 
Clicking the "Show Songs" button dynamically displays the entire playlist in a scrollable view, listing each song's details (title, artist, rating, and comments) using a loop to iterate through the arrays
. The "Calculate Average Rating" button computes the average song rating by summing all ratings and dividing by the number of songs, then displays the result formatted to two decimal places. 
A "Back" button returns users to the main screen. The layout ensures clarity with proper spacing and organized text, while error handling prevents crashes if the playlist is empty.
This screen fulfills the assignment's requirements for displaying data with loops, calculating averages, and enabling seamless navigation.


  

3. Source Code Highlights
 MainActivity.kt 
 ![image](https://github.com/user-attachments/assets/5221c1f2-e1cf-4ff9-8faa-0b4f6e08f3d1)

kotlin
// Array to store songs
private val songs = arrayOf(
    Song("Blinding Lights", "The Weeknd", 4, "Pop"),
    Song("Savage", "Megan Thee Stallion", 5, "Rap")
)

// Calculate average rating
private fun calculateAverage(): Double {
    return songs.map { it.rating }.average()
}


Playlist Screen
![image](https://github.com/user-attachments/assets/24e17e8a-fcd7-4ef7-9e7b-983c96f6b7d3)

 
// Calculate average rating
private fun calculateAverage(): Double {
    return songs.map { it.rating }.average()
}

 BUILD INSTRUCTIONS
* Clone the repository
* Open in Android Studio
* Build and run on emulator or device
The App runs on bluestacks and the only problem that’s there is the Playlist Screen .


Github Repository
[github.com/https://github.com/VCSTDN2024/imad5112-practicum-2025-ttshiamo02]()


References
Garaganga,K.,2025.Introduction to Moblie Application. IMAD5112_MM.docx
 Available at: https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15 /Doc.aspx?sourcedoc=%BAIFF62FO-8EIA-47BC-99BD-CA07AE244270%7D&file =IMAD5112-MM.docx &action =default& mobiledirect=true




