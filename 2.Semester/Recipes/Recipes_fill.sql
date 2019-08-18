INSERT INTO `Recipes`.`Recipe` (`name`, `description`, `rating`, `image`) VALUES ('Pandekager', 'Æg og mel piskes sammen. Heri piskes det varme smør, spædes med mælk og tilsmages salt, sukker og vanille. Bag pandekagerne lysebrune i smør på panden. Der bliver 8-12 pandekager alt efter pandens størrelse. 12 stk. med pande på 19 cm. i diameter. Server pandekagerne med, sukker og syltetøj, blød vanilleis eller flødeskum.', '4', '/Documents/Datamatiker/2.Semester/Recipes_images/pandekager.jpg');
INSERT INTO `Recipes`.`Recipe` (`name`, `description`, `rating`, `image`) VALUES ('Risengrød', 'Bring vand og ris i kog i en tykbundet gryde. Kog risene ved jævn varme og under omrøring i ca. 2 min. Tilsæt mælk og bring blandingen i kog. Kog grøden ved svag varme, stadig under omræring, i ca. 10 min. Læg låg på og kog i ca. 25 min. Rør ofte i grøden. Hvis grøden virker tynd så kog den i yderligere 5-10 min. Tilsæt salt og smag til. Bland sukker og kanel. Kom risengrøden i en varm skål. Server grøden med kanelsukker og smør.', '4', '/Documents/Datanatiker/2.Semester/Recipes_images/risengroed.jpg');
INSERT INTO `Recipes`.`Recipe` (`name`, `description`, `rating`, `image`) VALUES ('Kartoffelsuppe', 'Varm smør/olie op i en gryde og sauter løget heri i et par minutter. Tilsæt kartoffelstykker og hæld bouillon eller vand på til det lige netop dækker. Læg låg på gryden, bring den i kog og lad den koge i 15-20 minutter, til kaertoflerne er kogt helt møre. tag suppen af varmen og blend den glat og cremet med stavblender. sæt gryden tilbage på varmen, tilsæt fløde og varm suppen igennem. Smag til salt og pweber og server med stegte bacontern og friskhakket persille.', '2', '/Documents/Datamatiker/2.Semester/Recipes_images/kartoffelsuppe.jpg');

INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Æg');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Hvedemel');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Smør');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Mælk');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Salt');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Sukker');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Vanillesukker');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Vand');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Grødris');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Kanel');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Løg');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Kartofler');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Grønsagesbouillon');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Fløde');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Bacontern');
INSERT INTO `Recipes`.`Ingredients` (`name`) VALUES ('Persille');

INSERT INTO `Recipes`.`Recipe_has_ingredients`(`recipe_id`,`ingredients_id`,`units`,`scale`) VALUES 
(1,1,4,null),
(1,2,150,'gram'),
(1,3,25,'gram'),
(1,4,3,'dl'),
(1,5,1,'knsp.'),
(1,6,1,'spsk'),
(1,7,1,'tsk'),
(2,8,3,'dl'),
(2,9,180,'gram'),
(2,4,1,'liter'),
(2,5,0.25,'tsk'),
(2,6,4,'spsk'),
(2,10,2,'tsk'),
(2,3,50,'gram'),
(3,3,1,'spsk'),
(3,11,2,null),
(3,12,1,'kg'),
(3,13,1,'liter'),
(3,14,2.5,'dl'),
(3,5,null, null),
(3,15,null,null),
(3,16,null,null);

