DELETE FROM showdown.user_role;
DELETE FROM showdown.user;
DELETE FROM showdown.dvd_episodes;
DELETE FROM showdown.dvd;
DELETE FROM showdown.episode;
DELETE FROM showdown.show;

INSERT INTO showdown.user (email, password, nickname) VALUES
  ('admin', 'admin', 'Admin'),
  ('bzoller@gmail.com', 'fan', 'Ben')
;

INSERT INTO showdown.user_role (email, role) VALUES
  ('admin', 'admin'),
  ('bzoller@gmail.com', 'fan')
;

INSERT INTO showdown.show (show_title, show_description, show_image,
  start_year, end_year) VALUES ('Kings',
  'Kings is loosely based on the Biblical story of King David, but set in a kingdom that culturally and technologically resembles the present-day United States.',
  'kings.jpg', 2009, 2009);
INSERT INTO showdown.episode (show_id, season, episode, ep_title,
  ep_description, ep_image, airdate, hulu_embed) VALUES
  (LAST_INSERT_ID(), 1, 1, 'Goliath (Part 1)',
  'King Silas Benjamin (Ian McShane) confronts escalating tensions with a neighboring country in the premiere episode of this drama set in a modern-day monarchy. Meanwhile, a young soldier (Christopher Egan) inspires the nation after a bold rescue mission in which he unknowingly retrieved the king\'s son (Sebastian Stan) from an enemy camp.',
  'kings101.jpg', '2009-03-15', 'YA_Gcx7Qq2bdHJIMcVVwgQ'
  ),
  (LAST_INSERT_ID(), 1, 2, 'Goliath (Part 2)',
  'David goes to the frontlines of the renewed conflict to see his wounded brother. In doing so he reveals the truth of the Goliath encounter to him before he dies. Filled with anguish he crosses no man\'s land to plead for peace which is ultimately successful. Gath agrees to discuss a possible treaty with Gilboa.',
  'kings102.jpg', '2009-03-15', 'YA_Gcx7Qq2bdHJIMcVVwgQ'
  ),
  (LAST_INSERT_ID(), 1, 3, 'Prosperity',
  'Silas and Abner plot against David, whose absence from a treaty signing with Gath prompts concerns from Gath\'s leader. Meanwhile, William uses his power over the treasury to undermine Silas, and Jack goes on a shopping spree to spite his parents.',
  'kings103.jpg', '2009-03-22', 'QB2ubwaG9mODdzGAgHYyHA'
  ),
  (LAST_INSERT_ID(), 1, 4, 'First Night',
  'Silas ducks out of an event to be with his ailing illegitimate son. Elsewhere, Jack takes David out for a night on the town in hopes of tarnishing his image, and Reverend Samuels continues to clash with Silas.',
  'kings104.jpg', '2009-03-29', 'XgE1Q8lwRczD2evnEbf9Pg'
  ),
  (LAST_INSERT_ID(), 1, 5, 'Insurrection',
  'David\'s loyalties are tested after Silas leverages Port Prosperity during negotiations with Gath. Elsewhere, Michelle takes action when Gilboa\'s citizens rebel against Silas\' decision, and William tries to persuade Jack to help him overthrow his father.',
  'kings105.jpg', '2009-04-05', 'LnQ853clQxetgegasye42g'
  ),
  (LAST_INSERT_ID(), 1, 6, 'Judgement Day',
  'Silas presides over 10 cases during an annual tradition called Judgment Day. The event drives a wedge between David and Michelle, who compete against each other for the 10th case spot. Elsewhere, the king\'s nephew (Macaulay Culkin) returns from exile, and Jack and Katrina grow closer during their quest for power.',
  'kings106.jpg', '2009-04-18', 'N0tNOqGVqFzsU69H_TDNaA'
  ),
  (LAST_INSERT_ID(), 1, 7, 'Brotherhood',
  'Jack and David go to Gath to shore up the peace treaty, which is threatened by Gath\'s dangerous request. Elsewhere, Michelle encounters problems stemming from her health-care bill, and Silas takes steps to prevent a plague from ravaging the city, and end the plague that exists in his own house.',
  'kings107.jpg', '2009-06-13', 'GhHezqZb1e_vVo3QpFAKwQ'
  ),
  (LAST_INSERT_ID(), 1, 8, 'The Sabbath Queen',
  'King Silas\' birthday celebration is interrupted by a citywide blackout that puts the royal family in danger. The blackout gives Michelle and David a chance to be alone, and provides Jack with an opportunity to engage in his secret double life without being noticed. Meanwhile, a decision from Silas\' past catches up with him and threatens his future.',
  'kings108.jpg', '2009-06-20', 'CUaAkGeIwrI9oUE3qXXRZg'
  ),
  (LAST_INSERT_ID(), 1, 9, 'Pilgrimage',
  'King Silas goes on a pilgrimage and takes a surprised David with him. While out in the country, David is introduced to the king’s hidden life outside the palace walls. Meanwhile, Michelle and Jack’s respective secret love lives are under the threat of being exposed, forcing Queen Rose to take protective action.',
  'kings109.jpg', '2009-06-27', 'N-_lKQ2AnkFUGytZJslVmQ'
  ),
  (LAST_INSERT_ID(), 1, 10, 'Chapter One',
  'King Silas sends David on a quest to recover a national treasure, the Charter of Gilboa. While on the mission, David discovers shocking information about his father’s death. Meanwhile, Jack’s engagement to Katrina brings grief from Queen Rose and generosity from Silas.',
  'kings110.jpg', '2009-07-04', 't9zRik3k5s0VbmO3S-Ww_A'
  ),
  (LAST_INSERT_ID(), 1, 11, 'Javelin',
  'David is arrested for treason and Silas puts the trial in Jack’s hands. Meanwhile, an unexpected medical condition pulls Michelle away from David’s trial and brings her closer to Rose.',
  'kings111.jpg', '2009-07-11', '4ZaatDYoHlvC_W4V96pY0g'
  ),
  (LAST_INSERT_ID(), 1, 12, 'The New King (Part One)',
  'After imprisoning Jack and David for treason, Silas continues with his plan to hand over Port Prosperity to long-time enemy Gath. Meanwhile, Michelle seeks a way to keep David alive.',
  'kings112.jpg', '2009-07-18', '8WXI66XkX-kQjQ9M2uoeyAs'
  ),
  (LAST_INSERT_ID(), 1, 13, 'The New King (Part Two)',
  'Jack and William make plans for Jack to take his father\'s place as King of Gilboa. To everyone\'s surprise, Silas is alive and David escapes Shiloh to warn Silas about the chaos to come.',
  'kings113.jpg', '2009-07-25', 'xgxYzTCNBpTrawI8sbb4cw'
  )
;
INSERT INTO showdown.dvd (dvd_title, dvd_description, dvd_image, price) VALUES ('Kings: The Complete Series',
  'David Shepherd (Christopher Egan) becomes a national hero when he crosses enemy lines to rescue the king\'s son (Sebastian Stan) during the long-running war against Gath. But he finds that the power struggles in the royal court are just as dangerous as those on the battlefield. A modern take on the story of David and Goliath, the series traces David\'s rise to power after he wins the favor of King Silas (Ian McShane) of Gilboa.',
  'kings.jpg', 42.49);
INSERT INTO showdown.dvd_episodes (dvd_id, episode_id)
    SELECT dvd_id, episode_id FROM showdown.episode
    JOIN showdown.show ON showdown.episode.show_id = showdown.show.show_id
    JOIN showdown.dvd ON showdown.dvd.dvd_title = 'Kings: The Complete Series'
    WHERE show_title = 'Kings';


INSERT INTO showdown.show (show_title, show_description, show_image,
  start_year, end_year) VALUES ('The Wire',
  'The Wire is an American television drama series set in Baltimore, Maryland. Each season of The Wire focuses on a different facet of the city of Baltimore. They are, in order: the drug trade, the port, the city government and bureaucracy, the school system, and the print news media.',
  'the_wire.jpg', 2002, 2008);

INSERT INTO showdown.show (show_title, show_description, show_image,
  start_year, end_year) VALUES ('It\'s Always Sunny in Philadelphia',
  'The series follows the exploits of "The Gang", a group of self-centered, misanthropic friends who run Paddy\'s Pub, a relatively unsuccessful Irish bar in South Philadelphia.',
  'sunny.jpg', 2005, 2009);

INSERT INTO showdown.show (show_title, show_description, show_image,
  start_year, end_year) VALUES ('Deadwood',
  'Set in the 1870s in Deadwood, South Dakota, the show is set before and after the area\'s annexation by the Dakota Territory. The series charts Deadwood\'s growth from camp to town, incorporating themes ranging from the formation of communities to western capitalism.',
  'deadwood.jpg', 2004, 2006);
INSERT INTO showdown.episode (show_id, season, episode, ep_title,
  ep_description, ep_image, airdate) VALUES
  (LAST_INSERT_ID(), 1, 1, 'Deadwood',
  'After executing a last act of justice as a Montana marshal, Seth Bullock relocates to a gold-mining camp known as Deadwood, where he and partner Sol Star look to start a hardware business. Saloon owner Al Swearengen contends with a bungled robbery turned mass murder that threatens to incite mob violence throughout Deadwood. Hickock and his companions arrive in Deadwood. The people of Deadwood go off to hunt down the Native Americans who butchered a family of white people.',
  'deadwood101.jpg', '2004-03-21'
  ),
  (LAST_INSERT_ID(), 1, 2, 'Deep Water',
  'As suspicions arise that "road agents" may have been the true perpetrators of the massacre as opposed to Sioux scouts, Swearengen takes a special interest in the health of its sole survivor, a young girl ministered to by the unlikely team of Doc Cochran and Calamity Jane. Brom Garret suspects his newly acquired gold claim may not be all it was advertised.',
  'deadwood102.jpg', '2004-03-28'
  ),
  (LAST_INSERT_ID(), 1, 3, 'Reconnoitering the Rim',
  'Competition arrives for Swearengen in the form of the Bella Union, a new gambling outfit from Chicago operated by savvy Cy Tolliver, Madame Joanie Stubbs and gaming guru Eddie Sawyer. Hickok puts up precious collateral in a poker game with McCall, and a threat from Brom Garret regarding his gold claim invites harsh consequences. The relationship between Bullock and Swearengen continues to worsen over the latters suspicions of Bullock\'s and Hickok\'s intentions.',
  'deadwood103.jpg', '2004-04-04'
  ),
  (LAST_INSERT_ID(), 1, 4, 'Here Was a Man',
  'Swearengen directs Farnum to buy back the Garret claim after Dority discovers some startling new information; Alma Garret prevails on Calamity Jane and Hickok for help regarding her late husband\'s suspicious death. Hickok commissions Bullock in his stead as McCall\'s growing anger toward Hickok leads to a tragic encounter.',
  'deadwood104.jpg', '2004-04-11'
  ),
  (LAST_INSERT_ID(), 1, 5, 'The Trial of Jack McCall',
  'Swearengen transforms the Gem to a courtroom as Deadwood is forced to make its own laws to try a cowardly murderer. With Jane off on a bender, Trixie is enlisted by Swearengen to help Alma with the Metz child and to keep her pliable to his purposes for getting back the Garret claim.',
  'deadwood105.jpg', '2004-04-18'
  ),
  (LAST_INSERT_ID(), 1, 6, 'Plague',
  'Bullock encounters native resistance in his quest to bring a murderer to justice. Swearengen presses a resentful Farnum to keep tabs on Alma and Trixie as the camp fathers pool their resources to dispatch riders after precious vaccine and build a sick tent as the plague arrives in Deadwood. Cochran turns to a distressed Jane for help in the coming days.',
  'deadwood106.jpg', '2004-04-25'
  ),
  (LAST_INSERT_ID(), 1, 7, 'Bullock Returns to the Camp',
  'After tracking down McCall, Bullock returns to Deadwood a changed man - and a marked one - while Utter pays final respects to a fallen friend. Trixie feels uneasy about her charge, which prompts a violent response from Swearengen. Cy Tolliver is shocked, and displeased, to see a face from the past return to his saloon.',
  'deadwood107.jpg', '2004-05-02'
  ),
  (LAST_INSERT_ID(), 1, 8, 'Suffer the Little Children',
  'Deadwood breathes easier when riders arrive with precious vaccine - and word of a possible treaty with the Sioux. Awaiting Trixie\'s return, a pragmatic Swearengen resists counsel from a bloody-minded Farnum. Tolliver teaches a cruel lesson to two would-be thieves; and to his madame.',
  'deadwood108.jpg', '2004-05-09'
  ),
  (LAST_INSERT_ID(), 1, 9, 'No Other Sons or Daughters',
  'With annexation looming, Swearengen calls a meeting to set up an informal government. Bullock and Alma compare notes on Ellsworth, and each other. Joanie searches for new options in Deadwood as Jane heads out of town to find hers. The health of the camp\'s Reverend continues to worsen, a plight that begins to weigh heavy on the mind of Doctor Cochran.',
  'deadwood109.jpg', '2004-05-16'
  ),
  (LAST_INSERT_ID(), 1, 10, 'Mister Wu',
  'An opium theft leaves Swearengen trying to find common language with his supplier and the boss of the Deadwood Chinese population, Mr. Wu, as well as navigating tricky waters to deal with the mess. A letter from a Yankton magistrate infuriates Swearengen, but finds the solution may well lie with the letter\'s deliverer. Joanie finds backing for her brothel from a friend.',
  'deadwood110.jpg', '2004-05-23'
  ),
  (LAST_INSERT_ID(), 1, 11, 'Jewel\'s Boot Is Made for Walking',
  'Alma\'s father, Otis Russell, arrives from New York to "help" with her claim but soon begins to manipulate his daughter. Swearengen strikes a bargain with Adams to rid him of some legal baggage. Trixie and Sol have a private encounter at the hardware store, much to the ire of Swearengen as Bullock expresses his distaste at the settlement\'s new sheriff.',
  'deadwood111.jpg', '2004-06-06'
  ),
  (LAST_INSERT_ID(), 1, 12, 'Sold Under Sin',
  'The U.S. Army under General Crook, a.k.a. "Custer\'s avengers," rolls into Deadwood, prompting a parade - and business solicitations from Farnum and Tolliver. Swearengen deals with a problem and gains a new ally. Bullock confronts Otis Russell over his intentions as his relationship with Alma deepens.',
  'deadwood112.jpg', '2004-06-13'
  ),
  (LAST_INSERT_ID(), 2, 1, 'A Lie Agreed Upon: Part 1',
  'Anxious about the camp\'s future, Swearengen calls out Bullock over the Sheriff\'s relationship with Alma; the resulting confrontation turns inadvertently public - and violent. Bullock\'s wife and step son arrive as do Joanie\'s new business partners.',
  'deadwood201.jpg', '2005-03-06'
  )
;
INSERT INTO showdown.dvd (dvd_title, dvd_description, dvd_image, price) VALUES ('Deadwood: The Complete Series',
  'It\'s 1876, the height of the gold strike, and rebels and outlaws are drawn to Deadwood, a South Dakota town where everyone, including ex-marshall Seth Bullock (Timothy Olyphant) and infamous Wild Bill Hickok (Keith Carradine), is out to make a name for themselves at whatever cost. Ian McShane (Sexy Beast) co-stars as foul-mouthed saloon owner Al Swearengen in HBO\'s dramatic Western series.',
  'deadwood.jpg', 97.49);
INSERT INTO showdown.dvd_episodes (dvd_id, episode_id)
    SELECT dvd_id, episode_id FROM showdown.episode
    JOIN showdown.show ON showdown.episode.show_id = showdown.show.show_id
    JOIN showdown.dvd ON showdown.dvd.dvd_title = 'Deadwood: The Complete Series'
    WHERE show_title = 'Deadwood';
INSERT INTO showdown.dvd (dvd_title, dvd_description, dvd_image, price) VALUES ('Deadwood: Season One',
  'It\'s 1876, the height of the gold strike, and rebels and outlaws are drawn to Deadwood, a South Dakota town where everyone, including ex-marshall Seth Bullock (Timothy Olyphant) and infamous Wild Bill Hickok (Keith Carradine), is out to make a name for themselves at whatever cost. Ian McShane (Sexy Beast) co-stars as foul-mouthed saloon owner Al Swearengen in this first season of HBO\'s dramatic Western series.',
  'deadwood1.jpg', 32.49);
INSERT INTO showdown.dvd_episodes (dvd_id, episode_id)
    SELECT dvd_id, episode_id FROM showdown.episode
    JOIN showdown.show ON showdown.episode.show_id = showdown.show.show_id
    JOIN showdown.dvd ON showdown.dvd.dvd_title = 'Deadwood: Season One'
    WHERE show_title = 'Deadwood' AND season = 1;
INSERT INTO showdown.dvd (dvd_title, dvd_description, dvd_image, price) VALUES ('Deadwood: Season Two',
  'In the Black Hills of South Dakota, the illegal camp of Deadwood is under the reign of new sheriff Seth Bullock (Timothy Olyphant) in the second season of this intriguing HBO series that breathes life into the Wild West. But that doesn\'t mean law and order has finally come to an essentially lawless town; everyone\'s still out for himself during the massive gold strike, and money and power are still valued above all else.',
  'deadwood2.jpg', 32.49);
INSERT INTO showdown.dvd_episodes (dvd_id, episode_id)
    SELECT dvd_id, episode_id FROM showdown.episode
    JOIN showdown.show ON showdown.episode.show_id = showdown.show.show_id
    JOIN showdown.dvd ON showdown.dvd.dvd_title = 'Deadwood: Season Two'
    WHERE show_title = 'Deadwood' AND season = 2;