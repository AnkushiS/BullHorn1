--------------------------------------------------------
--  File created - Friday-August-28-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "TESTDB"."USERS" 
   (	"USER_ID" NUMBER, 
	"USER_NAME" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"USER_MOTTO" VARCHAR2(100 BYTE), 
	"JOINDATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MICROBLOG
--------------------------------------------------------

  CREATE TABLE "TESTDB"."MICROBLOG" 
   (	"BLOG_ID" NUMBER, 
	"USER_TEXT" VARCHAR2(200 BYTE), 
	"USER_NAME" VARCHAR2(20 BYTE), 
	"DATEIN" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into TESTDB.USERS
SET DEFINE OFF;
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE) values (42,'bull_horn','789','Hello Bull horn ',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE) values (43,'set_register','123','Here you go ',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE) values (44,'col_new','147','when will this work',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE) values (48,'rathor','pwd','Sunny is the best',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE) values (59,'pure_leaf','123','???',to_date('28-AUG-15','DD-MON-RR'));
REM INSERTING into TESTDB.MICROBLOG
SET DEFINE OFF;
Insert into TESTDB.MICROBLOG (BLOG_ID,USER_TEXT,USER_NAME,DATEIN) values (21,'hello bullhorn','pure_leaf',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.MICROBLOG (BLOG_ID,USER_TEXT,USER_NAME,DATEIN) values (22,'hello there','pure_leaf',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.MICROBLOG (BLOG_ID,USER_TEXT,USER_NAME,DATEIN) values (23,null,'pure_leaf',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.MICROBLOG (BLOG_ID,USER_TEXT,USER_NAME,DATEIN) values (1,'new blog ','IamNew',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.MICROBLOG (BLOG_ID,USER_TEXT,USER_NAME,DATEIN) values (2,'check values','IamNew',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.MICROBLOG (BLOG_ID,USER_TEXT,USER_NAME,DATEIN) values (3,'check check','new_user',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.MICROBLOG (BLOG_ID,USER_TEXT,USER_NAME,DATEIN) values (4,'new post','IamNew',to_date('28-AUG-15','DD-MON-RR'));
Insert into TESTDB.MICROBLOG (BLOG_ID,USER_TEXT,USER_NAME,DATEIN) values (5,'new blog ','IamNew',to_date('28-AUG-15','DD-MON-RR'));
--------------------------------------------------------
--  DDL for Index SYS_C007483
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTDB"."SYS_C007483" ON "TESTDB"."USERS" ("USER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007495
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTDB"."SYS_C007495" ON "TESTDB"."MICROBLOG" ("BLOG_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "TESTDB"."USERS" ADD PRIMARY KEY ("USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MICROBLOG
--------------------------------------------------------

  ALTER TABLE "TESTDB"."MICROBLOG" ADD PRIMARY KEY ("BLOG_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  DDL for Trigger USR_SEQ_TRIG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTDB"."USR_SEQ_TRIG" 
BEFORE INSERT ON users
for each row
declare
ab_id number;
begin 
  select usr_seq.nextval
  into ab_id
  from dual;
  :new.user_id :=ab_id;
end;
/
ALTER TRIGGER "TESTDB"."USR_SEQ_TRIG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger BLOG_ID_TRIG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTDB"."BLOG_ID_TRIG" 
BEFORE INSERT ON microblog
FOR EACH ROW
DECLARE
  new_id number;
BEGIN
  SELECT blog_id_seq.nextval
    INTO new_id
    FROM dual;
  :new.blog_ID := new_id;
END;
/
ALTER TRIGGER "TESTDB"."BLOG_ID_TRIG" ENABLE;
