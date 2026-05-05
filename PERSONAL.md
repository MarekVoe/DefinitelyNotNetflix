### CHEATSHEET

- docker system df - vypíše využití disku
- docker system prune - odstraní všechny nepoužívané kontejnery, sítě, obrazy a build cache
- docker system prune -a - odstraní všechny nepoužívané kontejnery, sítě, obrazy a build cache včetně těch, které nejsouvisí s žádným kontejnerem
- docker system prune --volumes - odstraní všechny nepoužívané kontejnery, sítě, obrazy, build cache a objemy
  - docker system prune -a --volumes - odstraní všechny nepoužívané kontejnery, sítě, obrazy, build cache a objemy včetně těch, které nejsouvisí s žádným 
- docker compose up --build - sestaví a spustí kontejnery