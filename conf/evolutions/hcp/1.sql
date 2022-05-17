# --- !Ups

CREATE TABLE providers(
  id TEXT NOT NULL PRIMARY KEY,
  name TEXT NOT NULL,
  specialization TEXT NOT NULL,
  address TEXT NOT NULL,
  phone TEXT NOT NULL,
  created_at timestamp default current_timestamp
);

INSERT INTO providers(id, name, specialization, address, phone)
	VALUES ('75e8bace-063c-4f15-8da2-464f366e4a78',
            'Bailey, Tanya J, MD',
            'Pediatrics',
            'Maple Grove, MN 55369',
            '(763) 559-2861');

INSERT INTO providers(id, name, specialization, address, phone)
	VALUES ('75e8bace-063c-4f15-8da2-464f366e4a77',
            'Meier, Diane M, MD',
            'Family Practice',
            'Maple Grove, MN 55368',
            '(763) 559-2862');

INSERT INTO providers(id, name, specialization, address, phone)
	VALUES ('75e8bace-063c-4f15-8da2-464f366e4a76',
            'Swan, Thomas T, MD',
            'Urgent Care Medicine, Family Practice',
            'Maple Grove, MN 55367',
            '(763) 559-2863');

# --- !Downs

drop table providers;
