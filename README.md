# Leanplum SDK for Java

Uses Retrofit to encapsulate the Leanplum API.

<a href="https://travis-ci.org/scopely/leanplum-java-sdk"><img src="https://travis-ci.org/scopely/leanplum-java-sdk.svg" /></a>
[ ![Download](https://api.bintray.com/packages/avram/Scopely/leanplum-java-sdk/images/download.svg) ](https://bintray.com/avram/Scopely/leanplum-java-sdk/_latestVersion)

The SDK is hosted on Bintray, to use it in your build, add the Maven repository to your repositories list:

```
repositories {
    maven {
        url  "http://dl.bintray.com/avram/Scopely" 
    }
}
```

For details of versions and how to download releases, see https://bintray.com/avram/Scopely/leanplum-java-sdk

## API Coverage

* Track
* Advance
* Multi

## Testing
Make sure to set the environment variables `LEANPLUM_APP_ID` and `LEANPLUM_KEY` to
a set of valid development credentials in order to run the tests. You should use
a sandbox test app for this.
