2017-08-14
while using spring data, in Pagerequest, offset + limit combined should not be greater than Integer.MAX_VALUE
otherwise sorting won't work, tested on h2
so if limit is not specified use limit = Integer.Max_value - offset.