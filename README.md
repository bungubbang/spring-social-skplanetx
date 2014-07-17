Spring Social Skplanetx
=======================
The Spring Social Skplanetx project is an extension to [Spring Social](http://www.springframework.org/spring-social) that enables integration with Skplanetx.

## Introduction
---
[Skplanetx](https://developers.skplanetx.com/) is [SK Planet](http://www.skplanet.com/) API develop service.

### How to get

The following Gradle dependency will add Spring Social Skplanetx to your project:

build.gradle

	compile "org.springframework.social:spring-social-skplanetx:{spring-social-skplanetx-version}"
	
Or in Maven:

pom.xml

	<dependency>
	  <groupId>org.springframework.social</groupId>
	  <artifactId>spring-social-skplanetx</artifactId>
	  <version>{spring-social-skplanetx-version}</version>
	</dependency>
	
As an extension to Spring Social, Spring Social Skplanetx depends on Spring Social. Spring Social’s core module will be transitively resolved from the Spring Social Skplanetx dependency. If you’ll be using Spring Social’s web module, you’ll need to add that dependency yourself. In Gradle:

build.gradle

	compile "org.springframework.social:spring-social-web:{spring-social-version}"
	
Or in Maven:

pom.xml

	<dependency>
		<groupId>org.springframework.social</groupId>
	  	<artifactId>spring-social-web</artifactId>
  		<version>{spring-social-version}</version>
	</dependency>
	
Note that Spring Social Skplanetx may release on a different schedule than Spring Social. Consequently, Spring Social’s version may differ from that of Spring Social Skplanetx.

Consult [Spring Social’s reference documentation](http://docs.spring.io/spring-social/docs/1.0.x/reference/html/overview.html#overview-howtoget) for more information on Spring Social dependencies.


## Configuring Skplanetx Connectivity
---
Spring Social’s `ConnectController` works with one or more provider-specific `ConnectionFactory` instances to exchange authorization details with the provider and to create connections. Spring Social Skplanetx provides `SkplanetxConnectionFactory`, a `ConnectionFactory` for creating connections with Skplanetx.

So that `ConnectController` can find `SkplanetxConnectionFactory`, it must be registered with a `ConnectionFactoryRegistry`. The following configuration class uses Spring Social’s Java configuration support to register a `ConnectionFactory` for Skplanetx:

	@Configuration
	public class SocialConfig implements SocialConfigurer {

    	@Override
	    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
    	    cfConfig.addConnectionFactory(new SkplanetxConnectionFactory(
        	    env.getProperty("skplanetx.clientId"),
            	env.getProperty("skplanetx.clientSecret"),
            	env.getProperty("skplanetx.appKey")));
	    }

    	...
	}

If we wanted to add support for connecting to other providers, we would simply register their connection factories here in the same way as `SkplanetxConnectionFactory`.

Because client IDs and secrets may be different across environments (e.g., test, production, etc) it is recommended that these values be externalized. As shown here, Spring’s `Environment` abstraction is provided as a parameter to `addConnectionFactories()` so that it can look up the application’s client ID and secret.

Refer to [Spring Social’s reference documentation](http://docs.spring.io/spring-social/docs/1.1.0.RELEASE/reference/htmlsingle/#connecting) for complete details on configuring `ConnectController` and its dependencies.

## Skplanet API Binding
---
> This version(1.0.0-RELEASE) only provides UserProfile and Melon API

Spring Social Skplanetx offers integration with Skplanetx's REST API with the `Skplanetx` interface and its implementation, `SkplanetxTemplate`.

To create an instance of `SkplanetxTemplate`, you may pass in your application’s OAuth 2 access token to the constructor:

	String accessToken = "..."; // The access token granted after OAuth authorization
	Skplanetx skplanetx = new SkplanetxTemplate(accessToken);
	
If you are using Spring Social’s [service provider framework](http://docs.spring.io/spring-social/docs/1.1.0.RELEASE/reference/htmlsingle/#connectFramework), you can get an instance of `Skplanetx` from a `Connection`. For example, the following snippet calls `getApi()` on a connection to retrieve a Skplanetx:

	Connection<Skplanetx> connection = connectionRepository.findPrimaryConnection(Skplanetx.class);
	if (connection != null) {
    	Skplanetx skplanetx = connection.getApi();

	    // ... use Skplanetx API binding
	}
	
Here, `ConnectionRepository` is being asked for the primary connection that the current user has with Skplanetx. If a connection to `Skplanetx` is found, it retrieves a Skplanetx instance that is configured with the connection details received when the connection was first established.

Once you have a `Skplanetx` instance, you can perform a several operations against Skplanetx’s API. The `Skplanetx` interface is defined as follows:

	public interface Skplanetx {

    	UserOperations getUser();

    	MelonOperations getMelon();
	}
	
Each method returns sub-APIs, partitioning the Skplanetx service API into divisions targeting specific facets of Skplanetx functionality. These sub-APIs are defined by interfaces described in [Skplanetx’s Sub-APIs](https://developers.skplanetx.com/apidoc/).
	
Table 1. Skplanetx’s Sub-APIs

Sub-API Interface | Description
----------------- | -----------
`UserOperations`  | Send and receive connection requests with other Skplanetx users.
`MelonOperations` | Retrieve melon data.

In addition to the Skplanetx-specific sub-APIs described in table [Skplanetx’s Sub-APIs](https://developers.skplanetx.com/apidoc/), `Skplanetx` also has a `restOperations()` method that returns a `RestOperation`s (e.g., `RestTemplate`). The `RestOperations` returned is instrumented to add an OAuth Authorization header for all requests it sends to Skplanetx.

What follows is a brief survey of common tasks you may perform with Skplanetx and its sub-APIs. For complete details on the Spring Social’s entire Skplanetx API binding, refer to the JavaDoc.

### Retrieving a user’s Skplanetx profile data

You can retrieve the authenticated user’s Facebook profile data using the Skplanetx#userOperations.getUserProfile() method:

	SkplanetxUserProfile profile = skplanetx.userOperations().getProfile();

The data returned in the SkplanetxUserProfile includes the user’s userId, userName, email.

### Getting a Melon Data

you can retrieve Melon data(chart, new releases song and albums).
Once you have a `MelonOperations` instance, you can perform a several operations against Melon’s API. The `MelonOperations` interface is defined as follows:

	public interface MelonOperations {
	
    	ChartOperation getChart();
	    NewReleasesOperation getNewReleases();
	}
	
And the `ChartOperation` interface is defined as follows:

	public interface ChartOperation {
    	Melon getRealTime(int page, int count);
	    Melon getTodayTopSongs(int page, int count);
	    Melon getTopAlbums(int page, int count);
	    Melon getTopGenres(int page, int count);
    	Melon getTopGenres(int page, int count, String genreId);
	    Melon getGenres();
	}
	
you can access Melon top100 lists by calling the `getTodayTopSongs(1, 100)` method from `ChartOperation`
	
And the `NewReleasesOperation` interface is defined as follows:


	public interface NewReleasesOperation {
	    Melon getAlbums(int page, int count);
    	Melon getAlbums(int page, int count, String genreId);
	    Melon getSongs(int page, int count);
    	Melon getSongs(int page, int count, String genreId);
	}
	

Also You can access the newest releases song by calling the `getSongs(1,100)` method from `NewReleasesOperation`


## TODO operation
---

11st, Tmap, hoppin, Tcloud, Tstore ...

if you are interested in this project, please contact my email <sungyong.jung@sk.com>