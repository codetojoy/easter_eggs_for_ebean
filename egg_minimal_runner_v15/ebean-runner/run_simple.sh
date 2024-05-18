#!/bin/bash

set -e

echo "checking for generated ebean.properties ..."
stat src/main/resources/ebean.properties > /dev/null 2>&1 

mvn spring-boot:run -Dstart-class=net.codetojoy.ebean.app.App 

