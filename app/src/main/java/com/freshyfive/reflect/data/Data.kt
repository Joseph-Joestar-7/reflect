package com.freshyfive.reflect.data

    val greetingsList = listOf<String>("","","")

    val quotesList: MutableMap<String, List<String>> = mutableMapOf(
        "ANGRY" to quotesAngry.toList(),
        "ANXIOUS" to quotesAnxious.toList(),
        "DEPRESSED" to quotesDepressed.toList(),
        "FRUSTRATED" to quotesFrustrated.toList(),
        "SAD" to quotesSad.toList(),
        "WORRIED" to quotesWorried.toList()
    )
    val studenttaskMap: MutableMap<String, List<String>> = mutableMapOf(
        "ANGRY" to tasksStudentAngry.toList(),
        "ANXIOUS" to tasksStudentAnxious.toList(),
        "DEPRESSED" to tasksStudentDepressed.toList(),
        "FRUSTRATED" to tasksStudentFrustrated.toList(),
        "SAD" to tasksStudentSad.toList(),
        "WORRIED" to tasksStudentWorried.toList()
    )

val workingtaskMap: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to tasksWorkingAngry.toList(),
    "ANXIOUS" to tasksWorkingAnxious.toList(),
    "DEPRESSED" to tasksWorkingDepressed.toList(),
    "FRUSTRATED" to tasksWorkingFrustrated.toList(),
    "SAD" to tasksWorkingSad.toList(),
    "WORRIED" to tasksWorkingWorried.toList()
)

val retiredtaskMap: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to tasksRetiredAngry.toList(),
    "ANXIOUS" to tasksRetiredAnxious.toList(),
    "DEPRESSED" to tasksRetiredDepressed.toList(),
    "FRUSTRATED" to tasksRetiredFrustrated.toList(),
    "SAD" to tasksRetiredSad.toList(),
    "WORRIED" to tasksRetiredWorried.toList()
)


val beats: List<Pair<String, String>> = listOf(
    "432Hz Deep Relaxation" to "https://www.youtube.com/watch?v=Mgwd_3k3pOw&list=RDQMHYGSpa2FLZY&start_radio=1",
    "528Hz Release Inner Conflict & Struggle" to "https://www.youtube.com/watch?v=UkM-FjfN6Mc",
    "Dopamine Detox" to "https://www.youtube.com/watch?v=Z8Fl_w2AXe8",
    "Calm an Overactive Mind: Reduce Anxiety & Worry," to "https://www.youtube.com/watch?v=mzH2Jw1s7TE",
    "Heal PTSD Brain | Cleanse Yourself Out From Traumatic Experience" to "https://www.youtube.com/watch?v=MHE5iOe14Js",
    "Anxiety Relief Music:" to "https://www.youtube.com/watch?v=JdoTmABeT0U",
    "Overcome Panic and Anxiety" to "https://www.youtube.com/watch?v=1dFvc42g8CA"
)

val studentArticleList: MutableMap<String, List<Article>> = mutableMapOf(
    "ANGRY" to articleStudentAngry.toList(),
    "ANXIOUS" to articlesStudentAnxious.toList(),
    "DEPRESSED" to articlesStudentDepressed.toList(),
    "FRUSTRATED" to articlesStudentFrustrated.toList(),
    "SAD" to articlesStudentSad.toList(),
    "WORRIED" to articlesStudentWorried.toList()
)
val professionalArticleList: MutableMap<String, List<Article>> = mutableMapOf(
    "ANGRY" to articleWorkingAngry.toList(),
    "ANXIOUS" to articlesWorkingAnxious.toList(),
    "DEPRESSED" to articlesWorkingDepressed.toList(),
    "FRUSTRATED" to articlesWorkingFrustrated.toList(),
    "SAD" to articlesWorkingSad.toList(),
    "WORRIED" to articlesWorkingWorried.toList()
)

val retiredArticleList: MutableMap<String, List<Article>> = mutableMapOf(
    "ANGRY" to articleRetiredAngry.toList(),
    "ANXIOUS" to articlesRetiredAnxious.toList(),
    "DEPRESSED" to articlesRetiredDepressed.toList(),
    "FRUSTRATED" to articlesRetiredFrustrated.toList(),
    "SAD" to articlesRetiredSad.toList(),
    "WORRIED" to articlesRetiredWorried.toList()
)

val studentBookList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to booksStudentAngry.toList(),
    "ANXIOUS" to booksStudentAnxious.toList(),
    "DEPRESSED" to booksStudentDepressed.toList(),
    "FRUSTRATED" to booksStudentFrustrated.toList(),
    "SAD" to booksStudentSad.toList(),
    "WORRIED" to booksStudentWorried.toList()
)

val professionalBookList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to booksWorkingAngry.toList(),
    "ANXIOUS" to booksWorkingAnxious.toList(),
    "DEPRESSED" to booksWorkingDepressed.toList(),
    "FRUSTRATED" to booksWorkingFrustrated.toList(),
    "SAD" to booksWorkingSad.toList(),
    "WORRIED" to booksWorkingWorried.toList()
)

val retiredBookList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to booksRetiredAngry.toList(),
    "ANXIOUS" to booksRetiredAnxious.toList(),
    "DEPRESSED" to booksRetiredDepressed.toList(),
    "FRUSTRATED" to booksRetiredFrustrated.toList(),
    "SAD" to booksRetiredSad.toList(),
    "WORRIED" to booksRetiredWorried.toList()
)

val studentMovieList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to moviesStudentAngry.toList(),
    "ANXIOUS" to moviesStudentAnxious.toList(),
    "DEPRESSED" to moviesStudentDepressed.toList(),
    "FRUSTRATED" to moviesStudentFrustrated.toList(),
    "SAD" to moviesStudentSad.toList(),
    "WORRIED" to moviesStudentWorried.toList()
)

val professionalMovieList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to moviesWorkingAngry.toList(),
    "ANXIOUS" to moviesWorkingAnxious.toList(),
    "DEPRESSED" to moviesWorkingDepressed.toList(),
    "FRUSTRATED" to moviesWorkingFrustrated.toList(),
    "SAD" to moviesWorkingSad.toList(),
    "WORRIED" to moviesWorkingWorried.toList()
)

val retiredMovieList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to moviesRetiredAngry.toList(),
    "ANXIOUS" to moviesRetiredAnxious.toList(),
    "DEPRESSED" to moviesRetiredDepressed.toList(),
    "FRUSTRATED" to moviesRetiredFrustrated.toList(),
    "SAD" to moviesRetiredSad.toList(),
    "WORRIED" to moviesRetiredWorried.toList()
)


val studentMusicList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to musicStudentAngry.toList(),
    "ANXIOUS" to musicStudentAnxious.toList(),
    "DEPRESSED" to musicStudentDepressed.toList(),
    "FRUSTRATED" to musicStudentFrustrated.toList(),
    "SAD" to musicStudentSad.toList(),
    "WORRIED" to musicStudentWorried.toList()
)

val professionalMusicList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to musicWorkingAngry.toList(),
    "ANXIOUS" to musicWorkingAnxious.toList(),
    "DEPRESSED" to musicWorkingDepressed.toList(),
    "FRUSTRATED" to musicWorkingFrustrated.toList(),
    "SAD" to musicWorkingSad.toList(),
    "WORRIED" to musicWorkingWorried.toList()
)

val retiredMusicList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to musicRetiredAngry.toList(),
    "ANXIOUS" to musicRetiredAnxious.toList(),
    "DEPRESSED" to musicRetiredDepressed.toList(),
    "FRUSTRATED" to musicRetiredFrustrated.toList(),
    "SAD" to musicRetiredSad.toList(),
    "WORRIED" to musicRetiredWorried.toList()
)

val studentShortFilmList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to shortfilmsStudentAngry.toList(),
    "ANXIOUS" to shortfilmsStudentAnxious.toList(),
    "DEPRESSED" to shortfilmsStudentDepressed.toList(),
    "FRUSTRATED" to shortfilmsStudentFrustrated.toList(),
    "SAD" to shortfilmsStudentSad.toList(),
    "WORRIED" to shortfilmsStudentWorried.toList()
)

val professionalShortFilmList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to shortfilmsWorkingAngry.toList(),
    "ANXIOUS" to shortfilmsWorkingAnxious.toList(),
    "DEPRESSED" to shortfilmsWorkingDepressed.toList(),
    "FRUSTRATED" to shortfilmsWorkingFrustrated.toList(),
    "SAD" to shortfilmsWorkingSad.toList(),
    "WORRIED" to shortfilmsWorkingWorried.toList()
)

val retiredShortFilmList: MutableMap<String, List<String>> = mutableMapOf(
    "ANGRY" to shortfilmsRetiredAngry.toList(),
    "ANXIOUS" to shortfilmsRetiredAnxious.toList(),
    "DEPRESSED" to shortfilmsRetiredDepressed.toList(),
    "FRUSTRATED" to shortfilmsRetiredFrustrated.toList(),
    "SAD" to shortfilmsRetiredSad.toList(),
    "WORRIED" to shortfilmsRetiredWorried.toList()
)

