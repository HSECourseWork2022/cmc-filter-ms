# Template Filter Application

Ready to kick-start Spring Boot application template filter with Dockerfile and docker-compose.yml
* Java: 17
* Spring Boot: 2.7.5
# What do you need to update?
1. Rename `TemplateFilterApplication` in `dev.hse.cmc` package to `{{ sourcename }}{{ filtername }}FilterApplication`
2. Under `src/main/java` rename `dev.hse.cmc` package to your preferred one
3. Change `artifactId` in pom from `template-filter-ms` to `{{ sourcename }}-{{ filtername }}-filter-ms`
4. Update `docker-compose.yml`
   1. Change application service name `template-filter` to `{{ sourcename }}-{{ filtername }}-filter`
   2. Change container name `template-filter-container` to `{{ sourcename }}-{{ filtername }}-filter-container`
   3. Change `FILTER_SOURCE` to your `sourcename`
   4. Change `FILTER_SUBTHEME` to your `subtheme`

```bash
./mvnw clean
./mvnw package -Dmaven.test.skip
docker compose up
```