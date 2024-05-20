### Eggs for Ebean

Some basic examples for Ebean. Usage of *egg* here is [SSCCE](http://sscce.org/) **not** a [hidden feature](https://en.wikipedia.org/wiki/Easter_egg_(media)).

### Prerequisites

* Examples use PostgreSQL via environment variables for connection info. 
    * See `db_server` to build a database via Docker.

### Eggs

* egg_commandline_min_v13
    * uses `javax.persistence`
* egg_commandline_min_v15
    * uses `jakarta.persistence`
* egg_enum_mapping_v15
    * demonstrates an enum mapping error
* egg_enum_mapping_play_v29x
    * uses Play as a basic driver to experiment with Ebean
    * See LeagueController, RosterController
* egg_enum_mapping_vplay_v30x
    * uses Play as a basic driver to experiment with Ebean
    * See LeagueController, RosterController

### Resources

* Play-ebean plugin versions [here](https://github.com/playframework/play-ebean)

