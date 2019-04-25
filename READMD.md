# Files from cscfodev

## Make sure pom.xml for bnpux war is like thie following

````
<plugin>
    <artifactId>maven-war-plugin</artifactId>
    <version>3.2.2</version>
    <configuration>
        <packagingExcludes>
            /js/angular.js,/js/angular-translate.js,/js/angular-sanitize.js,/js/angular-translate-loader-url.js,/js/angular-route.js,/js/FileSaver.js,/js/ocLazyLoad.js,/js/ui-grid-stable.js,/js/bootstrap.js,/js/ui-bootstrap-tpls-1.2.4.js,/js/ui-bootstrap-tpls-1.3.3.js,/js/angular-ui-router.js,%regex[WEB-INF/lib/(?!commonservices|commonservices).*.jar]
        </packagingExcludes>
        <attachClasses>true</attachClasses>
    </configuration>
</plugin>
````

## Build instructions

````
mvn versions:set -DnewVersion=12.2.0-SNAPSHOT

mvn versions:commit

mvn --projects :bnpux --also-make install -DskipTests
````


