Carbonado
===========

Carbonado is an extensible, high performance persistence abstraction layer for Java applications, providing a relational view to the underlying persistence technology. Persistence can be provided by a JDBC accessible SQL relational database, or it can be a Berkeley DB. It can also be fully replicated between the two.

Even if the backing database is not SQL based, Carbonado still supports many of the core features found in any kind of relational database. It supports queries, joins, indexes, and it performs query optimization. When used in this way, Carbonado is not merely a layer to a relational database, it **is** the relational database. SQL is not a requirement for implementing relational databases.

Defining new types in Carbonado involves creating an interface or abstract class which follows Java bean conventions. Additional information is specified by inserting special annotations. At the very least, an annotation is required to specify the primary key. Annotations are a feature first available in Java 5, and as a result, Carbonado depends on Java 5.

On the surface, it may appear that Carbonado types are defined like POJOs.  The difference is that in Carbonado, types are object representations of relations.  It is not an object database nor an object-relational bridge. In addition, data type definitions are simply interfaces, and there are no external configuration files. All the code to implement types is auto-generated, yet there are no extra build time steps.

Carbonado is able to achieve high performance by imposing very low overhead when accessing the actual storage. Low overhead is achieved in part by auto generating performance critical code, via the Cojen library.

Packages
---------

Carbonado is broken down into several package bundles for better dependency management. The easiest way to get started with Carbonado is to use the Berkeley DB JE backed repository. For this, you need to get the Carbonado and CarbonadoSleepycatJE package bundles.

* [Carbonado](https://github.com/Carbonado/Carbonado)
  Core Carbonado code, depends on [Apache Commons Logging](http://jakarta.apache.org/commons/logging/), [Joda-Time](http://joda-time.sourceforge.net/), and [Cojen](http://github.com/Cojen/Cojen).

* [CarbonadoSleepycatJE](https://github.com/Carbonado/CarbonadoSleepycatJE)
  Contains repository for supporting Sleepycat/Oracle, [Berkeley DB Java Edition](http://www.oracle.com/us/products/database/berkeley-db/je/overview/index.html). Berkeley DB JE code must be downloaded and installed separately.

* [CarbonadoSleepycatDB](https://github.com/Carbonado/CarbonadoSleepycatDB)
  Contains repository for supporting Sleepycat/Oracle [Berkeley DB](http://www.oracle.com/us/products/database/berkeley-db/overview/index.html). Berkeley DB code must be downloaded and installed separately.


Terminology
------------

Loose mapping from Carbonado terminology to SQL terminology:

| Carbonado           | SQL                     |
| ------------------- | ----------------------- |
| Repository          | database                |
| Storage             | table                   |
| Storable definition | table definition        |
| Storable instance   | table row               |
| property            | column                  |
| Query               | select/delete statement |
| Cursor              | result set              |


Limitations
-----------

Carbonado queries are not as expressive as SQL selects. Unlike SQL, Carbonado queries do not support data processing or aggregate functions.

Carbonado supports the minimal querying capability that makes automatic index selection possible. Other features available in SQL can be emulated in code. If the database is local, then this offers no loss of performance.

Applications that wish to use Carbonado only as a convenient layer over SQL will not be able to use full SQL features. Carbonado is by no means a replacement for JDBC. These kinds of applications may choose a blend of Carbonado and JDBC. To facilitate this, access to the JDBC connection in use by the current transaction is supported.

The Carbonado repositories that are backed by Berkeley DB use a rule-based query optimizer to come up with a query plan. Cost-based optimizers are generally much more effective, since they estimate I/O costs. Carbonado has a rule-based optimizer mainly because it is easier to write.


Persistence Technology Requirements
------------------------------------

Carbonado is capable of supporting many different kinds of persistence technologies. A minimum set of features is required, however, in order to provide enough Carbonado features to justify the effort:

* Arbitrary keys and values
* Get value by key
* Put value by key (does not need to distinguish insert vs update)
* Delete value by key
* Ordered key iteration
* Iteration start specified via full or partial key

Ideally, the persistence technology should support transactions. If it does not, then its transactions must be implemented by batching updates in memory. The updates are not persisted until the transaction is committed. If atomic batch updates are supported, then the repository can report supporting an isolation level of "read committed". Otherwise, it can only support the lowest level of "read uncommitted".

Additional features which are nice to have, but not strictly required:

* Reverse iteration
* ACID transactions
* Storable type segregation (eliminates need to define key prefixes)
* Truncation by storable type, if segregated 


See Also
----------

* [Carbonado User Guide](http://carbonado.github.io/Carbonado/docs/CarbonadoGuide.pdf)
* [Javadoc](http://carbonado.github.io/Carbonado/apidocs/overview-summary.html)
* [Trademark Policy](TRADEMARK.md)
