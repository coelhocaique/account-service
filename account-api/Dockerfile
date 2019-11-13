FROM openjdk:11

LABEL source="https://github.com/coelhocaique/finance"\
      maintainer="Caique Coelho"

ADD ./build/distributions/*.zip /account-api.zip

RUN unzip account-api.zip && \
   rm -rf *.zip && \
   mv account-api-* account-api

EXPOSE 80 443

ENTRYPOINT [ "/account-api/bin/account-api" ]
