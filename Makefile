.PHONY: test_server, test_client, test

test_server:
	cd server && ./gradlew test

test_client:
	cd client && ng test --watch=false

test:
	make test_server && make test_client
