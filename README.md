# Projekt Fordítása és Futtatása

## Előfeltételek

- Java 11 vagy újabb verziója telepítve van a rendszeren.
- Maven telepítve van a rendszeren.
- Docker telepítve van a rendszeren.

## Projekt Fordítása

1. Nyissa meg a terminált vagy parancssort, és navigáljon a projekt gyökérkönyvtárába.
2. Futtassa a következő parancsot a projekt fordításához:

```bash
mvn clean install
```

Ez a parancs letölti a projekt függőségeit, lefordítja a forráskódot, létrehoz egy JAR fájlt a `target` könyvtárban, és lefuttatja a teszteket.

## Docker Image Létrehozása

1. Futtassa a következő parancsot a Docker image létrehozásához:

```bash
docker build -t pontejavabackendtask .
```

Ez a parancs létrehoz egy Docker image-t a `pontejavabackendtask` névvel.

## Docker Container Futtatása

1. Futtassa a következő parancsot a Docker container indításához:

```bash
docker run -p 8080:8080 pontejavabackendtask
```

Ez a parancs elindítja a Docker container-t, és a host gép 8080-as portját összekapcsolja a container 8080-as portjával.

Az alkalmazás elérhető lesz a `http://localhost:8080` címen.

## Hibaelhárítás

Ha problémába ütközik a projekt fordítása, a Docker image létrehozása vagy a Docker container futtatása során, ellenőrizze a terminálban megjelenő hibaüzeneteket. Ezek az üzenetek gyakran hasznos információkat tartalmaznak a probléma okáról és arról, hogyan lehet azt megoldani.