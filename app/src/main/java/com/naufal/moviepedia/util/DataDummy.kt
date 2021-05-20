package com.naufal.moviepedia.util

import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.TVEntity
import com.naufal.moviepedia.response.DetailMovieResp
import com.naufal.moviepedia.response.DetailTVResp
import com.naufal.moviepedia.response.MovieResp
import com.naufal.moviepedia.response.TVResp

object DataDummy {

    fun getDataMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.apply {
            add(
                MovieEntity(
                    id = 1,
                    title = "Alita: Battle Angel",
                    voteAverage = 7.3,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieEntity(
                    id = 2,
                    title = "Aquaman",
                    voteAverage = 6.9,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieEntity(
                    id = 3,
                    title = "Bohemian Rhapsody",
                    voteAverage = 8.0,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieEntity(
                    id = 4,
                    title = "Creed II",
                    voteAverage = 7.1,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieEntity(
                    id = 5,
                    title = "Glass",
                    voteAverage = 6.7,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieEntity(
                    id = 6,
                    title = "How to Train Your Dragon: The Hidden World",
                    voteAverage = 7.5,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieEntity(
                    id = 7,
                    title = "Avengers: Infinity War",
                    voteAverage = 8.4,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieEntity(
                    id = 8,
                    title = "Overlord",
                    voteAverage = 6.6,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieEntity(
                    id = 9,
                    title = "Ralph Breaks the Internet",
                    voteAverage = 7.0,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieEntity(
                    id = 10,
                    title = "Robin Hood",
                    voteAverage = 5.3,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
        }

        return movies
    }

    fun getRemoteDataMovies(): List<MovieResp> {

        val movies = ArrayList<MovieResp>()

        movies.apply {
            add(
                MovieResp(
                    id = 1,
                    title = "Alita: Battle Angel",
                    rate = 7.3,
                    language = "en"
                )
            )
            add(
                MovieResp(
                    id = 2,
                    title = "Aquaman",
                    rate = 6.9,
                    language = "en"
                )
            )
            add(
                MovieResp(
                    id = 3,
                    title = "Bohemian Rhapsody",
                    rate = 8.0,
                    language = "en"
                )
            )
            add(
                MovieResp(
                    id = 4,
                    title = "Creed II",
                    rate = 7.1,
                    language = "en"
                )
            )
            add(
                MovieResp(
                    id = 5,
                    title = "Glass",
                    rate = 6.7,
                    language = "en"
                )
            )
            add(
                MovieResp(
                    id = 6,
                    title = "How to Train Your Dragon: The Hidden World",
                    rate = 7.5,
                    language = "en"
                )
            )
            add(
                MovieResp(
                    id = 7,
                    title = "Avengers: Infinity War",
                    rate = 8.4,
                    language = "en"
                )
            )
            add(
                MovieResp(
                    id = 8,
                    title = "Overlord",
                    rate = 6.6,
                    language = "en"
                )
            )
            add(
                MovieResp(
                    id = 9,
                    title = "Ralph Breaks the Internet",
                    rate = 7.0,
                    language = "en"
                )
            )
            add(
                MovieResp(
                    id = 10,
                    title = "Robin Hood",
                    rate = 5.3,
                    language = "en"
                )
            )
        }
        return movies
    }


    fun getDataTV(): List<TVEntity> {

        val tv = ArrayList<TVEntity>()

        tv.apply {
            add(
                TVEntity(
                    id = 1,
                    name = "Arrow",
                    voteAverage = 7.7,
                    overview = "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption",
                    originalLanguage = "en"
                )
            )
            add(
                TVEntity(
                    id = 2,
                    name = "Dragon Ball",
                    voteAverage = 8.5,
                    overview = "Goku and Bulma's search continues for the seven Dragonballs.",
                    originalLanguage = "en"
                )
            )
            add(
                TVEntity(
                    id = 3,
                    name = "Fairy Tail",
                    voteAverage = 8.0,
                    overview = "Lucy, a celestial wizard, meets and befriends Natsu, a dragon slayer wizard. They, along with others from the Fairy Tail guild, embark on various paid missions to fight crime and wrongdoings.",
                    originalLanguage = "en"
                )
            )
            add(
                TVEntity(
                    id = 3,
                    name = "Family Guy",
                    voteAverage = 8.1,
                    overview = "Peter Griffin and his family of two teenagers, a smart dog, a devilish baby and his wife find themselves in some of the most hilarious scenarios.",
                    originalLanguage = "en"
                )
            )
            add(
                TVEntity(
                    id = 5,
                    name = "Flash",
                    voteAverage = 7.7,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                TVEntity(
                    id = 6,
                    name = "Game Of Thrones",
                    voteAverage = 9.3,
                    overview = "Nine noble families wage war against each other in order to gain control over the mythical land of Westeros. Meanwhile, a force is rising after millenniums and threatens the existence of living men.",
                    originalLanguage = "en"
                )
            )
            add(
                TVEntity(
                    id = 7,
                    name = "Gotham",
                    voteAverage = 7.4,
                    overview = "Detective James Gordon is a new recruit assigned to investigate the murder of Thomas and Martha Wayne. The case acquaints him with the slain couple's son and future crusader, Bruce.",
                    originalLanguage = "en"
                )
            )
            add(
                TVEntity(
                    id = 8,
                    name = "Hanna",
                    voteAverage = 7.5,
                    overview = "Hanna is an extraordinary girl who has been raised in the forest, evading the relentless pursuit of an off-the-book CIA agent. This series -- part high-concept thriller, part coming-of-age drama -- follows the girl on her journey as she tries to unearth the truth behind who she is. \"Hanna\" is based on the 2011 film of the same name that starred Oscar-nominated actress Saoirse Ronan in the title role.",
                    originalLanguage = "en"
                )
            )
            add(
                TVEntity(
                    id = 9,
                    name = "Iron Fist",
                    voteAverage = 6.5,
                    overview = "When Danny Rand was 10-years old, he survived a mysterious plane crash that claimed the lives of his extremely wealthy parents. Rescued by warrior monks, Danny grew up in the of city of K'un-Lun, where he endured harsh conditions, but also trained to be a fierce warrior. Years later, Danny returns home to New York, where he wants to reconnect with his past and take his rightful place at his family's company, which is being run by his father's former business partner. Danny hopes to restore his family legacy by defeating the people who threaten it.",
                    originalLanguage = "en"
                )
            )

            add(
                TVEntity(
                    id = 10,
                    name = "Naruto Shippuden",
                    voteAverage = 8.6,
                    overview = "Naruto Uzumaki wants to be the best ninja in the land. He's done well so far, but with the looming danger posed by the mysterious Akatsuki organization, Naruto knows he must train harder than ever and leaves his village for intense exercises that will push him to his limits.",
                    originalLanguage = "en"
                )
            )

        }

        return tv
    }

    fun getRemoteDataTV(): ArrayList<TVResp> {

        val tv = ArrayList<TVResp>()

        tv.apply {
            add(
                TVResp(
                    id = 1,
                    title = "Arrow",
                    rate = 7.7,
                    language = "en"
                )
            )
            add(
                TVResp(
                    id = 2,
                    title = "Dragon Ball",
                    rate = 8.5,
                    language = "en"
                )
            )
            add(
                TVResp(
                    id = 3,
                    title = "Fairy Tail",
                    rate = 8.0,
                    language = "en"
                )
            )
            add(
                TVResp(
                    id = 3,
                    title = "Family Guy",
                    rate = 8.1,
                    language = "en"
                )
            )
            add(
                TVResp(
                    id = 5,
                    title = "Flash",
                    rate = 7.7,
                    language = "en"
                )
            )
            add(
                TVResp(
                    id = 6,
                    title = "Game Of Thrones",
                    rate = 9.3,
                    language = "en"
                )
            )
            add(
                TVResp(
                    id = 7,
                    title = "Gotham",
                    rate = 7.4,
                    language = "en"
                )
            )
            add(
                TVResp(
                    id = 8,
                    title = "Hanna",
                    rate = 7.5,
                    language = "en"
                )
            )
            add(
                TVResp(
                    id = 9,
                    title = "Iron Fist",
                    rate = 6.5,
                    language = "en"
                )
            )

            add(
                TVResp(
                    id = 10,
                    title = "Naruto Shippuden",
                    rate = 8.6,
                    language = "en"
                )
            )

        }

        return tv
    }


}

