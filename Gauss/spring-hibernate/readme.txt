hibernate


http://www.journaldev.com/2980/hibernate-ehcache-hibernate-second-level-cache
http://blog.jhades.org/setup-and-gotchas-of-the-hibernate-second-level-and-query-caches/

First level cache - maintains object in the cached state, it will not work if we will delete entire object from the database, it will work only if we
update that object, it maintains cache only in one session.
Second level cache - second and first level only works when using session.load() or using primary key
Query cache - Second and Query cache works side by side.

Hibernate :
An ORM tool
Implements JPA

SessionFactory :
one object per application

hbm2ddl.auto
create - drop and re-create the schema on startup

annotations -
basic - only useful with its properties
transient - if we don't want hibernate to persist it
temporal - to manage date fields
Lob - if object is very large, then mark it as @Lob and database will create it like for e.g. varchar(max) in mssql

primary keys -
default stratergy is GenerationType.AUTO - it means hibernate will decide which is the best strategy according to your database
GenerationType.SEQUENCE - create a sequence hibernate_sequence to generate unique key
GenerationType.IDENTITY - use Identity columns
in sql, on using AUTO it uses SEQUENCE

Default Fetch type is LazyFetching.
hibernate use prozy objects to provide lazy fetching.
What hibernate return from session.get() methods are proxy objects that are sub-classes of main objects.