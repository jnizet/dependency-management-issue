# Dependency selection issue

This project illustrates a weird dependency selection issue when using the Spring dependency management
plugin and importing the spring cloud dependencies BOM.

It has two projects:

 - core, which is a java library with guava:29.0-jre in its **api** dependencies (thus making guava available
   to projects using core)
 - app, which has a dependency on the core project, and should thus be able to use guava:29.0-jre,
   uses the dependency management plugin, and uses it to import the spring-cloud-dependencies BOM
 
The issue I faced with this simple setup is that instead of selecting guava:29.0-jre for the app project, 
gradle selects guava:29.0-android. I can't explain why.

 - removing the spring-cloud-dependencies BOM import solves the issue (this can be seen in the `without-spring-cloud`
branch).
 - adding an explicit implementation dependency on guava:29.0-jre in the app project solves the issue (this can be 
seen in the `with-repeated-dependency` branch)
 - using the standard gradle support for BOM imports solves the issue (this can be seen in the 
 `without-dependency-management-plugin` branch).
