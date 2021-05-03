package com.naufal.moviepedia.data

import com.naufal.moviepedia.R
import com.naufal.moviepedia.model.TV

object TVData {

    fun getDataTV(): List<TV> {

        val shows = ArrayList<TV>()

        shows.apply {
            add(
                TV(
                    "tv1",
                    "Arrow",
                    "Action",
                    7.7,
                    "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption",
                    R.drawable.poster_arrow,
                    "2012",
                    "42m",
                    "en"
                )
            )
            add(
                TV(
                    "tv2",
                    "Dragon Ball",
                    "Adventure",
                    8.5,
                    "Goku and Bulma's search continues for the seven Dragonballs.",
                    R.drawable.poster_dragon_ball,
                    "1986",
                    "24m",
                    "en"
                )
            )
            add(
                TV(
                    "tv3",
                    "Fairy Tail",
                    "Anime",
                    8.0,
                    "Lucy, a celestial wizard, meets and befriends Natsu, a dragon slayer wizard. They, along with others from the Fairy Tail guild, embark on various paid missions to fight crime and wrongdoings.",
                    R.drawable.poster_fairytail,
                    "2009",
                    "24m",
                    "en"
                )
            )
            add(
                TV(
                    "tv4",
                    "Family Guy",
                    "Sitcom",
                    8.1,
                    "Peter Griffin and his family of two teenagers, a smart dog, a devilish baby and his wife find themselves in some of the most hilarious scenarios.",
                    R.drawable.poster_family_guy,
                    "1999",
                    "22m",
                    "en"
                )
            )
            add(
                TV(
                    "tv5",
                    "Flash",
                    "Action, Adventure",
                    7.7,
                    "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.",
                    R.drawable.poster_flash,
                    "2014",
                    "43m",
                    "en"
                )
            )
            add(
                TV(
                    "tv6",
                    "Game Of Thrones",
                    "Drama",
                    9.3,
                    "Nine noble families wage war against each other in order to gain control over the mythical land of Westeros. Meanwhile, a force is rising after millenniums and threatens the existence of living men.",
                    R.drawable.poster_god,
                    "2011",
                    "57m",
                    "en"
                )
            )
            add(
                TV(
                    "tv7",
                    "Gotham",
                    "Action",
                    7.4,
                    "Detective James Gordon is a new recruit assigned to investigate the murder of Thomas and Martha Wayne. The case acquaints him with the slain couple's son and future crusader, Bruce.",
                    R.drawable.poster_gotham,
                    "2014",
                    "42m",
                    "en"
                )
            )
            add(
                TV(
                    "tv8",
                    "Hanna",
                    "Drama",
                    7.5,
                    "Hanna is an extraordinary girl who has been raised in the forest, evading the relentless pursuit of an off-the-book CIA agent. This series -- part high-concept thriller, part coming-of-age drama -- follows the girl on her journey as she tries to unearth the truth behind who she is. \"Hanna\" is based on the 2011 film of the same name that starred Oscar-nominated actress Saoirse Ronan in the title role.",
                    R.drawable.poster_hanna,
                    "2019",
                    "60m",
                    "en"
                )
            )
            add(
                TV(
                    "tv9",
                    "Iron Fist",
                    "Action, Fiction",
                    6.5,
                    "When Danny Rand was 10-years old, he survived a mysterious plane crash that claimed the lives of his extremely wealthy parents. Rescued by warrior monks, Danny grew up in the of city of K'un-Lun, where he endured harsh conditions, but also trained to be a fierce warrior. Years later, Danny returns home to New York, where he wants to reconnect with his past and take his rightful place at his family's company, which is being run by his father's former business partner. Danny hopes to restore his family legacy by defeating the people who threaten it.",
                    R.drawable.poster_iron_fist,
                    "2017",
                    "55m",
                    "en"
                )
            )

            add(
                TV(
                    "tv10",
                    "Naruto Shippuden",
                    "Action, Anime",
                    8.6,
                    "Naruto Uzumaki wants to be the best ninja in the land. He's done well so far, but with the looming danger posed by the mysterious Akatsuki organization, Naruto knows he must train harder than ever and leaves his village for intense exercises that will push him to his limits.",
                    R.drawable.poster_naruto_shipudden,
                    "2007",
                    "24m",
                    "en"
                )
            )

        }

        return shows

    }

}