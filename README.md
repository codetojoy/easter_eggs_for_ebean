### Eggs for Ebean

Some basic examples for Ebean. Usage of *egg* here is [SSCCE](http://sscce.org/) **not** a [hidden feature](https://en.wikipedia.org/wiki/Easter_egg_(media)).

### Prerequisites

* Examples use PostgreSQL via environment variables for connection info. 
    * See `db_server` to build a database via Docker.
    * For command-line apps, you must create a database with tables that matches the desired code in `~/net/codetojoy/ebean/model`. No DDL, no evolutions, etc.

### Eggs

* egg_commandline_app_v15
    * the most advanced example
    * uses `jakarta.persistence`
* egg_commandline_app_v13
    * uses `javax.persistence`
* egg_commandline_app_v12
    * uses `javax.persistence`
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
* Ebean 15.x javadoc [here](https://javadoc.io/doc/io.ebean/ebean-api/latest/io.ebean.api/module-summary.html)

