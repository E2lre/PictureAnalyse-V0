Analyse des exif des images

Exemple d'appel :   http://localhost:8099/infoAnalyse?filePath=C:/Users/Eric/OneDrive/Images/Master/2023-02-Fevrier&fileName=2023-Fevrier-DCS_0867.NEF

Nombre d'expositions :  Exposure Sequence Number -

TODO 
* Balayser tous les fichiers d'un répertoire,
* récupérer des info données
* stocker dans des base
** sql pour le nom du fichier et sont répertoire
** nosql pour les Exif
* lire les données en base pour un ou plusieurs exif


Pour exécuter dans le répertoire racine
MVN clean install
MVN -DskipTests spring-boot:run


 
  http://localhost:8099/infoAnalyse?filePath=C:/Users/Eric/OneDrive/Images/Master/2023-02-Fevrier&fileName=2023-Fevrier-DCS_0867.NEF
 
 Valeur à récupérer : [Nikon Makernote] Exposure Sequence Number

C:/Users/Eric/OneDrive/Images/Master/2023-02-Fevrier/2023-Fevrier-DCS_0867.NEF

  http://localhost:8099/getNikonExposureSequenceNumber?filePath=C:/Users/Eric/OneDrive/Images/Master/2023-02-Fevrier&fileName=2023-Fevrier-DCS_0867.NEF