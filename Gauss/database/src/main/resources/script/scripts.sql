--select * from xProvider xp;

--select * from vwPatientProviderDetail;

--select * from ProviderPatient;

--select * from xUser;

--select distinct masterPersonSID from vwUserProviderPatient where UserId = 29 and relationshipTypeDE <> -1;


select distinct masterPersonSID from vwUserProviderPatient where UserId = 29
and relationshipTypeDE <> -1;
