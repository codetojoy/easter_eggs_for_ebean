#!/bin/bash

# mvn clean install -Pparents
# mvn install
# mvn compile

mvn clean compile spring-boot:run -Dstart-class=com.baeldung.libraries.ebean.app.App 

