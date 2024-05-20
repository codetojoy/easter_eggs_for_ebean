#!/bin/bash

set -e 

echo "checking for generated application.properties ..."
stat src/main/resources/application.properties > /dev/null 2>&1 

mvn clean compile spring-boot:run -Dstart-class=net.codetojoy.ebean.app.App 

