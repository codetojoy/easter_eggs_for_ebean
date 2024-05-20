#!/bin/bash

set -e 

function check_env_var () {
    if [ -n "$1" ]; then
      : # no-op
    else
      echo "usage: please set env var: $2"
      exit -1
    fi
}

check_env_var "$DB_USERNAME" "DB__USERNAME"
check_env_var "$DB_PASSWORD" "DB_PASSWORD"
check_env_var "$DB_URL" "DB_URL"

mvn install

# process-classes is critical for Ebean enhancement (via plugin)
mvn clean compile process-classes

mvn exec:java -Dexec.mainClass="net.codetojoy.ebean.app.App"
