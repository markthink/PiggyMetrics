BASE_IMAGE=cargo.caicloudprivatetest.com/qatest/pig-
BASE_VERSION=v2.0


all: build-containers

build:
	docker run -it --rm --name my-maven-project \
	               -v "$$PWD":/usr/src/mymaven  \
	               -v "$$HOME/.m2":/root/.m2    \
	               -w /usr/src/mymaven          \
	               maven:3.5.2-jdk-8-alpine mvn clean install  -Dmaven.test.skip=true

build-containers: build

	@for target in $(shell ls -lh|grep ^d|awk '{print $$NF}'); do   \
	  cd $(PWD)/$${target} ;                                        \
	  docker build -t $(BASE_IMAGE)$${target}:$(BASE_VERSION) . ;   \
	done

push:
	@for target in $(shell ls -lh|grep ^d|awk '{print $$NF}'); do   \
	  docker push  $(BASE_IMAGE)$${target}:$(BASE_VERSION) ;        \
	done



.PHONY: all build build-containers
