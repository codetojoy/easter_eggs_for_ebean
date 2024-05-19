#!/bin/bash

export DB_USERNAME=postgres
export DB_PASSWORD=swordfish
export DB_NAME=sandbox
export DB_PORT=5432
export DB_URL=jdbc:postgresql://127.0.0.1:$DB_PORT/$DB_NAME?ssl=false

