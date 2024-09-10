CREATE TABLE public.student (
	id varchar(255) NOT NULL,
	created_at timestamp(6) NULL,
	updated_at timestamp(6) NULL,
	birth_date timestamp(6) NULL,
	email varchar(50) NOT NULL,
	"name" varchar(255) NULL,
	phone varchar(255) NOT NULL,
	registration_date timestamp(6) NULL,
	diet_id varchar(255) NULL,
	CONSTRAINT student_pkey PRIMARY KEY (id),
	CONSTRAINT uk5s5e6lj1siq6ef1tm7p2g4uul UNIQUE (phone),
	CONSTRAINT uk98siqth3lmyrwu5mm8coojluc UNIQUE (diet_id),
	CONSTRAINT ukfe0i52si7ybu0wjedj6motiim UNIQUE (email)
);

CREATE TABLE public.diet (
	id varchar(255) NOT NULL,
	created_at timestamp(6) NULL,
	updated_at timestamp(6) NULL,
	description varchar(255) NULL,
	end_date timestamp(6) NULL,
	name varchar(255) NULL,
	start_date timestamp(6) NULL,
	student_id varchar(255) NULL,
	CONSTRAINT diet_pkey PRIMARY KEY (id),
	CONSTRAINT uk_diet_student_id UNIQUE (student_id),
	CONSTRAINT fk_diet_student_id FOREIGN KEY (student_id) REFERENCES public.student(id)
);

ALTER TABLE public.student
	ADD CONSTRAINT fkroqapge1h69e0mvvcubno4pij FOREIGN KEY (diet_id) REFERENCES public.diet(id);

CREATE TABLE public.body_measurement (
	id varchar(255) NOT NULL,
	created_at timestamp(6) NULL,
	updated_at timestamp(6) NULL,
	body_fat_percentage float8 NULL,
	chest_circumference float8 NULL,
	heigth float8 NULL,
	measurement_date timestamp(6) NULL,
	weight float8 NULL,
	student_id varchar(255) NULL,
	CONSTRAINT body_measurement_pkey PRIMARY KEY (id),
	CONSTRAINT fk5saivlx8jc140418dcelfu3f FOREIGN KEY (student_id) REFERENCES public.student(id)
);

CREATE TABLE public.exercise (
	id varchar(255) NOT NULL,
	created_at timestamp(6) NULL,
	updated_at timestamp(6) NULL,
	description varchar(255) NULL,
	"name" varchar(255) NULL,
	repetions int4 NULL,
	rest_time int4 NULL,
	"sets" int4 NULL,
	CONSTRAINT exercise_pkey PRIMARY KEY (id)
);

CREATE TABLE public.goal (
	id varchar(255) NOT NULL,
	created_at timestamp(6) NULL,
	updated_at timestamp(6) NULL,
	description varchar(255) NULL,
	end_date timestamp(6) NULL,
	progress float8 NULL,
	start_date timestamp(6) NOT NULL,
	status varchar(255) NULL,
	student_id varchar(255) NULL,
	CONSTRAINT goal_pkey PRIMARY KEY (id),
	CONSTRAINT goal_status_check CHECK (((status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'COMPLETED'::character varying, 'CANCELLED'::character varying])::text[]))),
	CONSTRAINT fksd3sr9cxjpr3ib3j4hrnc15xs FOREIGN KEY (student_id) REFERENCES public.student(id)
);

CREATE TABLE public.meal (
	id varchar(255) NOT NULL,
	created_at timestamp(6) NULL,
	updated_at timestamp(6) NULL,
	calories int4 NULL,
	carbs float8 NULL,
	fats float8 NULL,
	protein float8 NULL,
	CONSTRAINT meal_pkey PRIMARY KEY (id)
);

CREATE TABLE public.meal_diet (
	meal_id varchar(255) NOT NULL,
	diet_id varchar(255) NOT NULL,
	CONSTRAINT fkf48bo0q3cydofo3aoyvysg8pf FOREIGN KEY (diet_id) REFERENCES public.diet(id),
	CONSTRAINT fkp5dgxs44hi3e0qwl5ujlyy8yy FOREIGN KEY (meal_id) REFERENCES public.meal(id)
);

CREATE TABLE public.training (
	id varchar(255) NOT NULL,
	created_at timestamp(6) NULL,
	updated_at timestamp(6) NULL,
	description varchar(255) NULL,
	duration int4 NULL,
	"name" varchar(255) NULL,
	student_id varchar(255) NULL,
	CONSTRAINT training_pkey PRIMARY KEY (id),
	CONSTRAINT fkfxeyquv53kssy365o4poiv0gf FOREIGN KEY (student_id) REFERENCES public.student(id)
);

CREATE TABLE public.training_exercise (
	exercise_id varchar(255) NOT NULL,
	training_id varchar(255) NOT NULL,
	CONSTRAINT fkexg36anbxkjj0yqsj81u3x1f4 FOREIGN KEY (training_id) REFERENCES public.training(id),
	CONSTRAINT fkg35g3wkht1bhqxyan2cfrkvva FOREIGN KEY (exercise_id) REFERENCES public.exercise(id)
);
