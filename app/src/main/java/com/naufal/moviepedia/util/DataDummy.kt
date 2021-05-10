package com.naufal.moviepedia.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naufal.moviepedia.R
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.response.DetailMovieResp
import com.naufal.moviepedia.response.DetailTVResp
import com.naufal.moviepedia.response.MovieResp
import com.naufal.moviepedia.response.TVResp

object DataDummy {

    fun getDataMovies() : ArrayList<MovieItems?> {

        val movies = ArrayList<MovieItems?>()

        movies.apply {
            add(
                MovieItems(
                    id = 1,
                    title = "Alita: Battle Angel",
                    voteAverage = 7.3,
                    overview = "Alita, a battle cyborg, is revived by Ido, a doctor, who realises that she actually has the soul of a teenager. Alita then sets out to learn about her past and find her true identity.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieItems(
                    id = 2,
                    title = "Aquaman",
                    voteAverage = 6.9,
                    overview = "Half-human, half-Atlantean Arthur is born with the ability to communicate with marine creatures. He goes on a quest to retrieve the legendary Trident of Atlan and protect the water world.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieItems(
                    id = 3,
                    title = "Bohemian Rhapsody",
                    voteAverage = 8.0,
                    overview = "With his impeccable vocal abilities, Freddie Mercury and his rock band, Queen, achieve superstardom. However, amidst his skyrocketing success, he grapples with his ego, sexuality and a fatal illness.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieItems(
                    id = 4,
                    title = "Creed II",
                    voteAverage = 7.1,
                    overview = "In 1985, Ivan Drago killed Apollo Creed in a tragic boxing match. Under the guidance of his trainer Rocky, Apollo's son Adonis confronts Drago's son in an ultimate showdown.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieItems(
                    id = 5,
                    title = "Glass",
                    voteAverage = 6.7,
                    overview = "While David confronts Kevin, a group of armed men intervene. Now locked in a mental facility with Elijah, the two find their superhuman abilities being questioned by Ellie, a secretive psychiatrist.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieItems(
                    id = 6,
                    title = "How to Train Your Dragon: The Hidden World",
                    voteAverage = 7.5,
                    overview = "Hiccup aims to unite the vikings and the dragons in order to bring peace on the island of Berk. However, he must stop the evil Grimmel and his devious plans to wipe out all dragons.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieItems(
                    id = 7,
                    title = "Avengers: Infinity War",
                    voteAverage= 8.4,
                    overview = "The Avengers must stop Thanos, an intergalactic warlord, from getting his hands on all the infinity stones. However, Thanos is prepared to go to any lengths to carry out his insane plan.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieItems(
                    id = 8,
                    title = "Overlord",
                    voteAverage = 6.6,
                    overview = "Towards the end of World War II, American paratroopers set out to destroy a German radio tower. Soon enough, things take a murky turn when they come across a vicious secret.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieItems(
                    id = 9,
                    title = "Ralph Breaks the Internet",
                    voteAverage = 7.0,
                    overview = "Ralph and his best friend, Vanellope, face various challenges as they visit the uncharted land of the Internet through a Wi-Fi router at the arcade to save the game, Sugar Rush.",
                    originalLanguage = "en"
                )
            )
            add(
                MovieItems(
                    id = 10,
                    title = "Robin Hood",
                    voteAverage = 5.3,
                    overview = "After returning home to England, aristocrat Robin of Loxley learns that the evil Sheriff of Nottingham has seized his family estate. He soon joins forces with Friar Tuck and Little John -- a fierce Arabian warrior who wants to put an end to the Crusades. Armed with arrows and dubbed Robin Hood, Loxley leads a band of oppressed rebels in a daring plan to rob the Sheriff of his money and take away his power.",
                    originalLanguage = "en"
                )
            )
        }

        return movies
    }

    fun getRemoteDataMovies() : ArrayList<MovieResp> {

        val movies = ArrayList<MovieResp>()

        movies.apply {
            add(
                MovieResp(
                    id = 1,
                    title = "Aquaman"
                )
            )
        }

        return movies
    }

    fun getRemoteDetailDataMovies(id: Int) : DetailMovieResp{
        return DetailMovieResp(id)
    }

    fun getDataTV() : ArrayList<TVItems?> {

        val tv = ArrayList<TVItems?>()

        tv.apply {
            add(
                TVItems(
                    id = 1,
                    name = "Arrow",
                    voteAverage = 7.7,
                    overview = "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption",
                    originalLanguage = "en"
                )
            )
            add(
                TVItems(
                    id = 2,
                    name = "Dragon Ball",
                    voteAverage = 8.5,
                    overview = "Goku and Bulma's search continues for the seven Dragonballs.",
                    originalLanguage = "en"
                )
            )
            add(
                TVItems(
                    id = 3,
                    name = "Fairy Tail",
                    voteAverage = 8.0,
                    overview = "Lucy, a celestial wizard, meets and befriends Natsu, a dragon slayer wizard. They, along with others from the Fairy Tail guild, embark on various paid missions to fight crime and wrongdoings.",
                    originalLanguage = "en"
                )
            )
            add(
                TVItems(
                    id = 3,
                    name = "Family Guy",
                    voteAverage = 8.1,
                    overview = "Peter Griffin and his family of two teenagers, a smart dog, a devilish baby and his wife find themselves in some of the most hilarious scenarios.",
                    originalLanguage = "en"
                )
            )
            add(
                TVItems(
                    id = 5,
                    name = "Flash",
                    voteAverage = 7.7,
                    overview = "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    originalLanguage = "en"
                )
            )
            add(
                TVItems(
                    id = 6,
                    name = "Game Of Thrones",
                    voteAverage = 9.3,
                    overview = "Nine noble families wage war against each other in order to gain control over the mythical land of Westeros. Meanwhile, a force is rising after millenniums and threatens the existence of living men.",
                    originalLanguage = "en"
                )
            )
            add(
                TVItems(
                    id = 7,
                    name = "Gotham",
                    voteAverage = 7.4,
                    overview = "Detective James Gordon is a new recruit assigned to investigate the murder of Thomas and Martha Wayne. The case acquaints him with the slain couple's son and future crusader, Bruce.",
                    originalLanguage = "en"
                )
            )
            add(
                TVItems(
                    id = 8,
                    name = "Hanna",
                    voteAverage = 7.5,
                    overview = "Hanna is an extraordinary girl who has been raised in the forest, evading the relentless pursuit of an off-the-book CIA agent. This series -- part high-concept thriller, part coming-of-age drama -- follows the girl on her journey as she tries to unearth the truth behind who she is. \"Hanna\" is based on the 2011 film of the same name that starred Oscar-nominated actress Saoirse Ronan in the title role.",
                    originalLanguage = "en"
                )
            )
            add(
                TVItems(
                    id = 9,
                    name = "Iron Fist",
                    voteAverage = 6.5,
                    overview = "When Danny Rand was 10-years old, he survived a mysterious plane crash that claimed the lives of his extremely wealthy parents. Rescued by warrior monks, Danny grew up in the of city of K'un-Lun, where he endured harsh conditions, but also trained to be a fierce warrior. Years later, Danny returns home to New York, where he wants to reconnect with his past and take his rightful place at his family's company, which is being run by his father's former business partner. Danny hopes to restore his family legacy by defeating the people who threaten it.",
                    originalLanguage = "en"
                )
            )

            add(
                TVItems(
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

    fun getRemoteDataTV() : ArrayList<TVResp> {

        val tv = ArrayList<TVResp>()

        tv.apply {
            add(
                TVResp(
                    id = 1,
                    title = "The Flash"
                )
            )
        }

        return tv
    }

    fun getRemoteDetailDataTV(id: Int) : DetailTVResp {
        return DetailTVResp(id)
    }

}