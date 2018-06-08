INSERT INTO categories(name) VALUES ('Geeky');
INSERT INTO categories(name) VALUES ('Knock Knock');
INSERT INTO categories(name) VALUES ('Science');

INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Geeky'), 'Q: How many programmers does it take to screw in a light bulb?

A: None. It is a hardware problem.');

INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Geeky'), 'When a programmer is told to "go to hell", he finds the worst part of that statement is the "go to".');

INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Geeky'), 'What''s the best thing thing about UDP jokes?

I don''t care if you get them.');


INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Science'), 'Schrodinger''s cat walks into a bar. And doesn''t.');

INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Science'), 'An optimist sees a glass half full. A pessimist sees it half empty. An engineer sees it twice as large as it needs to be.');

INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Geeky'), 'What''s the best part about TCP jokes? I get to keep telling them until you get them.');


INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Geeky'), 'Q: What is hardware? A: It is what you hit when your software does not work.');

INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Science'), 'Q: What is the name of the first electricity detective? A: Sherlock Ohms');

INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Science'), '
Heisenberg is pulled over. "Do you have any idea how fast you were going?" asks the policeman. H: "No. But, I know where I am."');

INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Knock Knock'), 'Knock Knock Who''s There? Art Art Who? R2-D2');

INSERT INTO jokes (category_id, content) VALUES ((SELECT id FROM categories WHERE name = 'Geeky'), 'To understand what recursion is, you must first understand recursion.');






