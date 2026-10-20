package com.peregrine.quizmaster.data.repository

import android.util.Log
import com.google.firebase.firestore.firestore
import com.google.firebase.Firebase
import com.peregrine.quizmaster.data.model.Category
import com.peregrine.quizmaster.data.model.Question
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class FirestoreQuizRepository : QuizRepository {

    private val db = Firebase.firestore
    private val TAG = "FirestoreQuizRepository"

    override suspend fun getCategories(): List<Category> {
        return try {
            val snapshot = db.collection("categories")
                .whereEqualTo("isActive", true)
                .orderBy("order")
                .get()
                .await()

            val categories = snapshot.documents.mapNotNull { doc ->
                doc.toObject(Category::class.java)?.copy(id = doc.id)
            }
            Log.d(TAG, "Fetched ${categories.size} categories: $categories")
            categories
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching categories", e)
            emptyList()
        }
    }

    override fun getCategoriesFlow(): Flow<List<Category>> = callbackFlow {
        val listener = db.collection("categories")
            .whereEqualTo("isActive", true)
            .orderBy("order")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.e(TAG, "Listen failed", error)
                    trySend(emptyList())
                    return@addSnapshotListener
                }

                val categories = snapshot?.documents?.mapNotNull { doc ->
                    doc.toObject(Category::class.java)?.copy(id = doc.id)
                } ?: emptyList()

                Log.d(TAG, "Realtime snapshot received ${categories.size} categories")
                trySend(categories)
            }

        awaitClose { listener.remove() }
    }

    override suspend fun getQuestions(categoryId: String): List<Question> {
        return try {
            val snapshot = db.collection("questions")
                .whereEqualTo("categoryId", categoryId)
                .whereEqualTo("isActive", true)
                .orderBy("order")
                .get()
                .await()

            val questions = snapshot.documents.mapNotNull { doc ->
                doc.toObject(Question::class.java)?.copy(id = doc.id)
            }
            Log.d(TAG, "Fetched ${questions.size} questions for categoryId='$categoryId': $questions")
            questions
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching questions for categoryId='$categoryId'", e)
            emptyList()
        }
    }

    override suspend fun seedSampleData(): Result<Unit> {
        return try {
            val batch = db.batch()

            // 4 Categories
            val categories = listOf(
                mapOf("name" to "Sports & Athletics", "description" to "Test your knowledge of global sports, tournaments, and rules", "isActive" to true, "order" to 1),
                mapOf("name" to "Technology & Coding", "description" to "Computers, programming languages, and tech history", "isActive" to true, "order" to 2),
                mapOf("name" to "Movies & Cinema", "description" to "Blockbusters, directors, actors, and film history", "isActive" to true, "order" to 3),
                mapOf("name" to "Music & Instruments", "description" to "Genres, artists, hits, and musical theory", "isActive" to true, "order" to 4)
            )
            val catIds = listOf("sports", "technology", "movies", "music")

            for (i in categories.indices) {
                val ref = db.collection("categories").document(catIds[i])
                batch.set(ref, categories[i])
            }

            // 40 Questions (10 per category)
            val questions = listOf(
                mapOf("categoryId" to "sports", "question" to "How many players are on the field for a single team in a standard soccer match?", "options" to listOf("9", "10", "11", "12"), "correctAnswerIndex" to 2, "explanation" to "Each team plays with 11 players on the field, including the goalkeeper.", "isActive" to true, "order" to 1),
                mapOf("categoryId" to "sports", "question" to "Which country hosts the legendary tennis Grand Slam tournament known as Roland Garros?", "options" to listOf("United Kingdom", "France", "United States", "Australia"), "correctAnswerIndex" to 1, "explanation" to "Roland Garros, also known as the French Open, is held in Paris, France.", "isActive" to true, "order" to 2),
                mapOf("categoryId" to "sports", "question" to "In which sport is the prestigious 'Stanley Cup' awarded?", "options" to listOf("Baseball", "Ice Hockey", "American Football", "Basketball"), "correctAnswerIndex" to 1, "explanation" to "The Stanley Cup is the championship trophy awarded annually to the National Hockey League (NHL) playoff winner.", "isActive" to true, "order" to 3),
                mapOf("categoryId" to "sports", "question" to "How many rings are on the official Olympic Games symbol?", "options" to listOf("4", "5", "6", "7"), "correctAnswerIndex" to 1, "explanation" to "The Olympic symbol has five interlaced rings representing the five continents.", "isActive" to true, "order" to 4),
                mapOf("categoryId" to "sports", "question" to "What is the distance of a marathon race?", "options" to listOf("21.1 km", "42.2 km", "50.0 km", "10 miles"), "correctAnswerIndex" to 1, "explanation" to "A standard marathon is 42.195 kilometers (26.2 miles) long.", "isActive" to true, "order" to 5),
                mapOf("categoryId" to "sports", "question" to "Which boxer was known as 'The Greatest' and 'The People's Champion'?", "options" to listOf("Mike Tyson", "Joe Frazier", "Muhammad Ali", "Floyd Mayweather"), "correctAnswerIndex" to 2, "explanation" to "Muhammad Ali famously adopted the nickname 'The Greatest'.", "isActive" to true, "order" to 6),
                mapOf("categoryId" to "sports", "question" to "In basketball, how many points is a shot made from beyond the three-point arc worth?", "options" to listOf("1", "2", "3", "4"), "correctAnswerIndex" to 2, "explanation" to "Any successful field goal made from beyond the three-point line awards 3 points.", "isActive" to true, "order" to 7),
                mapOf("categoryId" to "sports", "question" to "Which country won the FIFA World Cup in 2018?", "options" to listOf("Brazil", "Germany", "France", "Argentina"), "correctAnswerIndex" to 2, "explanation" to "France won the 2018 FIFA World Cup hosted in Russia.", "isActive" to true, "order" to 8),
                mapOf("categoryId" to "sports", "question" to "What piece of equipment is used to strike a ball in the game of golf?", "options" to listOf("Club", "Bat", "Mallet", "Racket"), "correctAnswerIndex" to 0, "explanation" to "Golfers use various types of clubs to hit the ball into the hole.", "isActive" to true, "order" to 9),
                mapOf("categoryId" to "sports", "question" to "How many players are on the court for one basketball team in the NBA?", "options" to listOf("4", "5", "6", "7"), "correctAnswerIndex" to 1, "explanation" to "Each team plays with 5 players on the court at a time.", "isActive" to true, "order" to 10),

                mapOf("categoryId" to "technology", "question" to "What does CPU stand for?", "options" to listOf("Central Process Unit", "Computer Personal Unit", "Central Processing Unit", "Central Processor Utility"), "correctAnswerIndex" to 2, "explanation" to "CPU stands for Central Processing Unit, the primary component of a computer that executes instructions.", "isActive" to true, "order" to 1),
                mapOf("categoryId" to "technology", "question" to "Who is widely considered the inventor of the World Wide Web?", "options" to listOf("Bill Gates", "Tim Berners-Lee", "Steve Jobs", "Mark Zuckerberg"), "correctAnswerIndex" to 1, "explanation" to "Tim Berners-Lee invented the World Wide Web in 1989.", "isActive" to true, "order" to 2),
                mapOf("categoryId" to "technology", "question" to "Which programming language is primarily used for Android app development alongside Kotlin?", "options" to listOf("Swift", "Java", "Python", "Ruby"), "correctAnswerIndex" to 1, "explanation" to "Java has long been the primary language for Android development and is fully interoperable with Kotlin.", "isActive" to true, "order" to 3),
                mapOf("categoryId" to "technology", "question" to "What does HTML stand for?", "options" to listOf("Hyper Text Markup Language", "High Tech Modern Language", "Hyper Transfer Machine Language", "Hyperlink Text Management Language"), "correctAnswerIndex" to 0, "explanation" to "HTML stands for Hyper Text Markup Language, the standard language for creating web pages.", "isActive" to true, "order" to 4),
                mapOf("categoryId" to "technology", "question" to "Which company developed the Android operating system?", "options" to listOf("Apple", "Microsoft", "Google", "IBM"), "correctAnswerIndex" to 2, "explanation" to "Google purchased Android Inc. in 2005 and continues to develop the operating system.", "isActive" to true, "order" to 5),
                mapOf("categoryId" to "technology", "question" to "What is the name of Apple's proprietary object-oriented programming language for iOS development?", "options" to listOf("Objective-C", "Swift", "C#", "Kotlin"), "correctAnswerIndex" to 1, "explanation" to "Swift was introduced by Apple in 2014 for iOS, macOS, watchOS, and tvOS development.", "isActive" to true, "order" to 6),
                mapOf("categoryId" to "technology", "question" to "What does RAM stand for in computer hardware?", "options" to listOf("Readily Accessible Memory", "Random Access Memory", "Run Active Module", "Rapid Allocation Method"), "correctAnswerIndex" to 1, "explanation" to "RAM stands for Random Access Memory, which provides fast temporary data storage for the CPU.", "isActive" to true, "order" to 7),
                mapOf("categoryId" to "technology", "question" to "Which social media platform was originally launched under the name 'Thefacebook' in 2004?", "options" to listOf("Twitter", "Instagram", "Facebook", "LinkedIn"), "correctAnswerIndex" to 2, "explanation" to "Mark Zuckerberg launched Thefacebook while attending Harvard University.", "isActive" to true, "order" to 8),
                mapOf("categoryId" to "technology", "question" to "What is the main function of a DNS server?", "options" to listOf("Encrypt network traffic", "Translate domain names to IP addresses", "Store website databases", "Filter spam emails"), "correctAnswerIndex" to 1, "explanation" to "DNS (Domain Name System) translates human-friendly domain names (like google.com) into numerical IP addresses.", "isActive" to true, "order" to 9),
                mapOf("categoryId" to "technology", "question" to "Which database type stores data in flexible, JSON-like documents rather than rigid tables?", "options" to listOf("Relational Database", "SQL Database", "NoSQL Database", "Hierarchical Database"), "correctAnswerIndex" to 2, "explanation" to "NoSQL databases like Cloud Firestore store data in flexible documents.", "isActive" to true, "order" to 10),

                mapOf("categoryId" to "movies", "question" to "Which movie won the Academy Award for Best Picture in 1994?", "options" to listOf("Pulp Fiction", "The Shawshank Redemption", "Forrest Gump", "Schindler's List"), "correctAnswerIndex" to 2, "explanation" to "Forrest Gump won Best Picture at the 67th Academy Awards in 1995.", "isActive" to true, "order" to 1),
                mapOf("categoryId" to "movies", "question" to "Who directed the critically acclaimed science fiction film 'Inception' (2010)?", "options" to listOf("Steven Spielberg", "Christopher Nolan", "James Cameron", "Quentin Tarantino"), "correctAnswerIndex" to 1, "explanation" to "Christopher Nolan wrote and directed Inception.", "isActive" to true, "order" to 2),
                mapOf("categoryId" to "movies", "question" to "What is the name of the fictional African country where 'Black Panther' is set?", "options" to listOf("Zamunda", "Genovia", "Wakanda", "El Rico"), "correctAnswerIndex" to 2, "explanation" to "Wakanda is the technologically advanced fictional home of the Black Panther.", "isActive" to true, "order" to 3),
                mapOf("categoryId" to "movies", "question" to "Which animated movie features a young clownfish named Nemo?", "options" to listOf("Shark Tale", "Finding Nemo", "Moana", "The Little Mermaid"), "correctAnswerIndex" to 1, "explanation" to "Finding Nemo is a 2003 Pixar animated film about a father searching for his son Nemo.", "isActive" to true, "order" to 4),
                mapOf("categoryId" to "movies", "question" to "Who played the iconic character Jack Dawson in the 1997 blockbuster 'Titanic'?", "options" to listOf("Brad Pitt", "Tom Cruise", "Leonardo DiCaprio", "Johnny Depp"), "correctAnswerIndex" to 2, "explanation" to "Leonardo DiCaprio starred alongside Kate Winslet in James Cameron's Titanic.", "isActive" to true, "order" to 5),
                mapOf("categoryId" to "movies", "question" to "What is the highest-grossing film of all time worldwide (as of 2026)?", "options" to listOf("Avengers: Endgame", "Titanic", "Avatar", "Star Wars: The Force Awakens"), "correctAnswerIndex" to 2, "explanation" to "James Cameron's 2009 sci-fi epic Avatar holds the record for highest worldwide box office earnings.", "isActive" to true, "order" to 6),
                mapOf("categoryId" to "movies", "question" to "In 'The Matrix', what color pill does Neo take to discover the truth?", "options" to listOf("Blue", "Red", "Green", "Yellow"), "correctAnswerIndex" to 1, "explanation" to "Neo takes the red pill to stay in Wonderland and see how deep the rabbit hole goes.", "isActive" to true, "order" to 7),
                mapOf("categoryId" to "movies", "question" to "Which classic 1977 movie introduced the famous phrase 'May the Force be with you'?", "options" to listOf("Star Trek", "Star Wars", "Blade Runner", "Alien"), "correctAnswerIndex" to 1, "explanation" to "This famous phrase originated in George Lucas's original Star Wars film.", "isActive" to true, "order" to 8),
                mapOf("categoryId" to "movies", "question" to "Who voiced the beloved cowboy Woody in Pixar's 'Toy Story' series?", "options" to listOf("Tim Allen", "Tom Hanks", "Billy Crystal", "Robin Williams"), "correctAnswerIndex" to 1, "explanation" to "Tom Hanks provides the iconic voice for Sheriff Woody.", "isActive" to true, "order" to 9),
                mapOf("categoryId" to "movies", "question" to "Which cinematic universe features heroes like Iron Man, Thor, and Captain America?", "options" to listOf("DC Extended Universe", "Marvel Cinematic Universe", "MonsterVerse", "Wizarding World"), "correctAnswerIndex" to 1, "explanation" to "The Marvel Cinematic Universe (MCU) connects these iconic superhero stories.", "isActive" to true, "order" to 10),

                mapOf("categoryId" to "music", "question" to "How many strings does a standard acoustic or electric guitar have?", "options" to listOf("4", "5", "6", "7"), "correctAnswerIndex" to 2, "explanation" to "A standard guitar has 6 strings, typically tuned to E-A-D-G-B-E.", "isActive" to true, "order" to 1),
                mapOf("categoryId" to "music", "question" to "Which legendary rock band released the timeless rock anthem 'Bohemian Rhapsody' in 1975?", "options" to listOf("The Beatles", "Led Zeppelin", "Queen", "Pink Floyd"), "correctAnswerIndex" to 2, "explanation" to "Queen released Bohemian Rhapsody, written by Freddie Mercury, on their A Night at the Opera album.", "isActive" to true, "order" to 2),
                mapOf("categoryId" to "music", "question" to "What musical term indicates a very slow and leisurely tempo?", "options" to listOf("Allegro", "Adagio", "Presto", "Vivace"), "correctAnswerIndex" to 1, "explanation" to "Adagio in musical terminology means slow and stately.", "isActive" to true, "order" to 3),
                mapOf("categoryId" to "music", "question" to "Which pop superstar is known as the 'King of Pop'?", "options" to listOf("Elvis Presley", "Prince", "Michael Jackson", "Stevie Wonder"), "correctAnswerIndex" to 2, "explanation" to "Michael Jackson earned the enduring title 'King of Pop'.", "isActive" to true, "order" to 4),
                mapOf("categoryId" to "music", "question" to "What family of instruments does the saxophone belong to?", "options" to listOf("Brass", "Woodwind", "Percussion", "Strings"), "correctAnswerIndex" to 1, "explanation" to "Despite being made of brass, the saxophone is classified as a woodwind instrument because it uses a single-reed mouthpiece.", "isActive" to true, "order" to 5),
                mapOf("categoryId" to "music", "question" to "Which famous classical composer became completely deaf later in life yet continued composing masterpieces?", "options" to listOf("Wolfgang Amadeus Mozart", "Johann Sebastian Bach", "Ludwig van Beethoven", "Antonio Vivaldi"), "correctAnswerIndex" to 2, "explanation" to "Beethoven composed many of his greatest works, including his 9th Symphony, after losing his hearing.", "isActive" to true, "order" to 6),
                mapOf("categoryId" to "music", "question" to "How many keys are on a standard acoustic piano keyboard?", "options" to listOf("68", "76", "88", "92"), "correctAnswerIndex" to 2, "explanation" to "A standard piano features 88 keys (52 white keys and 36 black keys).", "isActive" to true, "order" to 7),
                mapOf("categoryId" to "music", "question" to "Which legendary British band featured members John Lennon, Paul McCartney, George Harrison, and Ringo Starr?", "options" to listOf("The Rolling Stones", "The Beatles", "The Who", "The Kinks"), "correctAnswerIndex" to 1, "explanation" to "The Beatles were an English rock band formed in Liverpool in 1960.", "isActive" to true, "order" to 8),
                mapOf("categoryId" to "music", "question" to "What is the term for a song or tune sung by a group of four vocalists in four-part harmony?", "options" to listOf("Duet", "Solo", "Quartet", "Choir"), "correctAnswerIndex" to 2, "explanation" to "A quartet is a group of four singers or musicians performing together.", "isActive" to true, "order" to 9),
                mapOf("categoryId" to "music", "question" to "Which instrument has pedals and 47 strings stretched across a tall wooden frame?", "options" to listOf("Cello", "Harp", "Violin", "Double Bass"), "correctAnswerIndex" to 1, "explanation" to "The concert harp is a large stringed instrument played by plucking with fingers.", "isActive" to true, "order" to 10)
            )

            for (i in questions.indices) {
                val questionId = "q_${i + 1}"
                val ref = db.collection("questions").document(questionId)
                batch.set(ref, questions[i])
            }

            batch.commit().await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

