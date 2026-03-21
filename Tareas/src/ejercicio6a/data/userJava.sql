
create user if not exists 'java'@'%' identified by 'himitsu';
GRANT SELECT, INSERT, UPDATE, DELETE ON `javaMarket`.* TO 'java'@'%';
