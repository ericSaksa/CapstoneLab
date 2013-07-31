create table Item_BandMembers (
	ItemBandMemberId INTEGER not null primary key IDENTITY,
	ItemId INTEGER,
	Member VARCHAR(75) null
);

create table PurchaseItem (
	PurchaseItemId INTEGER not null primary key IDENTITY,
	PoId INTEGER,
	ItemId INTEGER,
	Quantity INTEGER,
	UnitPrice DOUBLE
);

create table PurchaseOrder (
	PoId INTEGER not null primary key IDENTITY,
	Status INTEGER,
	OrderDate DATE null,
	UserId INTEGER
);

create table capstone_PurchaseOrder (
	PoId INTEGER not null primary key IDENTITY,
	Status INTEGER,
	OrderDate DATE null,
	UserId INTEGER
);

create table inventory (
	InvId INTEGER not null primary key IDENTITY,
	ItemId INTEGER,
	URL VARCHAR(75) null,
	NoOfLicence INTEGER,
	FileType VARCHAR(75) null
);

create table item (
	ItemId INTEGER not null primary key IDENTITY,
	Num VARCHAR(75) null,
	Title VARCHAR(75) null,
	Artist VARCHAR(75) null,
	ReleaseDate DATE null,
	ListPrice DOUBLE,
	Price DOUBLE,
	Version INTEGER
);