# About env details
We should install docker 25.0.4, git, [jdk](https://corretto.aws/downloads/latest/amazon-corretto-8-x64-linux-jdk.tar.gz), [maven](https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz), [mysql](https://blog.csdn.net/qq_36590033/article/details/124817624) on both Local and Cloud Platform.

And config jkd's env, config mvn' env, config mvn's repo to some mirrors[depend on which country], mysql's many stuff, on both Local and Cloud Platform.

# How to run/deploy this project
## 1.Run this project on local

Config local machine's ssh public key to GitHub repository's Deploy keys.

```Bash
rm -rf /dir/to/some_path
mkdir -p /dir/to/some_path
cd /dir/to/some_path
git clone git@github.com:loveprolife/BookManageBackend.git
```

Change spring.profiles.active' value of /dir/to/some_path/BookManageBackend/eureka/src/main/resources/application.yml to dev.

Change spring.profiles.active' value of /dir/to/some_path/BookManageBackend/bookprovider/src/main/resources/application.yml to dev.

Change spring.profiles.active' value of /dir/to/some_path/BookManageBackend/bookconsumer/src/main/resources/application.yml to dev.

```Bash
cd /dir/to/some_path/BookManageBackend
mvn clean
cd /dir/to/some_path/BookManageBackend/eureka
mvn clean install package
cd /dir/to/some_path/BookManageBackend/bookprovider
mvn clean install package
cd /dir/to/some_path/BookManageBackend/bookconsumer
mvn clean install package
```

```Bash
cd /dir/to/some_path/BookManageBackend
java -jar ./eureka/target/eureka-0.0.1-SNAPSHOT.jar &
java -jar ./bookprovider/target/bookprovider-0.0.1-SNAPSHOT.jar &
java -jar ./bookconsumer/target/bookconsumer-0.0.1-SNAPSHOT.jar &
```

## 2.Deploy this project to Prod(use the CI/CD tools GitHub Actions)

### 2.1.Config ssh stuff.

#### 2.1.1.Config the ssh public key on deployed machine to GitHub repository's Deploy keys.

#### 2.1.2.Copy the ssh private key on deployed machine to GitHub repository's Secret.

#### 2.1.3.Append the ssh public key on deployed machine to its ~/.ssh/authorized_keys

### 2.2.Make sure spring.profiles.active' value is prod and push this change.

Change spring.profiles.active' value of /dir/to/some_path/BookManageBackend/eureka/src/main/resources/application.yml to prod.

Change spring.profiles.active' value of /dir/to/some_path/BookManageBackend/bookprovider/src/main/resources/application.yml to prod.

Change spring.profiles.active' value of /dir/to/some_path/BookManageBackend/bookconsumer/src/main/resources/application.yml to prod.

Git push this change to main branch.

### 2.3.1.When some change committed to Main branch, the deploy GitHub Actions will automatically run.

### 2.3.2.Or manually run the GitHub Actions /dir/to/some_path/BookManageBackend/.github/workflows/deploy_to_prod.yml to deploy.

git add . && git commit -m "aaa" && git push origin main

# Details about this project

Use Java to coded this project, it is a microservice-based application, and it is a containerized application, we can deploy it to Cloud Platform(Aliyun in China), or we can run it on Local, and the automated CI/CD pipeline implemented with GitHub Actions.

Skill list: Spring Boot + Spring Cloud + Mybatis + MySql + Docker + GitHub Actions + Aliyun Cloud Platform.
