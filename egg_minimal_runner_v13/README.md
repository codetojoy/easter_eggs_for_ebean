
### Prerequisites

* Postgres server 
* tested with Java 17, Maven 3.5.4 

### Usage

* ensure Postgres is running
* `cd ebean-runner`
* set database info in `./setvars.sh` 
* `. ./init.sh`
* `./run_simple.sh`

### Attribution

* This project originated from [this Baeldung article](https://www.baeldung.com/ebean-orm) and [this repo](https://github.com/eugenp/tutorials/tree/master/libraries-data-db).
* It has been difficult to find an example of Ebean that didn't use Play Framework or Testcontainers. (Both Play and Testcontainers are great but not minimal, for experimentation).
