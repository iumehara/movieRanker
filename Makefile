.PHONY: test_server, test_client, test

test_server:
	cd server && ./gradlew test

test_client:
	cd client && ng test --watch=false

test:
	make test_server && make test_client

build:
	cd client && ng build --prod && cp dist/movie-ranker/index.html ../server/src/main/resources/templates/ && cp -r dist/movie-ranker/* ../server/src/main/resources/static/
