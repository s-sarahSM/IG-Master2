# Sujet: La cartographie avec OpenStreetMap

Dans ce projet, nous allons créer et utiliser des services autour de la cartographie digitale. Pour commencer, on va à la base de ces services : la carte.

Comme vous avez pu le voir pendant le cours, il n'est pas simple de gérer la donnée OSM, c'est pour cela qu'on n'ira pas jusqu'a posseder une base OSM. À la place, nous alons utiliser un SVG du monde qui sera tuilé. J'ai déjà créer le service de tuilage, vous n'aurez qu'à appeler cette méthode.

La première partie consiste à créer son serveur de tuiles.

## Le serveur de tuiles

Pour le serveur, nous allons utiliser Spring Boot, la base de code est disponible dans osm-boot. Voici quelques étapes que vous pouvez suivre pour vous aider.

  1. Créez le `RestControlleur` et vos endpoints, typiquement le `/{z}/{x}/{y}.png` vu en cours. Hint: `TileWebService`.
  2. Créez votre `Service` qui va appeler `Svg.getTile(Tile t)`. Hint: `TileService`.
  3. Utilisez votre Service créé juste avant dans votre controlleur.
  4. Faites de la validation sur les tuiles dans votre Service. Hint: `IllegalArgumentException`, nombres négatifs, valeurs de x et y trop grands, z ne doit pas dépasser 24.
  5. Renvoyez des codes d'erreur 400 avec votre validation. Hint: `ControllerAdvice`, `ExceptionHandler`.
  6. Bonus: Utilisez un cache pour ne pas a avoir à générer les tuiles à chaque fois.
  7. Démarrez votre serveur de tuiles. Hint: Il écoutera sur le port 8080, <http://127.0.0.1:8080/0/0/0.png> devrait fonctionner.

Maintenant vous avez toutes les fonctionnalités de base d'un serveur de tuiles. Maintenant il faut pouvoir l'afficher, pour cela il faut page web qui pourra afficher votre carte.

## Afficher une carte

Pour cela, nous allons utiliser une librairie nommé [Mapbox GL JS](https://docs.mapbox.com/mapbox-gl-js/api/), il y a d'autres alternatives comme [Leaflet](https://leafletjs.com/).

  1. Ajoutez une source raster à votre carte. Hint: [exemple](https://docs.mapbox.com/mapbox-gl-js/example/map-tiles/), `tiles: ["http://127.0.0.1:8080/{z}/{x}/{y}.png"]`, vous pouvez enlever les attributions pour le moment.
  2. Ouvrez votre index.html dans votre navigateur, voilà vos tuiles!

## Ajouter des points

Maintenant nous allons ajouter des points à la carte. Nous avons à disposition la liste des préféctures de France au format GeoJSON. Le but sera de renvoyer cette liste via notre API de tuiles.

  1. Créez un endpoint pour servire le GeoJSON. Hint: `TileWebService`.
  2. Ajoutez le code pour récuperer le GeoJSON des resources. Hint: Vous pouvez vous inspirer de `Svg` ou utilisez `@Value` de Spring, faites tout cela dans `TileService`.
  3. Utilisez votre Service dans votre Controlleur.
  4. Ajoutez une source `prefecture` à votre `map`. Hint: [example](https://docs.mapbox.com/mapbox-gl-js/example/multiple-geometries/), l'url pour `data` sera celui de votre endpoint.
  5. Appliquez un layer de type [`circle`](https://docs.mapbox.com/mapbox-gl-js/style-spec/#layers-circle) qui décrit le style de votre point.
  6. Bonus: Créez une persistence pour vos points avec une base de données pour les récuperer. Hint: Utilisez PostgreSQL avec l'extension PostGIS, il y a un type `Geometry` spécial, vous avez le choix entre Hibernate et JDBCTemplate.
  7. Bonus: Vous devez renvoyer un GeoJSON, vous avez plusieurs solutions, soit récuperer du GeoJSON via [PostgreSQL/PostGIS](https://postgis.net/docs/ST_AsGeoJSON.html), soit utiliser une [librairie GeoJSON](https://github.com/ngageoint/simple-features-geojson-java)

## Ajout d'une source de tuiles vectorielles

C'est la partie placement de produit, vous avez déjà une carte, pas très fournie... Maintenant on va voir une vraie carte avec de la donnée beaucoup plus précise que le SVG.

  1. Créez vous un compte sur le [**Jawg**Lab](https://jawg.io/lab). Hint: visitez aussi le [site web](https://jawg.io) pour voir ce qu'on fait, il y a des démos.
  2. Allez dans la section Gestion des Styles, vous pouvez un créer un ou en prendre un par défaut. Hint: Essayez `jawg-terrain` avec le bouton utiliser.
  3. Replacez votre style raster par celui-ci. Hint: Le lient est dans l'onglet MapboxGL.
  4. Voilà, vous avez votre carte avec un magnifique style ;)
  5. Bonus: Modifiez le style récupéré avec le lab ou à la main pour créer votre plus belle carte.