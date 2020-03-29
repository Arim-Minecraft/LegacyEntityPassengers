# LegacyEntityPassengers
A very simple project for getting entity passengers in multi-version Spigot plugins.

## Introduction

You may be developing a Spigot plugin with support for multiple versions. You also need to get the passengers on an entity. However, no matter which version of Spigot you compile against, you receive compile errors. In 1.8, 1.9, and  1.10, the method is `Entity#getPassenger()` whereas in later versions it is `Entity#getPassengers()`. Notice the last *s*.

This is a similar project to [LegacyItemStackConstructor](https://github.com/Arim-Minecraft/LegacyItemStackConstructor).

## The Solution

**1.** Add the following dependency to your pom.xml:
```xml
<dependency>
	<groupId>space.arim</groupId>
	<artifactId>legacyentitypassengers</artifactId>
	<version>0.1.0-SNAPSHOT</version>
	<scope>provided</scope>
</dependency>
```

**2.** Add the following repository:
```xml
<repository>
	<id>arim-repo</id>
	<url>https://dl.cloudsmith.io/public/anand-beh/arim-repo/maven/</url>
</repository>
```

**3.** Shade the dependency using maven-shade-plugin:
```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-shade-plugin</artifactId>
	<executions>
		<execution>
			<phase>package</phase>
			<goals>
				<goal>shade</goal>
			</goals>
			<configuration>
				<artifactSet>
					<includes>
						<include>space.arim:legacyentitypassengers</include>
					</includes>
				</artifactSet>
			</configuration>
		</execution>
	</executions>
</plugin>
```

**4.** Build against later versions of Spigot in your plugin, so you can use `Entity#getPassengers()` in your *up-to-date version code*.

**4.** Call the appropriate method in your *legacy code*:
```java
Entity entity;
List<Entity> passengers = LegacyEntityPassengers.invoke(entity);
```
You'll receive a runtime error if you invoke the method on a later server version. So be sure that in your flow control you're sure the server version will be <=1.10 when you call it.
