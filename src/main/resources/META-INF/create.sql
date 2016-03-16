/*
CREATE TABLE THEATERS ("ID" INTEGER not null primary key, "CAPACITY" INTEGER not null)
CREATE TABLE MOVIES("ID" INTEGER not null primary key, "NAME" VARCHAR(50) not null, "ACTORS" VARCHAR(200) not null)
CREATE TABLE TIMESLOTS("ID" INTEGER not null primary key, "START_TIME" VARCHAR(5) not null, "END_TIME" VARCHAR(5) not null)
CREATE TABLE SHOW_TIMINGS("ID" INTEGER not null primary key, "DAY" INTEGER not null, "THEATER_ID" INTEGER not null, "MOVIE_ID" INTEGER not null, "TIMESLOT_ID" INTEGER not null)
CREATE TABLE SALES("ID" INTEGER not null primary key, "AMOUNT" FLOAT not null)
CREATE TABLE POINTS("ID" INTEGER not null primary key, "POINTS" INTEGER not null)
ALTER TABLE SHOW_TIMINGS ADD CONSTRAINT SHOW_THEATER_FK FOREIGN KEY ("THEATER_ID") REFERENCES THEATERS ("ID")
ALTER TABLE SHOW_TIMINGS ADD CONSTRAINT SHOW_MOVIE_FK FOREIGN KEY ("MOVIE_ID") REFERENCES MOVIES ("ID")
ALTER TABLE SHOW_TIMINGS ADD CONSTRAINT TIMESLOT_FK FOREIGN KEY ("TIMESLOT_ID") REFERENCES TIMESLOTS ("ID")
ALTER TABLE SALES ADD CONSTRAINT SHOW_TIMING_ID_FK FOREIGN KEY ("ID") REFERENCES SHOW_TIMINGS ("ID")
*/

CREATE TABLE PUBLISHER ("ID" INTEGER PRIMARY KEY, "NAME" VARCHAR(50) NOT NULL )
CREATE TABLE AUTHOR ("ID" INTEGER PRIMARY KEY, "FIRST_NAME" VARCHAR(30) NOT NULL, "LAST_NAME" VARCHAR(30) NOT NULL)
CREATE TABLE BOOKS ("ID" INTEGER PRIMARY KEY, "BOOK_NAME" VARCHAR(50) NOT NULL UNIQUE, "PUBLISHER_ID" INTEGER NOT NULL )

ALTER TABLE BOOKS ADD CONSTRAINT BOOK_PUBLISHER_ID FOREIGN KEY("PUBLISHER_ID") REFERENCES PUBLISHER ("ID")