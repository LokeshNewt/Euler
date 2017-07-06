Create PROCEDURE getEmpiIdByLastName (
@lastName varchar(20)
)
As
Begin
select value as EmpiId, pi.PersonSID, p.firstName + ' ' + p.lastName as name from PersonIdentifier pi
inner join person p on pi.PersonSID = p.PersonSID
inner join xDictionary x on pi.typeDE = x.xDictionarySID
where x.CodeValue = 'EMPI' and pi.personSid in
(select MasterPersonSID from PersonIdentifierMap where personSid in (select PersonSID from person where lastName like @lastName))
End;

Create PROCEDURE getEmpiIdByPersonSid (
@personSid bigint
)
As
Begin
select value as EmpiId, p.firstName + ' ' + p.lastName as name from PersonIdentifier pi inner join person p on pi.PersonSID = p.PersonSID
inner join xDictionary x on pi.typeDE = x.xDictionarySID where x.CodeValue = 'empi' and pi.personSid in
(select MasterPersonSID from PersonIdentifierMap where personSid = @personSid)
End;

Create PROCEDURE getEmpiIdByMasterPersonSid (
@masterPersonSid bigint
)
As
Begin
select value as EmpiId, p.firstName + ' ' + p.lastName as name from PersonIdentifier pi inner join person p on pi.PersonSID = p.PersonSID
inner join xDictionary x on pi.typeDE = x.xDictionarySID where x.CodeValue = 'empi' and pi.personSid = @masterPersonSid
End;

Create PROCEDURE getPersonSidsByLastName (
@lastName varchar(20)
)
As
Begin
select PersonSID from PersonIdentifierMap where MasterPersonSID in (select MasterPersonSID from PersonIdentifierMap where personSid
in (select PersonSID from person where lastName like @lastName))
End;

create procedure getXDictionaryByCodeSystemAndCode (
@code varchar(20),
@oid varchar(50),
@version varchar(20)
)
As
Begin
select * from xDictionary where CodeValue = @code and xCodeSystemSID in
(select xCodeSystemSID from xCodeSystem where CodeSystemOID = @oid and VersionText = @version)
End;

create procedure getTableByPersonLastName (
@lastName varchar(20),
@tableName nvarchar(20)
)
AS
Begin
declare @sta nvarchar(max)=''
set @sta='select * from ' + @tableName + ' as p where p.PersonSID in (select personSid from PersonIdentifierMap where MasterPersonSID in
(select PersonSID from person where lastName like ''' +@lastName + '''))'
print @sta
exec(@sta)
End;

create procedure getAllPatients(
@personSid bigint
)
AS
Begin
select p.FirstName + ' ' + p.LastName from Person p where personSid > @personSid group by p.FirstName, p.LastName
End;

create procedure getConceptsByGroupName(
@name varchar(25)
)
AS
Begin
select * from xDictionaryConcept where xDictionaryConceptGroupSID = (select xDictionaryConceptGroupSID from
xDictionaryConceptGroup g where g.Name = @name)
End;

create procedure getConceptsByGroupSid(
@sid bigint
)
AS
Begin
select * from xDictionaryConcept where xDictionaryConceptGroupSID = (select xDictionaryConceptGroupSID from
xDictionaryConceptGroup g where g.xDictionaryConceptGroupSID = @sid)
End;

create procedure getConceptInfoByDictionarySid (
@dictonarySid bigint
)
AS
Begin
select xdcg.name as ConceptGroupName, xdc.Name as ConceptName, xd.xDictionarySID, xd.CodeValue, xd.DisplayName
from xDictionaryConcept xdc
inner join xDictionaryConceptGroup xdcg on xdc.xDictionaryConceptGroupSID = xdcg.xDictionaryConceptGroupSID
inner join xDictionaryConceptMap xdcm on xdc.xDictionaryConceptSID = xdcm.xDictionaryConceptSID
inner join xDictionary xd on xd.xDictionarySID = xdcm.xDictionarySID
where xd.xDictionarySID = @dictonarySid
End;

create procedure getConceptInfoByDictionaryCode (
@dictonaryCode varchar(25)
)
AS
Begin
select xdcg.name as ConceptGroupName, xdc.Name as ConceptName, xd.xDictionarySID, xd.CodeValue, xd.DisplayName
from xDictionaryConcept xdc
inner join xDictionaryConceptGroup xdcg on xdc.xDictionaryConceptGroupSID = xdcg.xDictionaryConceptGroupSID
inner join xDictionaryConceptMap xdcm on xdc.xDictionaryConceptSID = xdcm.xDictionaryConceptSID
inner join xDictionary xd on xd.xDictionarySID = xdcm.xDictionarySID
where xd.CodeValue = @dictonaryCode
End;

create procedure getTransmissionInfo
AS
Begin
select * from Transmission order by transmissionsid desc
End;

create procedure getCodeSystemInfoByDictionarySid (
@dictonarySid bigint
)
AS
Begin
select xcs.VersionText, xcs.CodeSystemOID, xcs.CodeSystemID, xcs.Name as CodeSystemName, xd.CodeValue, xd.DisplayName, xd.xDictionarySID
from xCodeSystem xcs
inner join xDictionary xd on xcs.xCodeSystemSID = xd.xCodeSystemSID where xd.xDictionarySID = @dictonarySid
End;

create procedure getCodeSystemInfoByDictionaryCode (
@dictonaryCode varchar(25)
)
AS
Begin
select xcs.VersionText, xcs.CodeSystemOID, xcs.CodeSystemID, xcs.Name as CodeSystemName, xd.CodeValue, xd.DisplayName, xd.xDictionarySID
from xCodeSystem xcs
inner join xDictionary xd on xcs.xCodeSystemSID = xd.xCodeSystemSID where xd.CodeValue = @dictonaryCode
End;

create procedure getCodesByConcept (
@cname varchar(25),
@gname varchar(25)
)
AS
Begin
select * from xDictionary where xDictionarySid in (select xDictionarySid from xDictionaryConceptMap
where xDictionaryConceptSID = (select xDictionaryConceptSID from xDictionaryConcept
where name = @cname and xDictionaryConceptGroupSID = (select xDictionaryConceptGroupSID from
xDictionaryConceptGroup where Name = @gname)))
End;