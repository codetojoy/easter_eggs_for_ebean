
### Prerequisites

* Postgres server 
* tested with Java 17, Maven 3.5.4 

### Usage

* confirm Postgres is running and populated
* confirm desired Ebean version in `./ebean-runner/pom.xml` (e.g. 15.1.0 vs 15.3.0)
* set database info in `./ebean-runner/setvars.sh` 
* in Terminal: 
    * `cd ebean-runner`
    * `. ./setvars.sh`
    * `./init.sh`
    * `./run_simple.sh`

### Attribution

* This project originated from [this Baeldung article](https://www.baeldung.com/ebean-orm) and [this repo](https://github.com/eugenp/tutorials/tree/master/libraries-data-db).
* It has been difficult to find an example of Ebean that didn't use Play Framework or Testcontainers. (Both Play and Testcontainers are great but not minimal, for experimentation).
