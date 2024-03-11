FROM amazonlinux:2

ARG version=1.8.0_402.b08-1
ARG MODULE_NAME

RUN set -eux \
    && export GNUPGHOME="$(mktemp -d)" \
    && curl -fL -o corretto.key https://yum.corretto.aws/corretto.key \
    && gpg --batch --import corretto.key \
    && gpg --batch --export --armor '6DC3636DAE534049C8B94623A122542AB04F24E3' > corretto.key \
    && rpm --import corretto.key \
    && rm -r "$GNUPGHOME" corretto.key \
    && curl -fL -o /etc/yum.repos.d/corretto.repo https://yum.corretto.aws/corretto.repo \
    && grep -q '^gpgcheck=1' /etc/yum.repos.d/corretto.repo \
    && echo "priority=9" >> /etc/yum.repos.d/corretto.repo \
    && yum install -y java-1.8.0-amazon-corretto-devel-$version \
    && (find /usr/lib/jvm/java-1.8.0-amazon-corretto -name src.zip -delete || true) \
    && yum install -y fontconfig \
    && yum clean all

COPY . /BookManageBackend

ENV LANG C.UTF-8
ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-amazon-corretto
ENV PATH=$JAVA_HOME/bin:$PATH

WORKDIR /BookManageBackend/${MODULE_NAME}

RUN mv target/${MODULE_NAME}-0.0.1-SNAPSHOT.jar target.jar

ENTRYPOINT ["java", "-jar", "target.jar"]
