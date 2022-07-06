create table if not exists student(
	id bigserial not null primary key,
	full_name varchar not null,
	phone varchar not null unique
);

create table if not exists course(
	id bigserial not null primary key,
	"name" varchar not null,
	price varchar,
	duration varchar
);
create table if not exists teacher(
	id bigserial not null primary key,
	full_name varchar not null,
	phone varchar(100) not null unique,
	salary varchar
);

    create table if not exists status(
	id bigserial not null primary key,
	"name" varchar not null,
	description varchar
);

create table if not exists room(
	id bigserial not null primary key,
	"name" varchar not null,
	capacity integer
);

create table if not exists day(
	id bigserial not null primary key,
	"name" varchar not null
);

create table if not exists time_table(
	id bigserial not null primary key,
	day_id bigserial ,
	foreign key (day_id) references day(id)
);

create table if not exists payment(
	id bigserial not null primary key,
	pay_type_id bigserial  ,
	sum varchar,
	description varchar,
	student_id bigserial,
	created_date timestamp default current_timestamp

);

create table if not exists "group"(
	id bigserial not null primary key,
	"name" varchar,
	description varchar,
	course_id bigserial,
	teacher_id bigserial,
	room_id bigserial,
	start_date timestamp,
	end_date timestamp,
	status_id bigserial

);

create table if not exists group_student(
   group_id bigserial not null,
   student_id bigserial not null
);

create table if not exists pay_type(
   id bigserial not null,
   "name" varchar not null
);

create table if not exists group_time_table(
time_table_id bigserial not null ,
group_id bigserial not null
);

create table if not exists role(
	id bigserial not null primary key,
	"name" varchar not null
	);

create table if not exists "user"(
	id bigserial not null primary key,
	username varchar not null,
	password integer,
	enabled boolean default true,
	account_non_expired boolean default true,
	account_non_locked boolean default  true,
	credentials_non_expired boolean default  true,
	full_name varchar

	);




create table if not exists user_roles(
user_id bigserial,
roles_id bigserial,
foreign key (user_id) references "user"(id),
foreign key (roles_id) references role(id)
)

create table if not exists role_permission_enum_set(
role_id bigserial,
permission_enum_set varchar,
foreign key (role_id) references role(id)
)