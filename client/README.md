# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import asu.edu.rule_miner.api.service.*;
import asu.edu.rule_miner.api.service.auth.*;
import asu.edu.rule_miner.api.service.model.*;
import asu.edu.rule_miner.api.api.DefaultApi;

import java.io.File;
import java.util.*;

public class DefaultApiExample {

    public static void main(String[] args) {
        
        DefaultApi apiInstance = new DefaultApi();
        Boolean full = true; // Boolean | Return the curren status of the API.
        try {
            APIStatus result = apiInstance.statusAPI(full);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#statusAPI");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8100/v1/apis/rudik*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**statusAPI**](docs/DefaultApi.md#statusAPI) | **GET** /_status | Status of APIs
*ExampleApi* | [**exampleGeneration**](docs/ExampleApi.md#exampleGeneration) | **POST** /example/generation | Positive and Negative Example Generation
*ExampleApi* | [**exampleType**](docs/ExampleApi.md#exampleType) | **POST** /example/type | Most Common Type Example Generation
*RuleApi* | [**instantiateRule**](docs/RuleApi.md#instantiateRule) | **POST** /rule/instantiate | Horn Rules Instantiation over the Graph
*RuleApi* | [**mineRule**](docs/RuleApi.md#mineRule) | **POST** /rule/mine | Horn Rules Mining


## Documentation for Models

 - [APIStatus](docs/APIStatus.md)
 - [EntityPair](docs/EntityPair.md)
 - [ErrorModel](docs/ErrorModel.md)
 - [GraphSpecification](docs/GraphSpecification.md)
 - [HornRule](docs/HornRule.md)
 - [HornRuleAtom](docs/HornRuleAtom.md)
 - [HornRuleBody](docs/HornRuleBody.md)
 - [KeyValuePair](docs/KeyValuePair.md)
 - [RelationPrefix](docs/RelationPrefix.md)
 - [RuleExample](docs/RuleExample.md)
 - [RuleInstantiation](docs/RuleInstantiation.md)
 - [RuleResult](docs/RuleResult.md)
 - [RuleSpecification](docs/RuleSpecification.md)
 - [RuleStatistics](docs/RuleStatistics.md)
 - [RuleStatus](docs/RuleStatus.md)
 - [Status](docs/Status.md)
 - [VariableBinding](docs/VariableBinding.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author

stefano.ortona@meltwater.com

