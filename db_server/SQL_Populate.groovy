
@Grapes(
    @Grab(group='org.postgresql', module='postgresql', version='42.6.0')
)
@GrabConfig(systemClassLoader=true)

import groovy.sql.*
import org.postgresql.*

def myGetEnv = { envVar ->
    def result = System.getenv(envVar)
    assert result
    assert !result.isEmpty()
    return result
}

final String DB_NAME = myGetEnv("DB_NAME")
final String DB_USERNAME = myGetEnv("DB_USERNAME")
final String DB_PASSWORD = myGetEnv("DB_PASSWORD")

def user = DB_USERNAME
def password = DB_PASSWORD
def host = "127.0.0.1"
def port = 5432
def database = DB_NAME

def sql = Sql.newInstance("jdbc:postgresql://${host}:${port}/${database}", user, password, "org.postgresql.Driver")

// roster

def myExecute(def sql, def id, def status) {
    String name = "name-" + id

    def insert

    // roster
    insert = " INSERT INTO roster (id, name, status) VALUES (?,?,?); "
    sql.execute(insert, [id, name, status]) 

    String name2 = "name-league-" + id
    def leagueId = id + 10000
    // league
    insert = " INSERT INTO league (id, name, status) VALUES (?,?,?); "
    sql.execute(insert, [leagueId, name2, status]) 
}

def id

id = 4140
myExecute(sql, id++, "ACTIVE")
myExecute(sql, id++, "INJURED")
myExecute(sql, id++, "RETIRED")
myExecute(sql, id++, "PENDING")

id = 5150
myExecute(sql, id++, "ACTIVE")
myExecute(sql, id++, "INJURED")
myExecute(sql, id++, "RETIRED")
myExecute(sql, id++, "PENDING")

id = 6160
myExecute(sql, id++, "ACTIVE")
myExecute(sql, id++, "INJURED")
myExecute(sql, id++, "RETIRED")
myExecute(sql, id++, "PENDING")

sql.close()
