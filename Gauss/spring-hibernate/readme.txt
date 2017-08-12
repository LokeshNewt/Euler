hibernate


http://www.journaldev.com/2980/hibernate-ehcache-hibernate-second-level-cache
http://blog.jhades.org/setup-and-gotchas-of-the-hibernate-second-level-and-query-caches/

First level cache - maintains object in the cached state, it will not work if we will delete entire object from the database, it will work only if we
update that object, it maintains cache only in one session.
Second level cache - second and first level only works when using session.load() or using primary key
Query cache - Second and Query cache works side by side.