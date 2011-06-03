# lein-flyway

Leiningen plugin for running the [Flyway database migration framework](http://code.google.com/p/flyway/).
As a Leiningen plugin, it is meant to be run from a command-line terminal, however, during development, one may want to run it from the REPL.

## To run it from the command-line terminal
Add the following section in the defproject method of the `project.clj` file:

		:flyway {:driver "org.postgresql.Driver" :url "jdbc:postgresql:$DB$" :username "postgres" :password "$PWD$"}

All the tasks in the plugin expect a first argument called `project`. This `map` is passed as the value of this argument.

The above example connection string helps to connect to a PostgreSql database, so use an appropriate value for `:driver` for the database you are trying to connect to. Similarly for `:url, :username and :password` properties. Also replace `$DB$` with the name of the database you are connecting to and `$PWD$` with your password.

## To run it from the REPL
Require one of the namespaces from the plugin e.g.

		(require '[leiningen.flyway-status :as flyway-status])

To check the status of the database

	  (flyway-status/flyway-status {:flyway {:driver "org.postgresql.Driver" :url "jdbc:postgresql:$DB$" :username "postgres" :password "$PWD$"}})

Other tasks can be run similarly.

## Location for SQL migration files
When you pull the dependencies for this plugin using `lein deps` the various `.jar` files are pulled under `/lib/dev/` directory. Put your SQL migration files under `/db/migration/` directory under this `/lib/dev/` directory.

## TODO

* Some kind of equivalent for Java migrations
* Placeholders in migrations

## License

Copyright (C) 2010 Tero Parviainen

Distributed under the MIT license (see [LICENSE](http://github.com/teropa/lein-gwt/blob/master/LICENSE)).