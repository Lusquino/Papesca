file <- read_csv2("/Users/izandrometello/git/Papesca/test.csv")

data.table(file) %>% 
  select(id, Turnos = turnos, vitoria) %>% 
  group_by(Turnos) %>% 
  summarise(Jogos = n()) %>% 
  ggplot(aes(x =  Turnos, Jogos)) + 
  geom_bar(stat ="identity") + 
  scale_x_discrete(limits = 0:11)