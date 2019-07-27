create table if not exists `user` (
  id int primary key auto_increment,
  nickname varchar(255) unique,
  password_hash varchar(255)
)
