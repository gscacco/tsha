Touch Screen Hmi - Argo
====

Installing WWJ in local maven repository
----------------------------------------

*In this example we used WWJ 1.5.1*

To install World Wind Java into the local repository use the following steps

    1) mvn install:install-file -Dfile=worldwind.jar -DgroupId=gov.nasa -DartifactId=wwj -Dpackaging=jar -Dversion=1.5.1
    2) mvn install:install-file -Dfile=worldwindx.jar -DgroupId=gov.nasa -DartifactId=wwjx -Dpackaging=jar -Dversion=1.5.1
    3) mvn install:install-file -Dfile= jogl.jar -DgroupId=gov.nasa -DartifactId=jogl -Dpackaging=jar -Dversion=1.5.1
    4) mvn install:install-file -Dfile=vpf-symbols.jar -DgroupId=gov.nasa -DartifactId=jogl -Dpackaging=jar -Dversion=1.5.1
    5) mvn install:install-file -Dfile=gdal.jar -DgroupId=gov.nasa -DartifactId=gdal -Dpackaging=jar -Dversion=1.5.1
    6) mvn install:install-file  -Dfile=gluegen-rt-natives-linux-amd64.jar -DgroupId=gov.nasa -DartifactId=gluegen -Dpackaging=jar -Dversion=1.5.1

Finally add the dependencies to your pom.xml:

    <dependency>
        <groupId>gov.nasa</groupId>
        <artifactId>wwj</artifactId>
        <version>1.5.1</version>
    </dependency>
    <dependency>
        <groupId>gov.nasa</groupId>
        <artifactId>wwjx</artifactId>
        <version>1.5.1</version>
    </dependency>
    <dependency>
        <groupId>gov.nasa</groupId>
        <artifactId>jogl</artifactId>
        <version>1.5.1</version>
    </dependency>
    <dependency>
        <groupId>gov.nasa</groupId>
        <artifactId>vpf-symbols</artifactId>
        <version>1.5.1</version>
    </dependency>
    <dependency>
        <groupId>gov.nasa</groupId>
        <artifactId>gdal</artifactId>
        <version>1.5.1</version>
    </dependency>
    <dependency>
        <groupId>gov.nasa</groupId>
        <artifactId>gluegen</artifactId>
        <version>1.5.1</version>
    </dependency>