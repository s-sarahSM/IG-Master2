package io.github.joxit.osm.service;

import io.github.joxit.osm.model.Tile;
import mil.nga.sf.geojson.GeoJsonObject;

/**
 * Service pour retourner les tuiles.
 *
 * @author Jones Magloire @Joxit
 * @since 2019-11-03
 */
public class TileService {

  /**
   * Ici il faut prendre les coordonnées de la tuile et renvoyer la donnée PNG associée.
   * Vous pouvez y ajouter des fonctionnalités en plus pour améliorer les perfs.
   *
   * @param tile qu'il faut renvoyer
   *
   * @return le byte array au format png
   */
  public byte[] getTile(Tile tile) {
    return null;
  }

  /**
   * @return le contenu du fichier prefectures.geojson
   */
  public String getPrefectures() {
    return null;
  }

  /**
   * Il faudra créer votre DAO pour récuperer les données.
   * Utilisez ce que vous voulez pour faire le DAO.
   *
   * @return les éléments contenus dans la base de données
   */
  public GeoJsonObject getPOIs() {
    return null;
  }
}
