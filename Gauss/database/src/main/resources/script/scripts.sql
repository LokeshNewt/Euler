Create PROCEDURE getEmpiIdByLastName2 (
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