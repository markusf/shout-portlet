create table Shout_Message (
	messageId LONG not null primary key,
	senderId LONG,
	scopeId LONG,
	publishDate DATE null
);

create table Shout_Shout (
	shoutId LONG not null primary key,
	senderId LONG,
	scopeId LONG,
	publishDate DATE null,
	message VARCHAR(255) null
);