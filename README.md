### Eggs for Ebean

Some basic examples for Ebean. Usage of *egg* here is [SSCCE](http://sscce.org/) **not** a [hidden feature](https://en.wikipedia.org/wiki/Easter_egg_(media)).

### Prerequisites

* Examples use PostgreSQL via environment variables for connection info. 
    * See `db_server` to build a database via Docker.
    * For command-line apps, you must create a database with tables that matches the desired code in `~/net/codetojoy/ebean/model`. No DDL, no evolutions, etc.

### Eggs

*RECOMMENDED*. Start with this example, as it is the simplest, and fastest: 

* egg_v2_commandline_app_no_spring_gradle
    * no Spring Boot, simple project structure
    * uses Gradle: very fast
    * use-cases are written as tasks
    * derived from [this repo](https://github.com/TuxGamer/ebean-example)

These command-line examples use Maven and often Spring Boot (from the [original work](https://www.baeldung.com/ebean-orm)).

* egg_commandline_app_v15
    * uses `jakarta.persistence`
    * use-cases are written as tasks
* egg_v2_commandline_app_no_spring_experimental
    * no Spring Boot: much simpler Maven structure
    * use-cases are written as tasks
* egg_commandline_app_v13
    * uses `javax.persistence`
* egg_commandline_app_v12
    * uses `javax.persistence`

Examples with the Play Framework (useful when working with Play, as jar versions are curated): 

* egg_enum_mapping_play_v29x
    * uses Play as a basic driver to experiment with Ebean
    * See `LeagueController`, `RosterController`
* egg_enum_mapping_vplay_v30x
    * uses Play as a basic driver to experiment with Ebean
    * See `LeagueController`, `RosterController`

### Resources

* Play-ebean plugin versions [here](https://github.com/playframework/play-ebean)
* Ebean 15.x javadoc [here](https://javadoc.io/doc/io.ebean/ebean-api/latest/io.ebean.api/module-summary.html)

