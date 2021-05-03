package com.naufal.moviepedia.data

import com.naufal.moviepedia.R
import com.naufal.moviepedia.model.Movie

object MovieData {

    fun getDataMovies() : List<Movie>{

        val movies = ArrayList<Movie>()

        movies.apply {
            add(
                Movie(
                    "m1",
                    "Alita: Battle Angel",
                    "Action, Sci-fi",
                    7.3,
                    "Alita, a battle cyborg, is revived by Ido, a doctor, who realises that she actually has the soul of a teenager. Alita then sets out to learn about her past and find her true identity.",
                    R.drawable.poster_alita,
                    "2019",
                    "2h 2m",
                    "en"
                )
            )
            add(
                Movie(
                    "m2",
                    "Aquaman",
                    "Action, Adventure",
                    6.9,
                    "Half-human, half-Atlantean Arthur is born with the ability to communicate with marine creatures. He goes on a quest to retrieve the legendary Trident of Atlan and protect the water world.",
                    R.drawable.poster_aquaman,
                    "2018",
                    "2h 22m",
                    "en"
                )
            )
            add(
                Movie(
                    "m3",
                    "Bohemian Rhapsody",
                    "Musical, Drama",
                    8.0,
                    "With his impeccable vocal abilities, Freddie Mercury and his rock band, Queen, achieve superstardom. However, amidst his skyrocketing success, he grapples with his ego, sexuality and a fatal illness.",
                    R.drawable.poster_bohemian,
                    "2018",
                    "2h 13m",
                    "en"
                )
            )
            add(
                Movie(
                    "m4",
                    "Creed II",
                    "Sport, Drama",
                    7.1,
                    "In 1985, Ivan Drago killed Apollo Creed in a tragic boxing match. Under the guidance of his trainer Rocky, Apollo's son Adonis confronts Drago's son in an ultimate showdown.",
                    R.drawable.poster_creed,
                    "2018",
                    "2h 10m",
                    "en"
                )
            )
            add(
                Movie(
                    "m5",
                    "Glass",
                    "Thriller, Drama",
                    6.7,
                    "While David confronts Kevin, a group of armed men intervene. Now locked in a mental facility with Elijah, the two find their superhuman abilities being questioned by Ellie, a secretive psychiatrist.",
                    R.drawable.poster_glass,
                    "2019",
                    "2h 9m",
                    "en"
                )
            )
            add(
                Movie(
                    "m6",
                    "How to Train Your Dragon: The Hidden World",
                    " Family, Fantasy",
                    7.5,
                    "Hiccup aims to unite the vikings and the dragons in order to bring peace on the island of Berk. However, he must stop the evil Grimmel and his devious plans to wipe out all dragons.",
                    R.drawable.poster_how_to_train,
                    "2019",
                    "1h 45m",
                    "en"
                )
            )
            add(
                Movie(
                    "m7",
                    "Avengers: Infinity War",
                    "Action, Sci-fi",
                    8.4,
                    "The Avengers must stop Thanos, an intergalactic warlord, from getting his hands on all the infinity stones. However, Thanos is prepared to go to any lengths to carry out his insane plan.",
                    R.drawable.poster_infinity_war,
                    "2018",
                    "2h 40m",
                    "en"
                )
            )
            add(
                Movie(
                    "m8",
                    "Overlord",
                    "Horror, Action",
                    6.6,
                    "Towards the end of World War II, American paratroopers set out to destroy a German radio tower. Soon enough, things take a murky turn when they come across a vicious secret.",
                    R.drawable.poster_overlord,
                    "2018",
                    "1h 48m",
                    "en"
                )
            )
            add(
                Movie(
                    "m9",
                    "Ralph Breaks the Internet",
                    "Family, Comedy",
                    7.0,
                    "Ralph and his best friend, Vanellope, face various challenges as they visit the uncharted land of the Internet through a Wi-Fi router at the arcade to save the game, Sugar Rush.",
                    R.drawable.poster_ralph,
                    "2018",
                    "1h 56m",
                    "en"
                )
            )
            add(
                Movie(
                    "m10",
                    "Robin Hood",
                    "Adventure, Action",
                    5.3,
                    "After returning home to England, aristocrat Robin of Loxley learns that the evil Sheriff of Nottingham has seized his family estate. He soon joins forces with Friar Tuck and Little John -- a fierce Arabian warrior who wants to put an end to the Crusades. Armed with arrows and dubbed Robin Hood, Loxley leads a band of oppressed rebels in a daring plan to rob the Sheriff of his money and take away his power.",
                    R.drawable.poster_robin_hood,
                    "2018",
                    "1h 56m",
                    "en"
                )
            )
        }

        return movies

    }

}